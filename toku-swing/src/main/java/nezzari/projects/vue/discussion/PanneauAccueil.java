package nezzari.projects.vue.discussion;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import nezzari.projects.vue.FenetrePrincipale;
import nezzari.projects.vue.composants.GBC;

public class PanneauAccueil extends JPanel {

	private static final long serialVersionUID = 1L;
	private FenetrePrincipale fenetre;
	private GridBagLayout layout;
	
	public PanneauAccueil(FenetrePrincipale fenetre) {
		this.fenetre = fenetre;
		layout = new GridBagLayout();
		this.setLayout(layout);

		GBC gbc = new GBC(this);
		
	}

}
