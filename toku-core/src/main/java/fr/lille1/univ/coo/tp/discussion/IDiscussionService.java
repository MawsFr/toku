package fr.lille1.univ.coo.tp.discussion;

import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public interface IDiscussionService {

	Discussion creerDiscussion(String string, int type) throws ServiceException;
	void ajouterUtilisateur(Discussion discussion, Utilisateur utilisateur) throws ServiceException;

}
