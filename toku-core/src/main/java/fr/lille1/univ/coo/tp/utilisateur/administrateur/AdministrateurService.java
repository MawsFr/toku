package fr.lille1.univ.coo.tp.utilisateur.administrateur;

import fr.lille1.univ.coo.tp.cryptage.CryptageException;
import fr.lille1.univ.coo.tp.cryptage.CrypteurMD5;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class AdministrateurService implements IAdministrateurService {

	private static IAdministrateurService instance;

	private AdministrateurService() {
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
			new DAOGenerique<Utilisateur>(Utilisateur.class).creer(utilisateur);
		} catch (CryptageException | DAOException e) {
			throw new ServiceException(e);
		}
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
