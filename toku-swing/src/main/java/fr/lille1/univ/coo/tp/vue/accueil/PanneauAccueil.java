package fr.lille1.univ.coo.tp.vue.accueil;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.accueil.CreerGroupeAction;
import fr.lille1.univ.coo.tp.controlleurs.accueil.RechercherAmisAction;
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

	private FenetrePrincipale fenetre;
	private GridBagLayout layout;
	
	private JLabel lblAvatar;
	private Avatar avatar;
	private JLabel lblPseudo;
	
	private JTabbedPane onglets;
	private OngletGroupes ongletGroupes;
	private OngletAmis ongletAmis;
	
	private JToolBar barreOutilsPrincipale;
	private JButton btnAjouterAmi;
	private JButton btnAjouterGroupe;
	
	public PanneauAccueil(FenetrePrincipale fenetre) {
		this.fenetre = fenetre;
		layout = new GridBagLayout();
		this.setLayout(layout);

		GBC gbc = new GBC(this);
		
		// Barre profil
		JPanel barreProfil = new JPanel();
		barreProfil.setLayout(new BorderLayout());
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
		
		barreProfil.add(lblPseudo, BorderLayout.CENTER);
		barreProfil.add(lblAvatar, BorderLayout.WEST);
		barreProfil.add(barreOutilsPrincipale, BorderLayout.SOUTH);
		
		gbc.setPosition(0, 0).setFill(GBC.HORIZONTAL).setWidth(3).setWeightY(0.1).ajouter(barreProfil);
		
		
		onglets = new JTabbedPane(JTabbedPane.LEFT);
		ongletAmis = new OngletAmis();
		ongletGroupes = new OngletGroupes();
		onglets.addTab(ONGLET_AMIS, null, ongletAmis, ONGLET_AMIS);
		onglets.addTab(ONGLET_GROUPES, null, ongletGroupes, ONGLET_GROUPES);
		
		gbc.reset().descendre().setWidth(3).setWeightY(0.9).setFill(GBC.BOTH).setWeightX(1).ajouter(onglets);
		
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
	
	

}
