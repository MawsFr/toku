package fr.lille1.univ.coo.tp.observateur;

/**
 * Cette classe represente un observateur qui reagit au changement d'objet qu'il
 * observe.
 * 
 * @author Mustapha Nezzari
 *
 * @param <T> Le type d'objet a observer
 */
public interface Observateur<T> {
	/**
	 * Reagit a la modification d'un objet.
	 * 
	 * @param objet
	 *            L'objet qui a ete modifie.
	 */
	public void modification(T objet, String propriete);

	/**
	 * Reagit a la creation d'un objet.
	 * 
	 * @param objet
	 *            L'objet qui a ete cree.
	 */
	public void creation(T objet);

	/**
	 * Reagit a la suppression d'un objet.
	 * 
	 * @param objet
	 *            L'objet qui a ete supprime.
	 * @param supprime 
	 */
	public void suppression(T objet);

}
