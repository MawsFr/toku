package fr.lille1.univ.coo.tp.vue.gestion.utilisateurs;

import java.awt.Container;
import java.awt.Dialog.ModalityType;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import fr.lille1.univ.coo.tp.controlleurs.gestion.utilisateur.AjouterUtilisateurAction;
import fr.lille1.univ.coo.tp.controlleurs.gestion.utilisateur.ModifierUtilisateurAction;
import fr.lille1.univ.coo.tp.controlleurs.gestion.utilisateur.SupprimerUtilisateurAction;
import fr.lille1.univ.coo.tp.role.IRole;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.BarreMenuPrincipale;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;
import fr.lille1.univ.coo.tp.vue.composants.GBC;
import fr.lille1.univ.coo.tp.vue.composants.JTextFieldHint;

public class GestionUtilisateurs {
	public static final String AJOUTER_UTILISATEUR = "Ajouter";
	public static final String MODIFIER_UTILISATEUR = "Modifier";
	public static final String SUPPRIMER_UTILISATEUR = "Supprimer";
	public static final String AIDE_FILTRE = "pseudo ou nom ou prenom";
	
	private JDialog fenetre;
	private Container c;
	private JObservableList<Utilisateur> utilisateurs;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JTextFieldHint filtre;
	
	private Utilisateur utilisateurSelectionne;
	
	public GestionUtilisateurs() {
		c = fenetre.getContentPane();
		c.setLayout(new GridBagLayout());
		
		fenetre = new JDialog(FenetrePrincipale.getInstance().getFenetre(), BarreMenuPrincipale.MENU_GERER_UTILISATEURS, ModalityType.APPLICATION_MODAL);
		utilisateurs = new JUtilisateurList();
		btnAjouter = new JButton(AjouterUtilisateurAction.getInstance(this));
		btnModifier = new JButton(ModifierUtilisateurAction.getInstance(this));
		btnSupprimer = new JButton(SupprimerUtilisateurAction.getInstance(this));
		filtre = new JTextFieldHint();
		filtre.setHint(AIDE_FILTRE);

		GBC gbc = new GBC(c);
		gbc.setPosition(0, 0).ajouter(new JLabel("Filtre :"));
		gbc.reset().avancer().setFill(GBC.BOTH).setWidth(2).ajouter(filtre);
		gbc.reset().setPosition(0, 0).descendre().setWidth(3).setHeight(4).ajouter(new JScrollPane(utilisateurs));
		gbc.reset().avancer().avancer().avancer().setFill(GBC.BOTH).ajouter(btnAjouter);
		gbc.descendre().ajouter(btnModifier);
		gbc.descendre().ajouter(btnSupprimer);
		
		fenetre.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		fenetre.pack();
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
		
	}
	
	/**
	 * @return Le fenetre
	 */
	public JDialog getFenetre() {
		return fenetre;
	}

	/**
	 * @return Le utilisateurs
	 */
	public JObservableList<Utilisateur> getUtilisateurs() {
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
	 * @return Le utilisateurSelectionne
	 */
	public Utilisateur getUtilisateurSelectionne() {
		return utilisateurSelectionne;
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
	public JTextFieldHint getFiltre() {
		return filtre;
	}

	/**
	 * @param filtre Le nouveau filtre
	 */
	public void setFiltre(JTextFieldHint filtre) {
		this.filtre = filtre;
	}

	/**
	 * @param fenetre Le nouveau fenetre
	 */
	public void setFenetre(JDialog fenetre) {
		this.fenetre = fenetre;
	}

	/**
	 * @param utilisateurs Le nouveau utilisateurs
	 */
	public void setUtilisateurs(JObservableList<Utilisateur> utilisateurs) {
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

	/**
	 * @param utilisateurSelectionne Le nouveau utilisateurSelectionne
	 */
	public void setUtilisateurSelectionne(Utilisateur utilisateurSelectionne) {
		this.utilisateurSelectionne = utilisateurSelectionne;
	}
	
	

}
