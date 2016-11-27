package fr.lille1.univ.coo.tp.utilisateur.moderateur;

public interface IModerateurService {
	public void ajouterAmiAuGroupe(int idAmi, int idGroupe);
	public void supprimerAmiDuGroupe(int idAmi, int idGroupe);
	public void passerDroitModerateurA(int idAmi, int idGroupe);
	public void supprimerGroupe(int idGroupe);

}
