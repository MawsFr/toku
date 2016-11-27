package fr.lille1.univ.coo.tp.vue.composants.fenetre;

/**
 * Cette classe permet d'implémenter une fonction qui annule certaines
 * opérations.
 */
public interface Annulable {
	/**
	 * Effectue les opérations nécessaire à l'annulation des modifications.
	 */
	public void annuler();

}
