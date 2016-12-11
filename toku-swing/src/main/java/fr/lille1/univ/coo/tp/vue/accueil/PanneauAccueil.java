package fr.lille1.univ.coo.tp.vue.accueil;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.accueil.CreerGroupeAction;
import fr.lille1.univ.coo.tp.controlleurs.accueil.RechercherAmisAction;
import fr.lille1.univ.coo.tp.controlleurs.notifications.AfficherNotificationsAction;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;
import fr.lille1.univ.coo.tp.vue.composants.GBC;
import fr.lille1.univ.coo.tp.vue.discussion.Avatar;

public class PanneauAccueil extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public static final String LBL_RECHERCHER_AMIS = "+ Amis";
	public static final String LBL_AJOUTER_GROUPES = "+ Groupes";
	
	public static final String ONGLET_GROUPES = "Groupes";
	public static final String ONGLET_AMIS = "Amis";

	public static final Object LBL_NOTIFICATIONS = "Notifications";

	private FenetrePrincipale fenetre;
	private BorderLayout layout;
	
	private JLabel lblAvatar;
	private Avatar avatar;
	private JLabel lblPseudo;
	
	private JTabbedPane onglets;
	private OngletGroupes ongletGroupes;
	private OngletAmis ongletAmis;
	
	private JToolBar barreOutilsPrincipale;
	private JButton btnAjouterAmi;
	private JButton btnAjouterGroupe;
	private Component horizontalGlue;
	private JButton btnNotifications;
	
	public PanneauAccueil(FenetrePrincipale fenetre) {
		this.fenetre = fenetre;
//		layout = new GridBagLayout();
		layout = new BorderLayout();
		this.setLayout(layout);

//		GBC gbc = new GBC(this);
		
		// Barre profil
		JPanel barreProfil = new JPanel();
		barreProfil.setLayout(new BorderLayout());
		barreProfil.setPreferredSize(new Dimension(100, 100));
		avatar = new Avatar();
		lblAvatar = new JLabel();
		lblPseudo = new JLabel();
		barreOutilsPrincipale = new JToolBar(JToolBar.HORIZONTAL);
		barreOutilsPrincipale.setFloatable(false);
		barreOutilsPrincipale.setRollover(true);
		
		btnAjouterAmi = new JButton(new RechercherAmisAction(this));
		btnAjouterGroupe = new JButton(new CreerGroupeAction(this));
		barreOutilsPrincipale.add(btnAjouterAmi);
		barreOutilsPrincipale.addSeparator();
		barreOutilsPrincipale.add(btnAjouterGroupe);
		horizontalGlue = Box.createHorizontalGlue();
		barreOutilsPrincipale.add(horizontalGlue);
		
		btnNotifications = new JButton(new AfficherNotificationsAction());
		barreOutilsPrincipale.add(btnNotifications);
		
		barreProfil.add(lblPseudo, BorderLayout.CENTER);
		barreProfil.add(lblAvatar, BorderLayout.WEST);
		barreProfil.add(barreOutilsPrincipale, BorderLayout.SOUTH);
		
		
//		gbc.setPosition(0, 0).setFill(GBC.HORIZONTAL).setWidth(4).setWeightY(0.1).ajouter(barreProfil);
		this.add(barreProfil, BorderLayout.NORTH);
		
		onglets = new JTabbedPane(JTabbedPane.LEFT);
		ongletAmis = new OngletAmis();
		ongletGroupes = new OngletGroupes();
		onglets.addTab(ONGLET_AMIS, null, ongletAmis, ONGLET_AMIS);
		onglets.addTab(ONGLET_GROUPES, null, ongletGroupes, ONGLET_GROUPES);
		
//		gbc.reset().descendre().setWidth(4).setWeightY(0.9).setFill(GBC.BOTH).setWeightX(1).ajouter(onglets);
		this.add(onglets, BorderLayout.CENTER);
		
	}
	
	public void initialiser() {
		IUtilisateur utilisateur = Application.getInstance().getSession().getUtilisateur();
		avatar.setImage(utilisateur);
		lblAvatar.setIcon(avatar);
		lblPseudo.setText(utilisateur.getPrenom().substring(0, 1).toUpperCase() + utilisateur.getPrenom().substring(1) + " " + utilisateur.getNom().toUpperCase() + " (" + utilisateur.getPseudo() + ")");
		lblPseudo.setFont(new Font("Serif", Font.PLAIN, 22));
		ongletAmis.initialiser();
		ongletGroupes.initialiser();
	}
	
	public void afficherOnglet(int onglet) {
		this.onglets.setSelectedIndex(onglet);
	}

	/**
	 * @return Le fenetre
	 */
	public FenetrePrincipale getFenetre() {
		return fenetre;
	}

	/**
	 * @param fenetre Le nouveau fenetre
	 */
	public void setFenetre(FenetrePrincipale fenetre) {
		this.fenetre = fenetre;
	}

//	/**
//	 * @return Le layout
//	 */
//	public GridBagLayout getLayout() {
//		return layout;
//	}
//
//	/**
//	 * @param layout Le nouveau layout
//	 */
//	public void setLayout(GridBagLayout layout) {
//		this.layout = layout;
//	}

	/**
	 * @return Le lblAvatar
	 */
	public JLabel getLblAvatar() {
		return lblAvatar;
	}

	/**
	 * @param lblAvatar Le nouveau lblAvatar
	 */
	public void setLblAvatar(JLabel lblAvatar) {
		this.lblAvatar = lblAvatar;
	}

	/**
	 * @return Le avatar
	 */
	public Avatar getAvatar() {
		return avatar;
	}

	/**
	 * @param avatar Le nouveau avatar
	 */
	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	/**
	 * @return Le lblPseudo
	 */
	public JLabel getLblPseudo() {
		return lblPseudo;
	}

	/**
	 * @param lblPseudo Le nouveau lblPseudo
	 */
	public void setLblPseudo(JLabel lblPseudo) {
		this.lblPseudo = lblPseudo;
	}

	/**
	 * @return Le onglets
	 */
	public JTabbedPane getOnglets() {
		return onglets;
	}

	/**
	 * @param onglets Le nouveau onglets
	 */
	public void setOnglets(JTabbedPane onglets) {
		this.onglets = onglets;
	}

	/**
	 * @return Le ongletGroupes
	 */
	public OngletGroupes getOngletGroupes() {
		return ongletGroupes;
	}

	/**
	 * @param ongletGroupes Le nouveau ongletGroupes
	 */
	public void setOngletGroupes(OngletGroupes ongletGroupes) {
		this.ongletGroupes = ongletGroupes;
	}

	/**
	 * @return Le ongletAmis
	 */
	public OngletAmis getOngletAmis() {
		return ongletAmis;
	}

	/**
	 * @param ongletAmis Le nouveau ongletAmis
	 */
	public void setOngletAmis(OngletAmis ongletAmis) {
		this.ongletAmis = ongletAmis;
	}

	/**
	 * @return Le barreOutilsPrincipale
	 */
	public JToolBar getBarreOutilsPrincipale() {
		return barreOutilsPrincipale;
	}

	/**
	 * @param barreOutilsPrincipale Le nouveau barreOutilsPrincipale
	 */
	public void setBarreOutilsPrincipale(JToolBar barreOutilsPrincipale) {
		this.barreOutilsPrincipale = barreOutilsPrincipale;
	}

	/**
	 * @return Le btnAjouterAmi
	 */
	public JButton getBtnAjouterAmi() {
		return btnAjouterAmi;
	}

	/**
	 * @param btnAjouterAmi Le nouveau btnAjouterAmi
	 */
	public void setBtnAjouterAmi(JButton btnAjouterAmi) {
		this.btnAjouterAmi = btnAjouterAmi;
	}

	/**
	 * @return Le btnAjouterGroupe
	 */
	public JButton getBtnAjouterGroupe() {
		return btnAjouterGroupe;
	}

	/**
	 * @param btnAjouterGroupe Le nouveau btnAjouterGroupe
	 */
	public void setBtnAjouterGroupe(JButton btnAjouterGroupe) {
		this.btnAjouterGroupe = btnAjouterGroupe;
	}

	/**
	 * @return Le horizontalGlue
	 */
	public Component getHorizontalGlue() {
		return horizontalGlue;
	}

	/**
	 * @param horizontalGlue Le nouveau horizontalGlue
	 */
	public void setHorizontalGlue(Component horizontalGlue) {
		this.horizontalGlue = horizontalGlue;
	}

	/**
	 * @return Le btnNotifications
	 */
	public JButton getBtnNotifications() {
		return btnNotifications;
	}

	/**
	 * @param btnNotifications Le nouveau btnNotifications
	 */
	public void setBtnNotifications(JButton btnNotifications) {
		this.btnNotifications = btnNotifications;
	}
	

}
