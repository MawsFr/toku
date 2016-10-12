package nezzari.projects.utilisateur.moderateur;

import nezzari.projects.factory.DAOFactory;
import nezzari.projects.utilisateur.UtilisateurService;

public class ModerateurService extends UtilisateurService implements IModerateurService {

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
		if(DAOFactory.getGroupeDAO().estVide(idGroupe)) {
			super.quitterGroupe(idGroupe);
		} else {
			//throw exception
		}

	}

}
