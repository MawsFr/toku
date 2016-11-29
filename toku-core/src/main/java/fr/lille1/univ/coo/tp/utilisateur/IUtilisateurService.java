package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.validateur.ValidationException;

public interface IUtilisateurService {
	public IUtilisateur connecter(String pseudo, String motDePasse) throws ServiceException, ValidationException;
	public void deconnecter();
	
	public void modifierMotDePasse(int idUtilisateur, String nouveauMdp);
	public void modifierNom(int idUtilisateur, String nouveauNom);
	public void modifierPrenom(int idUtilisateur, String nouveauPrenom);
	
	public void demanderEnAmi(int idDestinataire);
	public void accepterDemandeAmi(int idDemande);
	public void refuserDemandeAmi(int idDemande);
	public void supprimerAmi(int idAmi);
	
	public void creerDiscussion(String nom);
	public void creerDiscussionPrive(int idAmi);
	public void envoyerMessage(int idGroupe, String message);
	public void envoyerMessagePrive(int idGroupe, int idDestinataire, String message, boolean accuseReception, int expiration, boolean prioritaire, boolean chiffre);
	public void quitterGroupe(int idGroupe);
	
	public void lireMessage(int id);
	public void lireMessagePrive(int id);
	
	public void recevoirNotification(String texte);
	public void supprimerNotification(int id);
	
	public void ajouterCentreInteret(int id);
	public void creerCentreInteret(String nom);
	public boolean estAdministrateur(IUtilisateur utilisateur) throws ServiceException;
	
}
