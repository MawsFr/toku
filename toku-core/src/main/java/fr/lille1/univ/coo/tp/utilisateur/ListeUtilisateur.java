package fr.lille1.univ.coo.tp.utilisateur;

import java.util.ArrayList;
import java.util.List;

import fr.lille1.univ.coo.tp.observateur.Observable;

public class ListeUtilisateur extends Observable {
	
	private List<Utilisateur> utilisateurs;
	
	public ListeUtilisateur() {
		this.utilisateurs = new ArrayList<>();
	}
	
	public void ajouter(Utilisateur utilisateur) {
		this.utilisateurs.add(utilisateur);
		notifierCreation(utilisateur);
	}
	
	public void supprimer(Utilisateur utilisateur) {
		this.utilisateurs.remove(utilisateur);
		notifierSuppression(utilisateur);
	}

	/**
	 * @return Le utilisateurs
	 */
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	/**
	 * @param utilisateurs Le nouveau utilisateurs
	 */
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	
	
}
