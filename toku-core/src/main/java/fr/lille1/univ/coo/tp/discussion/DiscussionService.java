package fr.lille1.univ.coo.tp.discussion;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.discussion.message.Message;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.service.unitofwork.UnitOfWork;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class DiscussionService extends Service<Discussion> implements IDiscussionService {
	private static IDiscussionService instance;
	
	protected DiscussionService() {
	}
	
	public static IDiscussionService getInstance() {
		if(instance == null) {
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
		try {
			UnitOfWork.getInstance(Discussion.class).commit();
		} catch (DomainException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		
		ajouterUtilisateur(discussion, moderateur, AffectationDiscussion.ETAT_LU);
		
		return discussion;
	}
	
	@Override
	public void ajouterUtilisateur(Discussion discussion, IUtilisateur utilisateur, Integer etat) throws ServiceException {
		AffectationDiscussion affectationDiscussion = new AffectationDiscussion();
		affectationDiscussion.setDiscussion(discussion);
		affectationDiscussion.setUtilisateur(utilisateur);
		affectationDiscussion.setEtat(etat);
		utilisateur.getAffectations().ajouter(affectationDiscussion);
		discussion.getAffectations().ajouter(affectationDiscussion);
	}
	
	@Override
	public void envoyerMessage(Discussion discussion, String texte) throws ServiceException {
		Message message = new Message();
		message.setDiscussion(discussion);
		message.setUtilisateur(Application.getInstance().getSession().getUtilisateur());
		message.setTexte(texte);
		
		discussion.getMessages().ajouter(message);
		try {
			UnitOfWork.getInstance(Message.class).commit();
		} catch (DomainException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		
	}

}
