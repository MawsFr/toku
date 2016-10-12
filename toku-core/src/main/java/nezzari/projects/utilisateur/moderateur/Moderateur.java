package nezzari.projects.utilisateur;

import nezzari.projects.factory.DAOFactory;

public class Moderateur extends Utilisateur implements RoleModerateur {

	@Override
	public void quitterGroupe(int idGroupe) {
		if(DAOFactory.getGroupeDAO().estVide(idGroupe)) {
			super.quitterGroupe(idGroupe);
		} else {
			//throw exception
		}
	}

	@Override
	public void ajouterAmiAuGroupe(int idAmi, int idGroupe) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerAmiDuGroupe(int idAmi, int idGroupe) {
		// TODO Auto-generated method stub

	}

	@Override
	public void passerDroitModerateurA(int idAmi, int idGroupe) {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerGroupe(int idGroupe) {
		// TODO Auto-generated method stub
		
	}



}
