package fr.lille1.univ.coo.tp.discussion;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
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
		
		moderateur.getDiscussions().ajouter(discussion);
		
		ajouterUtilisateur(discussion, moderateur);
		
		return discussion;
	}
	
	@Override
	public void ajouterUtilisateur(Discussion discussion, Utilisateur utilisateur) throws ServiceException {
		utilisateur.getDiscussions().ajouter(discussion);
		discussion.getMembres().ajouter(utilisateur);
		
	}

}
