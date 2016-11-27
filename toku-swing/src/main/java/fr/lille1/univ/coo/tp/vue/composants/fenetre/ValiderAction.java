package fr.lille1.univ.coo.tp.vue.composants.fenetre;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * Cette action permet d'appeller la fonction valider de toute fenetre disposant
 * d'un bouton de validation
 */
public class ValiderAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private Validable fenetre;

	/**
	 * Constructeur prenant en paramètre
	 * 
	 * @param fenetre
	 *            Une fenetre validable
	 * @param label
	 *            Le label du bouton de validation
	 */
	public ValiderAction(Validable fenetre, String label) {
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
		fenetre.valider();

	}

}
