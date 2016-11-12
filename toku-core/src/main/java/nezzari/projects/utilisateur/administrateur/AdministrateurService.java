package nezzari.projects.utilisateur.administrateur;

import nezzari.projects.cryptage.CryptageException;
import nezzari.projects.cryptage.CrypteurMD5;
import nezzari.projects.factory.DAOFactory;
import nezzari.projects.service.ServiceException;
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
	public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
		try {
			utilisateur.setMotDePasse(new CrypteurMD5().crypter(utilisateur.getMotDePasse()));
		} catch (CryptageException e) {
			throw new ServiceException(e);
		}
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
