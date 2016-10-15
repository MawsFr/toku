package nezzari.projects.vue;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import nezzari.projects.OutilsSwing;
import nezzari.projects.controlleurs.QuitterAction;

public class BarreMenuPrincipale extends JMenuBar {
	public static final String MENU_FICHIER_NOM = "Fichier";
	public static final String MENU_QUITTER_NOM = "Quitter";

	private JMenu menuFichier;
	private JMenuItem menuQuitter; 

	public BarreMenuPrincipale() {
		menuFichier = OutilsSwing.creerMenu(MENU_FICHIER_NOM, this);
		menuQuitter = OutilsSwing.creerSousMenu(menuFichier, QuitterAction.getInstance());

	}
}
