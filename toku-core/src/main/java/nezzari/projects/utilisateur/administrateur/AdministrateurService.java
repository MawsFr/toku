package nezzari.projects.utilisateur.administrateur;

import nezzari.projects.utilisateur.Utilisateur;

public class AdministrateurService implements IAdministrateurService {

	private static IAdministrateurService instance;

	private AdministrateurService() {}

	public static IAdministrateurService getInstance() {
		if(instance == null) {
			instance = new AdministrateurService();
		}

		return instance;
	}

	@Override
	public void creerUtilisateur(Utilisateur utilisateur) {

	}

	@Override
	public void supprimerUtilisateur(int idUtilisateur) {

	}

	@Override
	public void modifierPseudo(int idUtilisateur, String nouveauPseudo) {

	}

	@Override
	public void modifierMotDePasse(int idUtilisateur, String nouveauMdp) {

	}

	@Override
	public void modifierNom(int idUtilisateur, String nouveauNom) {

	}

	@Override
	public void modifierPrenom(int idUtilisateur, String nouveauPrenom) {

	}

}
