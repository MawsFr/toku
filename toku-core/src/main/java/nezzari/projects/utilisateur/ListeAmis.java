package nezzari.projects.utilisateur;

import java.util.ArrayList;
import java.util.List;

public class ListeAmis {
	
	private Utilisateur utilisateur;
	private List<Utilisateur> amis;
	
	public ListeAmis() {
		this.amis = new ArrayList<>();
	}
	
	public ListeAmis(Utilisateur utilisateur) {
		this();
		this.utilisateur = utilisateur;
	}
	
	public ListeAmis(Utilisateur utilisateur, List<Utilisateur> amis) {
		this.amis = amis;
		this.utilisateur = utilisateur;
	}
	
	public void ajouter(Utilisateur ami) {
		this.amis.add(ami);
	}
	
	public void supprimer(Utilisateur ami) {
		this.amis.remove(ami);
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Utilisateur> getListe() {
		return amis;
	}

	public void setAmis(List<Utilisateur> amis) {
		this.amis = amis;
	}

}
