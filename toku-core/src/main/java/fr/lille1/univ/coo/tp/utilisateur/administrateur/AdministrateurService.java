package fr.lille1.univ.coo.tp.utilisateur.administrateur;

import fr.lille1.univ.coo.tp.domain.DomainException;
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
	public void validerCreationUtilisateur() throws ServiceException {
		try {
			UnitOfWork.getInstance(Utilisateur.class).commit();
		} catch (DomainException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void validerSuppressionUtilisateur() throws ServiceException {
		try {
			UnitOfWork.getInstance(Utilisateur.class).commit();
		} catch (DomainException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
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
