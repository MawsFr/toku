package fr.lille1.univ.coo.tp.utilisateur.administrateur;

import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public interface IAdministrateurService {
	public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException;
	public void supprimerUtilisateur(int idUtilisateur);
	
	public void modifierPseudo(int idUtilisateur, String nouveauPseudo);
	public void modifierMotDePasse(int idUtilisateur, String nouveauMdp);
	public void modifierNom(int idUtilisateur, String nouveauNom);
	public void modifierPrenom(int idUtilisateur, String nouveauPrenom);

}
