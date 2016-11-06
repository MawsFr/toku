package nezzari.projects.vue.accueil;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import nezzari.projects.Application;
import nezzari.projects.utilisateur.Utilisateur;
import nezzari.projects.vue.FenetrePrincipale;
import nezzari.projects.vue.composants.GBC;
import nezzari.projects.vue.discussion.Avatar;

public class PanneauAccueil extends JPanel {
	
	public static final String ONGLET_GROUPES = "Groupes";
	public static final String ONGLET_AMIS = "Amis";

	private static final long serialVersionUID = 1L;
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
		
		btnAjouterAmi = new JButton("+ Amis");
		btnAjouterGroupe = new JButton("+ Groupes");
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
		Utilisateur utilisateur = Application.getInstance().getSession().getUtilisateur();
		avatar.setImage(utilisateur);
		lblAvatar.setIcon(avatar);
		lblPseudo.setText(utilisateur.getPrenom().substring(0, 1).toUpperCase() + utilisateur.getPrenom().substring(1) + " " + utilisateur.getNom().toUpperCase() + " (" + utilisateur.getPseudo() + ")");
		lblPseudo.setFont(new Font("Serif", Font.PLAIN, 22));
		ongletAmis.initialiser();
	}
	
	

}
