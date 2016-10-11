package nezzari.projects;

import nezzari.projects.utilisateur.Utilisateur;

public class Session {
	
	private Utilisateur utilisateur;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
