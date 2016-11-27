package fr.lille1.univ.coo.tp.utilisateur.moderateur;

public class ModerateurService implements IModerateurService {
	
	private static IModerateurService instance;
	
	private ModerateurService() {}
	
	public static IModerateurService getInstance() {
		if(instance == null) {
			instance = new ModerateurService();
		}
		
		return instance;
	}

	@Override
	public void ajouterAmiAuGroupe(int idAmi, int idGroupe) {
		
	}

	@Override
	public void supprimerAmiDuGroupe(int idAmi, int idGroupe) {
		
	}

	@Override
	public void passerDroitModerateurA(int idAmi, int idGroupe) {
		
	}

	@Override
	public void supprimerGroupe(int idGroupe) {
//		if(DAOFactory.getGroupeDAO().estVide(idGroupe)) {
//			Service.getUtilisateurService().quitterGroupe(idGroupe);
//		} else {
//			//throw exception
//		}

	}

}
