package nezzari.projects.utilisateur.administrateur;

import nezzari.projects.factory.DAOFactory;
import nezzari.projects.utilisateur.IUtilisateurDAO;
import nezzari.projects.utilisateur.Utilisateur;

public class AdministrateurService implements IAdministrateurService {

	private static IAdministrateurService instance;
	private IUtilisateurDAO dao;

	private AdministrateurService() {
		this.dao = DAOFactory.getUtilisateurDAO();
	}

	public static IAdministrateurService getInstance() {
		if(instance == null) {
			instance = new AdministrateurService();
		}

		return instance;
	}

	@Override
	public void creerUtilisateur(Utilisateur utilisateur) {
		dao.creer(utilisateur);
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
