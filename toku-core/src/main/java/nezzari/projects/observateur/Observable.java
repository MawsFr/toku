package nezzari.projects.observateur;

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
	public void ajouter(Observateur observateur) {
		this.observateurs.add(observateur);
	}
	
	/**
	 * Supprime un observateur
	 * @param observateur L'observateur e supprimer.
	 */
	public void supprimer(Observateur observateur) {
		this.observateurs.remove(observateur);
	}
	
	/**
	 * Notifie les observateurs d'un changement dans l'objet.
	 */
	public void notifier() {
		for(Observateur observateur : observateurs) {
			observateur.modification(this);
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
