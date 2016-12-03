package fr.lille1.univ.coo.tp.controlleurs.accueil;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.vue.accueil.PanneauAccueil;

public class CreerGroupeAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private PanneauAccueil panneauAccueil;

	public CreerGroupeAction(PanneauAccueil panneauAccueil) {
		this.panneauAccueil = panneauAccueil;
		putValue(NAME, PanneauAccueil.LBL_AJOUTER_GROUPES);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	
}
