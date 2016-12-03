package fr.lille1.univ.coo.tp.filtre;

import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class ALeNom implements Filtre<Utilisateur> {
	
	private String nom;
	
	public ALeNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public boolean accepte(Utilisateur utilisateur) {
		return utilisateur.getNom().contains(nom);
	}

}
