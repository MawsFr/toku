package nezzari.projects.utilisateur.administrateur;

import nezzari.projects.utilisateur.Utilisateur;
import nezzari.projects.utilisateur.moderateur.Moderateur;

public class Administrateur extends Moderateur implements IAdministrateurService {

	@Override
	public void modifierPseudo(int idUtilisateur, String nouveauPseudo) {
		
	}

	@Override
	public void creerUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerUtilisateur(int idUtilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierMotDePasse(int idUtilisateur, String nouveauMdp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierNom(int idUtilisateur, String nouveauNom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierPrenom(int idUtilisateur, String nouveauPrenom) {
		// TODO Auto-generated method stub
		
	}

}
