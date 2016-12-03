package fr.lille1.univ.coo.tp.utilisateur.administrateur;

import java.util.HashMap;
import java.util.Map;

import fr.lille1.univ.coo.tp.cryptage.CryptageException;
import fr.lille1.univ.coo.tp.cryptage.CrypteurMD5;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;
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
	public String getMotDePasse(Utilisateur selectionne) throws ServiceException {
		Map<String, Object> conditions = new HashMap<>();
		conditions.put("id", selectionne.getId());
		try {
			return (String) new DAOGenerique<>(Utilisateur.class).rechercherUneProprieteUnSeul("mot_de_passe", conditions);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e);
		}
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
