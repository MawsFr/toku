package fr.lille1.univ.coo.tp.groupe;

import java.util.List;

import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class ListeGroupe {
	
	private Utilisateur utilisateur;
	private List<Groupe> groupes;
	
	public ListeGroupe() {}
	
	public ListeGroupe(Utilisateur utilisateur, List<Groupe> groupes) {
		this.groupes = groupes;
		this.utilisateur = utilisateur;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Groupe> getAmis() {
		return groupes;
	}

	public void setAmis(List<Groupe> amis) {
		this.groupes = amis;
	}

	


}