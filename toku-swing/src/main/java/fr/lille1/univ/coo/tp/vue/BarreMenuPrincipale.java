package fr.lille1.univ.coo.tp.vue;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import fr.lille1.univ.coo.tp.controlleurs.menu.admin.GestionUtilisateursAction;
import fr.lille1.univ.coo.tp.controlleurs.menu.fichier.DeconnexionAction;
import fr.lille1.univ.coo.tp.controlleurs.menu.fichier.QuitterAction;
import fr.lille1.univ.coo.tp.controlleurs.menu.outils.OptionAction;
import fr.lille1.univ.coo.tp.controlleurs.menu.outils.ToujoursVisibleAction;
import fr.lille1.univ.coo.tp.utils.OutilsSwing;

public class BarreMenuPrincipale extends JMenuBar {

	private static final long serialVersionUID = 1L;
	public static final String MENU_FICHIER = "Fichier";
	public static final String MENU_DECONNECTER = "Se déconnecter";
	public static final String MENU_QUITTER = "Quitter";
	
	public static final String MENU_CONTACTS = "Contacts";
	
	public static final String MENU_ACTIONS = "Groupes";
	public static final String MENU_CREER_GROUPE = "Créer un groupe de discussion";
	public static final String MENU_AJOUTER_AMI_GROUPE = "Ajouter des amis au groupe";
	
	
	public static final String MENU_OUTILS = "Outils";
	public static final String MENU_TOUJOURS_VISIBLE = "Toujours visible";
	public static final String MENU_OPTIONS = "Modifier mon profil";
	
	public static final String MENU_MODERATEUR = "Modération";
	
	public static final String MENU_ADMIN = "Administration";
	public static final String MENU_GERER_UTILISATEURS = "Gérer les utilisateurs";
	
	
	// Menu Fichier
	private JMenu menuFichier;
	private JMenuItem menuDeconnecter;
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
		menuDeconnecter = OutilsSwing.creerSousMenuDesactive(menuFichier, DeconnexionAction.getInstance());
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

	public JMenu getMenuFichier() {
		return menuFichier;
	}

	public JMenuItem getMenuDeconnecter() {
		return menuDeconnecter;
	}

	public JMenuItem getMenuQuitter() {
		return menuQuitter;
	}

	public JMenu getMenuContacts() {
		return menuContacts;
	}

	public JMenu getMenuActions() {
		return menuActions;
	}

	public JMenu getMenuOutils() {
		return menuOutils;
	}

	public JMenuItem getMenuOptions() {
		return menuOptions;
	}

	public JCheckBoxMenuItem getMenuToujourVisible() {
		return menuToujourVisible;
	}

	public JMenu getMenuModerateur() {
		return menuModerateur;
	}

	public JMenu getMenuAdmin() {
		return menuAdmin;
	}

	public JMenuItem getMenuGererUtilisateurs() {
		return menuGererUtilisateurs;
	}

	public void setMenuFichier(JMenu menuFichier) {
		this.menuFichier = menuFichier;
	}

	public void setMenuDeconnecter(JMenuItem menuDeconnecter) {
		this.menuDeconnecter = menuDeconnecter;
	}

	public void setMenuQuitter(JMenuItem menuQuitter) {
		this.menuQuitter = menuQuitter;
	}

	public void setMenuContacts(JMenu menuContacts) {
		this.menuContacts = menuContacts;
	}

	public void setMenuActions(JMenu menuActions) {
		this.menuActions = menuActions;
	}

	public void setMenuOutils(JMenu menuOutils) {
		this.menuOutils = menuOutils;
	}

	public void setMenuOptions(JMenuItem menuOptions) {
		this.menuOptions = menuOptions;
	}

	public void setMenuToujourVisible(JCheckBoxMenuItem menuToujourVisible) {
		this.menuToujourVisible = menuToujourVisible;
	}

	public void setMenuModerateur(JMenu menuModerateur) {
		this.menuModerateur = menuModerateur;
	}

	public void setMenuAdmin(JMenu menuAdmin) {
		this.menuAdmin = menuAdmin;
	}

	public void setMenuGererUtilisateurs(JMenuItem menuGererUtilisateurs) {
		this.menuGererUtilisateurs = menuGererUtilisateurs;
	}
	
	
	
	
}
