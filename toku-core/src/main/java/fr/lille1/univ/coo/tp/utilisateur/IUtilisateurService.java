package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.discussion.IDiscussion;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.validateur.ValidationException;

public interface IUtilisateurService {
	public IUtilisateur connecter(String pseudo, String motDePasse) throws ServiceException, ValidationException;
	public void deconnecter();
	
	public void modifierMotDePasse(int idUtilisateur, String nouveauMdp);
	public void modifierNom(int idUtilisateur, String nouveauNom);
	public void modifierPrenom(int idUtilisateur, String nouveauPrenom);
	
	public void demanderEnAmi(IUtilisateur destinataire) throws ServiceException;
	public void accepterDemandeAmi(Amitie demande) throws ServiceException;
	public void refuserDemandeAmi(Amitie demande) throws ServiceException;
	public void supprimerNotifAmi(Amitie demande) throws ServiceException;
	public void supprimerAmi(Amitie ami);
	public void validerAmi() throws ServiceException;
	boolean estModerateur(IDiscussion discussion, IUtilisateur utilisateur);
	boolean estAdministrateur(IUtilisateur utilisateur) throws ServiceException;
	IObservableList<Utilisateur> rechercherTout() throws ServiceException;
	public void supprimer(Utilisateur utilisateur, IObservableList<Utilisateur> liste) throws ServiceException;
	void validerChangements() throws ServiceException;
	String getMotDePasse(Utilisateur selectionne) throws ServiceException;
	
}
