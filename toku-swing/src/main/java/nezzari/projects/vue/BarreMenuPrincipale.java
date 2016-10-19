package nezzari.projects.vue;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import nezzari.projects.OutilsSwing;
import nezzari.projects.controlleurs.menu.admin.GestionUtilisateursAction;
import nezzari.projects.controlleurs.menu.fichier.QuitterAction;
import nezzari.projects.controlleurs.menu.outils.OptionAction;
import nezzari.projects.controlleurs.menu.outils.ToujoursVisibleAction;

public class BarreMenuPrincipale extends JMenuBar {

	private static final long serialVersionUID = 1L;
	public static final String MENU_FICHIER = "Fichier";
	public static final String MENU_QUITTER = "Quitter";
	
	public static final String MENU_CONTACTS = "Contacts";
	
	public static final String MENU_ACTIONS = "Groupes";
	public static final String MENU_CREER_GROUPE = "Créer un groupe de discussion";
	public static final String MENU_AJOUTER_AMI_GROUPE = "Ajouter des amis au groupe";
	
	
	public static final String MENU_OUTILS = "Outils";
	public static final String MENU_TOUJOURS_VISIBLE = "Toujours visible";
	public static final String MENU_OPTIONS = "Options";
	
	public static final String MENU_MODERATEUR = "Modération";
	
	public static final String MENU_ADMIN = "Administration";
	public static final String MENU_GERER_UTILISATEURS = "Gérer les utilisateurs";
	
	
	// Menu Fichier
	private JMenu menuFichier;
	private JMenuItem menuQuitter;

	// Menu Contacts
	private JMenu menuContacts;

	// Menu Actions
	private JMenu menuActions;

	// Menu Outils
	private JMenu menuOutils;
	private JMenuItem menuOptions;
	private JCheckBoxMenuItem menuToujourVisible;
	
	//Menu Moderateur
	private JMenu menuModerateur;
	
	//Menu administrateur
	private JMenu menuAdmin;
	private JMenuItem menuGererUtilisateurs;
	
	

	public BarreMenuPrincipale() {
		menuFichier = OutilsSwing.creerMenu(MENU_FICHIER, this);
		menuQuitter = OutilsSwing.creerSousMenu(menuFichier, QuitterAction.getInstance());

		menuContacts = OutilsSwing.creerMenu(MENU_CONTACTS, this);

		menuActions = OutilsSwing.creerMenu(MENU_ACTIONS, this);

		menuOutils = OutilsSwing.creerMenu(MENU_OUTILS, this);
		menuToujourVisible = OutilsSwing.creerSousMenuCochable(menuOutils, ToujoursVisibleAction.getInstance());
		menuOptions = OutilsSwing.creerSousMenu(menuOutils, OptionAction.getInstance());
		
		menuModerateur = OutilsSwing.creerMenuCache(MENU_MODERATEUR, this);
		
		menuAdmin = OutilsSwing.creerMenuCache(MENU_ADMIN, this);
		menuGererUtilisateurs = OutilsSwing.creerSousMenu(menuAdmin, GestionUtilisateursAction.getInstance());
	}

	public void afficherMenuAdmin() {
		menuAdmin.setVisible(true);
	}

	public void cacherMenuAdmin() {
		menuAdmin.setVisible(false);
	}

	public void afficherMenuModerateur() {
		menuModerateur.setVisible(true);
	}

	public void cacherMenuModerateur() {
		menuModerateur.setVisible(false);
	}
}
