package fr.lille1.univ.coo.tp.observateur;

import java.util.HashSet;
import java.util.Set;

/**
 * Cette classe represente un element observer.
 * @author Mustapha Nezzari
 *
 */
@SuppressWarnings(value = {"rawtypes", "unchecked"})
public class Observable {
	private Set<Observateur> observateurs;
	
	/**
	 * Constructeur par defaut.
	 */
	public Observable() {
		this.observateurs = new HashSet<>();
	}
	
	/**
	 * Ajoute un observateur.
	 * @param observateur Le nouvel observateur
	 */
	public void ajouterObservateur(Observateur observateur) {
		this.observateurs.add(observateur);
	}
	
	/**
	 * Supprime un observateur
	 * @param observateur L'observateur e supprimer.
	 */
	public void supprimerObservateur(Observateur observateur) {
		this.observateurs.remove(observateur);
	}
	
	/**
	 * Notifie les observateurs d'un changement dans l'objet.
	 */
	public void notifierModification(String propriete) {
		for(Observateur observateur : observateurs) {
			observateur.modification(this, propriete);
		}
	}
	
	/**
	 * Notifie les observateurs de la création d'un objet.
	 */
	public void notifierCreation(Object cree) {
		for(Observateur observateur : observateurs) {
			observateur.creation(cree);
		}
	}
	
	/**
	 * Notifie les observateurs de la création d'un objet.
	 */
	public void notifierSuppression(Object supprime) {
		for(Observateur observateur : observateurs) {
			observateur.suppression(supprime);
		}
	}
	
	/**
	 * Retourne la liste des observateurs.
	 * @return La liste des observateurs.
	 */
	public Set<Observateur> getObservateurs() {
		return observateurs;
	}
	
}
