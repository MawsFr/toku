package fr.lille1.univ.coo.tp.discussion;

import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;

public interface IDiscussionService {

	Discussion creerDiscussion(String string, int type) throws ServiceException;
	void ajouterUtilisateur(Discussion discussion, IUtilisateur iUtilisateur, Integer etat) throws ServiceException;
	void envoyerMessage(Discussion discussion, String texte) throws ServiceException;

}
