package nezzari.projects.utilisateur.administrateur;

import nezzari.projects.utilisateur.Utilisateur;

public interface IAdministrateurService {
	public void creerUtilisateur(Utilisateur utilisateur);
	public void supprimerUtilisateur(int idUtilisateur);
	
	public void modifierPseudo(int idUtilisateur, String nouveauPseudo);
	public void modifierMotDePasse(int idUtilisateur, String nouveauMdp);
	public void modifierNom(int idUtilisateur, String nouveauNom);
	public void modifierPrenom(int idUtilisateur, String nouveauPrenom);

}
