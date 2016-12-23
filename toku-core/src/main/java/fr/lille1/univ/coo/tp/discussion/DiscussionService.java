
package fr.lille1.univ.coo.tp.discussion;

import java.util.Date;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.cryptage.CryptageException;
import fr.lille1.univ.coo.tp.cryptage.CrypteurROT13;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.message.Message;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.unitofwork.UnitOfWork;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class DiscussionService extends Service<Discussion> implements IDiscussionService {
	private static IDiscussionService instance;

	protected DiscussionService() {
	}

	public static IDiscussionService getInstance() {
		if (instance == null) {
			instance = new DiscussionService();
		}

		return instance;
	}

	@Override
	public Discussion creerDiscussion(String string, int type) throws ServiceException {
		Utilisateur moderateur = Application.getInstance().getSession().getUtilisateur();

		Discussion discussion = new Discussion();
		discussion.setNom(string);
		discussion.setModerateur(moderateur);
		discussion.setLeType(type);

		UnitOfWork.getInstance(Discussion.class).creation(discussion);
		return discussion;
	}
	
	@Override
	public void supprimerDiscussion(IDiscussion discussion) throws ServiceException {
		Utilisateur utilisateur = Application.getInstance().getSession().getUtilisateur();
		if(!Service.getUtilisateurService().estAdministrateur(utilisateur) && !Service.getUtilisateurService().estModerateur(discussion, utilisateur)) {
			throw new ServiceException("Vous n'avez pas les droits (admin / modo) pour supprimer cette discussion");
		}
		UnitOfWork.getInstance(Discussion.class).suppression(discussion);
	}

	@Override
	public void ajouterUtilisateur(IDiscussion discussion, IUtilisateur utilisateur, Integer etat)
			throws ServiceException {
		if(discussion.getMembres().contains(utilisateur)) {
			throw new ServiceException("Cet ami est déjà dans la discussion !");
		}
		AffectationDiscussion affectationDiscussion = new AffectationDiscussion();
		affectationDiscussion.setDiscussion(discussion);
		affectationDiscussion.setUtilisateur(utilisateur);
		affectationDiscussion.setEtat(etat);
		utilisateur.getAffectations().ajouter(affectationDiscussion);
		discussion.getAffectations().ajouter(affectationDiscussion);
	}
	
	@Override
	public void supprimerUtilisateur(AffectationDiscussion affectation, IDiscussion discussion, boolean passerDroitModo) throws ServiceException {
		Utilisateur utilisateur = Application.getInstance().getSession().getUtilisateur();
		
		if(affectation == null) {
			throw new ServiceException("Veuillez selectionner une personne à enlever de la discussion");
		}
//		if(affectation.getUtilisateur().equals(utilisateur) && discussion.getAffectations().getListe().size() > 1) {
//			throw new ServiceException("Vous ne pouvez pas vous retirer du groupe tant qu'il reste d'autres personnes");
//		}
		if(affectation.getUtilisateur().equals(discussion.getModerateur()) && discussion.getAffectations().getListe().size() > 1) {
			if(utilisateur.equals(affectation.getUtilisateur())) {
				throw new ServiceException("Vous ne pouvez pas vous retirer du groupe tant qu'il reste des gens");
			} else {
				if(passerDroitModo) {
					for(AffectationDiscussion a : discussion.getAffectations().getListe()) {
						if(!a.getUtilisateur().equals(utilisateur)) {
							passerDroitModo(discussion, a.getUtilisateur());
							break;
						}
					}
				} else {
					throw new ServiceException("Vous ne pouvez pas retirer le modérateur du groupe tant qu'il reste des gens");
				}
				
			}
		}
		
		discussion.getAffectations().supprimer(affectation);
		affectation.getUtilisateur().getAffectations().supprimer(affectation);
		validerAffectations();
		if (discussion.getAffectations().getListe().isEmpty()) {
			supprimerDiscussion(discussion);
			validerDiscussions();
		}
	}
	
	@Override
	public void envoyerMessage(IDiscussion discussion, String texte, Boolean accuse, Boolean prioritaire,
			Boolean chiffre, Integer expire) throws ServiceException {
		Message message = new Message();
		message.setDiscussion(discussion);
		message.setUtilisateur(Application.getInstance().getSession().getUtilisateur());
		try {
			message.setTexte(chiffre ? new CrypteurROT13().crypter(texte) : texte);
		} catch (CryptageException e) {
			e.printStackTrace();
			throw new ServiceException("Erreur lors du cryptage", e);
		}
		message.setDate_creation(new Date());
		message.setAccuse_reception(accuse);
		message.setChiffre(chiffre);
		message.setExpiration(expire);
		message.setPrioritaire(prioritaire);
		message.setLu(false);

		discussion.getMessages().ajouter(message);
		// Mettre a jour l'etat des affectations
		for(AffectationDiscussion affectationDiscussion : discussion.getAffectations().getListe()) {
			if(!affectationDiscussion.getUtilisateur().equals(Application.getInstance().getSession().getUtilisateur())) {
				affectationDiscussion.setEtat(AffectationDiscussion.ETAT_NOUVEAUX_MESSAGES);
			}
		}
		validerMessages();
		validerAffectations();
	}
	
	@Override
	public void supprimerNotifDiscussion(AffectationDiscussion affectation) throws ServiceException {
		if(affectation.getEtat().equals(AffectationDiscussion.ETAT_NOUVELLE_DISCUSSION)) {
			affectation.setEtat(AffectationDiscussion.ETAT_VU);
		}
		if(affectation.getEtat().equals(AffectationDiscussion.ETAT_NOUVEAUX_MESSAGES)) {
			affectation.setEtat(AffectationDiscussion.ETAT_OUVERTE);
		}
		validerAffectations();
	}

	@Override
	public void lireMessage(Message message) throws ServiceException {
		message.setLu(true);
		validerMessages();
	}
	
	@Override
	public IDiscussion rechercherDiscussionPriveeAvec(IUtilisateur ami) {
		/* select * from projet_discussion d
		join projet_utilisateur_discussion a1 on d.id = a1.id_discussion 
		join projet_utilisateur_discussion a2 on d.id = a2.id_discussion 
		where ((a1.id_utilisateur = 1 and a2.id_utilisateur = 5) or (a1.id_utilisateur = 5 and a2.id_utilisateur = 1)) and d.leType = 2
		group by d.id
		 * 
		 * */
		
		Utilisateur utilisateur = Application.getInstance().getSession().getUtilisateur();
		for(AffectationDiscussion affectation : utilisateur.getAffectations().getListe()) {
			IDiscussion discussion = affectation.getDiscussion();
			if(discussion.getLeType().equals(Discussion.TYPE_PRIVE) && discussion.getMembres().contains(utilisateur) && discussion.getMembres().contains(ami)) {
				return discussion;
			}
		}
		
		return null;

	}
	
	@Override
	public void passerDroitModo(IDiscussion discussion, IUtilisateur utilisateur) throws ServiceException {
		discussion.setModerateur(utilisateur);
		validerDiscussions();
	}

	@Override
	public void validerMessages() throws ServiceException {
		try {
			UnitOfWork.getInstance(Message.class).commit();
		} catch (DomainException e) {
			e.printStackTrace();
			annulerMessage();
			throw new ServiceException(e);
		}
	}

	@Override
	public void validerDiscussions() throws ServiceException {
		try {
			UnitOfWork.getInstance(Discussion.class).commit();
		} catch (DomainException e) {
			e.printStackTrace();
			annulerDiscussion();
			throw new ServiceException(e);
		}
	}

	@Override
	public void validerAffectations() throws ServiceException {
		try {
			UnitOfWork.getInstance(AffectationDiscussion.class).commit();
		} catch (DomainException e) {
			e.printStackTrace();
			annulerAffectation();
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void annulerDiscussion() {
		UnitOfWork.getInstance(Discussion.class).annuler();
	}
	
	@Override
	public void annulerAffectation() {
		UnitOfWork.getInstance(AffectationDiscussion.class).annuler();
	}
	@Override
	public void annulerMessage() {
		UnitOfWork.getInstance(Message.class).annuler();
	}

	

}
