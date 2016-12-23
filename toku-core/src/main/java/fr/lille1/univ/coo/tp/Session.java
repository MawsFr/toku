package fr.lille1.univ.coo.tp;

import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

/**
 * cette classe représente une session utilisateur
 * @author Maws
 *
 */
public class Session {
	
	private Utilisateur utilisateur;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
