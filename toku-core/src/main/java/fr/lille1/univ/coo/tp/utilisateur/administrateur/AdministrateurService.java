package fr.lille1.univ.coo.tp.utilisateur.administrateur;

import fr.lille1.univ.coo.tp.cryptage.CryptageException;
import fr.lille1.univ.coo.tp.cryptage.CrypteurMD5;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.service.unitofwork.UnitOfWork;
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
	public Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, Role role, String motDePasse) throws ServiceException {
		final Utilisateur utilisateur = new Utilisateur(role, pseudo, motDePasse, nom, prenom, null);
		try {
			utilisateur.setMotDePasse(new CrypteurMD5().crypter(motDePasse));
		} catch (CryptageException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return utilisateur;
	}

	@Override
	public String getMotDePasse(Utilisateur selectionne) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validerChangements() throws ServiceException {
		try {
			UnitOfWork.getInstance(Utilisateur.class).commit();
		} catch (DomainException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}

	
	
	

}
