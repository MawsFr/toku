package fr.lille1.univ.coo.tp.controlleurs.accueil;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.vue.accueil.PanneauAccueil;

public class RechercherAmisAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private PanneauAccueil panneauAccueil;

	public RechercherAmisAction(PanneauAccueil panneauAccueil) {
		putValue(NAME, PanneauAccueil.LBL_RECHERCHER_AMIS);
		this.panneauAccueil = panneauAccueil;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
