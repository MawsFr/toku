package nezzari.projects.critere;

import nezzari.projects.utilisateur.Utilisateur;

public class ALeNom implements Critere<Utilisateur> {
	
	private String nom;
	
	public ALeNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public boolean estVerifie(Utilisateur vin) {
		return nom.equals(vin.getNom());
	}

}
