package fr.lille1.univ.coo.tp.discussion;

import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;

public interface IDiscussionService {

	Discussion creerDiscussion(String string, int type) throws ServiceException;
	void ajouterUtilisateur(IDiscussion discussion, IUtilisateur iUtilisateur, Integer etat) throws ServiceException;
	void supprimerUtilisateur(AffectationDiscussion affectation, IDiscussion discussion, IUtilisateur iUtilisateur) throws ServiceException;
	void envoyerMessage(IDiscussion discussion, String texte, Boolean accuse, Boolean prioritaire, Boolean chiffre, Integer expire) throws ServiceException;
	void validerDiscussions() throws ServiceException;
	void validerAffectations() throws ServiceException;
	void validerMessages() throws ServiceException;
	IDiscussion rechercherDiscussionPriveeAvec(IUtilisateur iUtilisateur);
	void supprimerDiscussion(IDiscussion discussion) throws ServiceException;
}
