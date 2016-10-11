package nezzari.projects.utilisateur;

public interface RoleModerateur {
	public void ajouterAmiAuGroupe(int idAmi, int idGroupe);
	public void supprimerAmiDuGroupe(int idAmi, int idGroupe);
	public void passerDroitModerateurA(int idAmi, int idGroupe);
	public void supprimerGroupe(int idGroupe);

}
