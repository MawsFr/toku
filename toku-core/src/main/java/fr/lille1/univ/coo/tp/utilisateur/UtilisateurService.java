package fr.lille1.univ.coo.tp.utilisateur;

import java.util.HashMap;
import java.util.Map;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.Session;
import fr.lille1.univ.coo.tp.cryptage.CryptageException;
import fr.lille1.univ.coo.tp.cryptage.CrypteurMD5;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
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
	public Utilisateur connecter(String pseudo, String motDePasse) throws ServiceException, ValidationException {
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
	}
	
	@Override
	public boolean estAdministrateur(Utilisateur utilisateur) throws ServiceException {
//		Role role;
//		try {
//			role = Role.values()[dao.getRole(utilisateur) - 1];
//		} catch (DAOException e) {
//			throw new ServiceException(e);
//		}
//		return role == Role.ADMINISTRATEUR;
		return true;
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
	public void demanderEnAmi(int idDestinataire) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accepterDemandeAmi(int idDemande) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refuserDemandeAmi(int idDemande) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerAmi(int idAmi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void creerDiscussion(String nom) {
		// TODO Auto-generated method stub

	}

	@Override
	public void creerDiscussionPrive(int idAmi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void envoyerMessage(int idGroupe, String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void envoyerMessagePrive(int idGroupe, int idDestinataire, String message, boolean accuseReception,
			int expiration, boolean prioritaire, boolean chiffre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void quitterGroupe(int idGroupe) {
		// TODO Auto-generated method stub

	}

	@Override
	public void lireMessage(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void lireMessagePrive(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recevoirNotification(String texte) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerNotification(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ajouterCentreInteret(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void creerCentreInteret(String nom) {
		// TODO Auto-generated method stub

	}

}
