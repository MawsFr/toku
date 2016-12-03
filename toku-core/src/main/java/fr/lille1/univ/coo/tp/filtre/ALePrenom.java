package fr.lille1.univ.coo.tp.filtre;

import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class ALePrenom implements Filtre<Utilisateur> {
	
	private String prenom;
	
	public ALePrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@Override
	public boolean accepte(Utilisateur utilisateur) {
		return utilisateur.getPrenom().contains(prenom);
	}

}
