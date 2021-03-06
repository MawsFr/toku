package fr.lille1.univ.coo.tp.utilisateur;

import java.util.HashMap;
import java.util.Map;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.Session;
import fr.lille1.univ.coo.tp.cryptage.CryptageException;
import fr.lille1.univ.coo.tp.cryptage.CrypteurMD5;
import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.discussion.IDiscussion;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.message.Message;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;
import fr.lille1.univ.coo.tp.persistance.References;
import fr.lille1.univ.coo.tp.persistance.requete.CritereEGALE;
import fr.lille1.univ.coo.tp.persistance.requete.CritereET;
import fr.lille1.univ.coo.tp.persistance.requete.Requete;
import fr.lille1.univ.coo.tp.proxy.factory.RechercherToutFactory;
import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.unitofwork.UnitOfWork;
import fr.lille1.univ.coo.tp.validateur.ValidationException;
import fr.lille1.univ.coo.tp.validateur.Valideur;

public class UtilisateurService extends Service<Utilisateur> implements IUtilisateurService {
	private static IUtilisateurService instance;
	
	protected UtilisateurService() {
	}
	
	public static IUtilisateurService getInstance() {
		if(instance == null) {
			instance = new UtilisateurService();
		}
		
		return instance;
	}

	@Override
	public IUtilisateur connecter(String pseudo, String motDePasse) throws ServiceException, ValidationException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPseudo(pseudo);
		utilisateur.setMotDePasse(motDePasse);
		try {
			Valideur.getConnexionValideur().valider(utilisateur);
			utilisateur.setMotDePasse(new CrypteurMD5().crypter(motDePasse));
			System.out.println(utilisateur.getMotDePasse());
			Map<String, Object> proprietes = new HashMap<>();
			proprietes.put("pseudo", utilisateur.getPseudo());
			proprietes.put("mot_de_passe", utilisateur.getMotDePasse());
			utilisateur = new DAOGenerique<Utilisateur>(Utilisateur.class).rechercherUnSeulParProprietes(proprietes);
			
			Session session = new Session();
			session.setUtilisateur(utilisateur);
			Application.getInstance().setSession(session);
		} catch (ValidationException | CryptageException e) {
			throw new ServiceException(e.getMessage(), e);
		} catch (DAOException e) {
			throw new ServiceException("Ces informations de connexion ne correspondent à aucun compte", e);
		}
		return utilisateur;
	}
	
	@Override
	public void deconnecter() {
		Application.getInstance().setSession(null);
		UnitOfWork.getInstance(AffectationDiscussion.class).annuler();
		UnitOfWork.getInstance(Amitie.class).annuler();
		UnitOfWork.getInstance(Message.class).annuler();
		UnitOfWork.getInstance(Discussion.class).annuler();
		UnitOfWork.getInstance(Utilisateur.class).annuler();
		UnitOfWork.getInstance(Role.class).annuler();
		
		References.getInstance().toutSupprimer();
		
	}
	
	@Override
	public IObservableList<Utilisateur> rechercherTout() throws ServiceException {
		try {
			return new RechercherToutFactory<Utilisateur>(Utilisateur.class).creer();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public boolean estAdministrateur(IUtilisateur utilisateur) throws ServiceException {
		try {
			return utilisateur.getRole().equals(new DAOGenerique<>(Role.class).rechercher(Role.ROLE_ADMINISTRATEUR));
		} catch (DAOException e) {
			throw new ServiceException("Erreur lors de la vérification des droits administrateurs", e);
		}
	}
	
	@Override
	public boolean estModerateur(IDiscussion discussion, IUtilisateur utilisateur) {
		return discussion.getModerateur().equals(utilisateur);
	}
	
	@Override
	public String getMotDePasse(Utilisateur selectionne) throws ServiceException {
		Map<String, Object> conditions = new HashMap<>();
		conditions.put("id", selectionne.getId());
		try {
			return (String) new DAOGenerique<>(Utilisateur.class).rechercherUneProprieteUnSeul("mot_de_passe", conditions);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void demanderEnAmi(IUtilisateur ami) throws ServiceException {
		Utilisateur utilisateur = Application.getInstance().getSession().getUtilisateur();
		if(ami.equals(utilisateur)) {
			throw new ServiceException("Vous ne pouvez pas vous ajouter vous même en ami !");
		}
		CritereET et = new CritereET();
		CritereEGALE egale1 = new CritereEGALE("id_utilisateur");
		CritereEGALE egale2 = new CritereEGALE("id_ami");
		et.ajouter(egale1);
		et.ajouter(egale2);
		Requete requete = Requete.selectionner(Amitie.class).where(et);
		
		Map<String, Object> clauseWhere = new HashMap<>();
		clauseWhere.put("id_utilisateur", utilisateur.getId());
		clauseWhere.put("id_ami", ami.getId());
		try {
			Amitie amitie = new DAOGenerique<Amitie>(Amitie.class).rechercherUnSeulParRequete(requete, clauseWhere);
			boolean creerLAmitie = false;
			if(amitie == null) {
				creerLAmitie = true;
			} else if (amitie.getEtat().equals(Amitie.ETAT_REFUSEE)) {
				new DAOGenerique<Amitie>(Amitie.class).supprimer(amitie);
				creerLAmitie = true;
			}
			if(creerLAmitie) {
				Amitie nouvelleAmitie = new Amitie();
				nouvelleAmitie.setUtilisateur(utilisateur);
				nouvelleAmitie.setAmi(ami);
				nouvelleAmitie.setEtat(Amitie.ETAT_EN_ATTENTE);
				nouvelleAmitie.setDemandeur(utilisateur);
				utilisateur.getAmitie().ajouter(nouvelleAmitie);
				validerAmi();
			} else {
				if(amitie.getEtat().equals(Amitie.ETAT_EN_ATTENTE)) {
					if(amitie.getDemandeur().equals(utilisateur)) {
						throw new ServiceException("Vous avez déjà invité " + ami.getPseudo());
					} else {
						throw new ServiceException(ami.getPseudo() + " vous a déjà invité, veuillez attendre qu'il accepte votre demande");
					}
				} else if (amitie.getEtat().equals(Amitie.ETAT_TRAITEE) || amitie.getEtat().equals(Amitie.ETAT_VALIDEE)) {
					throw new ServiceException("Vous êtes déjà amis avec cette personne");
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		} catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	@Override
	public void supprimer(Utilisateur utilisateur, IObservableList<Utilisateur> liste) throws ServiceException {
		for(AffectationDiscussion affectation : utilisateur.getAffectations().getListe()) {
			Service.getDiscussionService().supprimerUtilisateur(affectation, affectation.getDiscussion(), true);
		}
		for(Amitie amitie : Application.getInstance().getSession().getUtilisateur().getAmitie().getListe()) {
			if(amitie.getAmi().equals(utilisateur)) {
				supprimerAmi(amitie);
				break;
			}
		}
		liste.supprimer(utilisateur);
	}
	
	@Override
	public void accepterDemandeAmi(Amitie demande) throws ServiceException {
		demande.setEtat(Amitie.ETAT_VALIDEE);
		validerAmi();
	}
	
	@Override
	public void refuserDemandeAmi(Amitie demande) throws ServiceException {
		demande.setEtat(Amitie.ETAT_REFUSEE);
		validerAmi();
	}

	@Override
	public void supprimerNotifAmi(Amitie demande) throws ServiceException {
		demande.setEtat(Amitie.ETAT_TRAITEE);
		validerAmi();
	}
	
	@Override
	public void validerAmi() throws ServiceException {
		try {
			UnitOfWork.getInstance(Amitie.class).commit();
		} catch (DomainException e) {
			UnitOfWork.getInstance(Amitie.class).annuler();
			throw new ServiceException(e);
		}
	}

	
	@Override
	public void modifierMotDePasse(int idUtilisateur, String nouveauMdp) {

	}

	@Override
	public void modifierNom(int idUtilisateur, String nouveauNom) {
		
	}

	@Override
	public void modifierPrenom(int idUtilisateur, String nouveauPrenom) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerAmi(Amitie ami) {
		ami.getUtilisateur().getAmitie().supprimer(ami);
	}
	
	@Override
	public void validerChangements() throws ServiceException {
		try {
			UnitOfWork.getInstance(Utilisateur.class).commit();
		} catch (DomainException e) {
			UnitOfWork.getInstance(Utilisateur.class).annuler();
			throw new ServiceException(e);
		}
	}

	

}
