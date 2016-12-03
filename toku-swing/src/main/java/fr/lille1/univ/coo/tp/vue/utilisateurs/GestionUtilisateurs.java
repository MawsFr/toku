package fr.lille1.univ.coo.tp.vue.utilisateurs;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import fr.lille1.univ.coo.tp.controlleurs.FiltrerUtilisateurAction;
import fr.lille1.univ.coo.tp.controlleurs.gestion.utilisateur.AjouterUtilisateurAction;
import fr.lille1.univ.coo.tp.controlleurs.gestion.utilisateur.ModifierUtilisateurAction;
import fr.lille1.univ.coo.tp.controlleurs.gestion.utilisateur.SupprimerUtilisateurAction;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.BarreMenuPrincipale;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;
import fr.lille1.univ.coo.tp.vue.composants.GBC;

public class GestionUtilisateurs extends JDialog {
	private static final long serialVersionUID = 1L;
	public static final String AJOUTER_UTILISATEUR = "Ajouter";
	public static final String MODIFIER_UTILISATEUR = "Modifier";
	public static final String SUPPRIMER_UTILISATEUR = "Supprimer";
	public static final String AIDE_FILTRE = "pseudo ou nom ou prenom";
	
	private Container c;
	private JUtilisateurList utilisateurs;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JTexteFiltre<Utilisateur> filtre;
	
	public GestionUtilisateurs(IObservableList<Utilisateur> membres) {
		super(FenetrePrincipale.getInstance().getFenetre(), BarreMenuPrincipale.MENU_GERER_UTILISATEURS, ModalityType.APPLICATION_MODAL);
		
		c = getContentPane();
		c.setLayout(new GridBagLayout());
		
		utilisateurs = new JUtilisateurList(membres);
		utilisateurs.setSelectedIndex(0);
		utilisateurs.addMouseListener(new GestionUtilisateurMouseAdapter(this, utilisateurs));
		btnAjouter = new JButton(AjouterUtilisateurAction.getInstance(this));
		btnModifier = new JButton(ModifierUtilisateurAction.getInstance(this));
		btnSupprimer = new JButton(SupprimerUtilisateurAction.getInstance(this));
		filtre = utilisateurs.getTexte();
		filtre.getDocument().addDocumentListener(new FiltrerUtilisateurAction(utilisateurs));
		filtre.setHint(AIDE_FILTRE);

		utilisateurs.setPreferredSize(new Dimension(300, 300));
		
		GBC gbc = new GBC(c);
		gbc.setPosition(0, 0).ajouter(new JLabel("Filtre :"));
		gbc.reset().avancer().setFill(GBC.BOTH).setWidth(2).ajouter(filtre);
		gbc.reset().setPosition(0, 0).descendre().setWidth(3).setHeight(4).ajouter(new JScrollPane(utilisateurs));
		gbc.reset().avancer().avancer().avancer().setFill(GBC.BOTH).ajouter(btnAjouter);
		gbc.descendre().ajouter(btnModifier);
		gbc.descendre().ajouter(btnSupprimer);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		pack();
//		setSize(300, 300);
//		setMinimumSize(new Dimension(300, 300));
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	/**
	 * @return Le utilisateurs
	 */
	public JUtilisateurList getUtilisateurs() {
		return utilisateurs;
	}

	/**
	 * @return Le btnAjouter
	 */
	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	/**
	 * @return Le btnModifier
	 */
	public JButton getBtnModifier() {
		return btnModifier;
	}

	/**
	 * @return Le btnSupprimer
	 */
	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	/**
	 * @return Le c
	 */
	public Container getC() {
		return c;
	}

	/**
	 * @param c Le nouveau c
	 */
	public void setC(Container c) {
		this.c = c;
	}

	/**
	 * @return Le filtre
	 */
	public JTexteFiltre<Utilisateur> getFiltre() {
		return filtre;
	}

	/**
	 * @param filtre Le nouveau filtre
	 */
	public void setFiltre(JTexteFiltre<Utilisateur> filtre) {
		this.filtre = filtre;
	}

	/**
	 * @param utilisateurs Le nouveau utilisateurs
	 */
	public void setUtilisateurs(JUtilisateurList utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	/**
	 * @param btnAjouter Le nouveau btnAjouter
	 */
	public void setBtnAjouter(JButton btnAjouter) {
		this.btnAjouter = btnAjouter;
	}

	/**
	 * @param btnModifier Le nouveau btnModifier
	 */
	public void setBtnModifier(JButton btnModifier) {
		this.btnModifier = btnModifier;
	}

	/**
	 * @param btnSupprimer Le nouveau btnSupprimer
	 */
	public void setBtnSupprimer(JButton btnSupprimer) {
		this.btnSupprimer = btnSupprimer;
	}

}
