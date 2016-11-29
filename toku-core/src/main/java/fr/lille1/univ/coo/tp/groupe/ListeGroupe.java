package fr.lille1.univ.coo.tp.groupe;

import java.util.List;

import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;

public class ListeGroupe {
	
	private IUtilisateur utilisateur;
	private List<Discussion> groupes;
	
	public ListeGroupe() {}
	
	public ListeGroupe(IUtilisateur utilisateur, List<Discussion> groupes) {
		this.groupes = groupes;
		this.utilisateur = utilisateur;
	}
	
	public IUtilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(IUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Discussion> getAmis() {
		return groupes;
	}

	public void setAmis(List<Discussion> amis) {
		this.groupes = amis;
	}

	


}
