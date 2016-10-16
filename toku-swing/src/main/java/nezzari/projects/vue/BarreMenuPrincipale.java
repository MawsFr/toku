package nezzari.projects.vue;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import nezzari.projects.OutilsSwing;
import nezzari.projects.controlleurs.QuitterAction;
import nezzari.projects.controlleurs.ToujoursVisibleAction;

public class BarreMenuPrincipale extends JMenuBar {

	private static final long serialVersionUID = 1L;
	public static final String MENU_FICHIER_NOM = "Fichier";
	public static final String MENU_QUITTER_NOM = "Quitter";
	public static final String MENU_CONTACTS_NOM = "Contacts";
	public static final String MENU_ACTIONS_NOM = "Actions";
	public static final String MENU_OUTILS_NOM = "Outils";
	public static final String MENU_TOUJOURS_VISIBLE_NOM = "Toujours visible";

	// Menu Fichier
	private JMenu menuFichier;
	private JMenuItem menuQuitter;
	
	// Menu Contacts
	private JMenu menuContacts;
	
	// Menu Actions
	private JMenu menuActions;
	
	// Menu Outils
	private JMenu menuOutils;
	private JCheckBoxMenuItem menuToujourVisible;

	public BarreMenuPrincipale() {
		menuFichier = OutilsSwing.creerMenu(MENU_FICHIER_NOM, this);
		menuQuitter = OutilsSwing.creerSousMenu(menuFichier, QuitterAction.getInstance());
		
		menuContacts = OutilsSwing.creerMenu(MENU_CONTACTS_NOM, this);
		
		menuActions = OutilsSwing.creerMenu(MENU_ACTIONS_NOM, this);
		
		menuOutils = OutilsSwing.creerMenu(MENU_OUTILS_NOM, this);
		menuToujourVisible = OutilsSwing.creerSousMenuCochable(menuOutils, ToujoursVisibleAction.getInstance());
	}
}
