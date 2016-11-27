package fr.lille1.univ.coo.tp.vue.composants.fenetre;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Cette action permet d'appeller la fonction annuler de toute fenetre disposant
 * d'un bouton d'annulation
 */
public class AnnulerAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private Annulable fenetre;

	/**
	 * Constructeur prenant en paramètre
	 * 
	 * @param fenetre
	 *            Une fenetre annulable
	 * @param label
	 *            Le label du bouton annuler
	 */
	public AnnulerAction(Annulable fenetre, String label) {
		putValue(NAME, label);
		this.fenetre = fenetre;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		fenetre.annuler();

	}

}
