package fr.lille1.univ.coo.tp.vue.gestion.utilisateurs;

import java.awt.Container;
import java.awt.Dialog.ModalityType;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.lille1.univ.coo.tp.controlleurs.gestion.utilisateur.AjouterUtilisateurAction;
import fr.lille1.univ.coo.tp.controlleurs.gestion.utilisateur.ModifierUtilisateurAction;
import fr.lille1.univ.coo.tp.controlleurs.gestion.utilisateur.SupprimerUtilisateurAction;
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
	private JTable utilisateurs;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnSupprimer;
	private JTextFieldHint filtre;
	
	private Utilisateur utilisateurSelectionne;
	
	public GestionUtilisateurs() {
		fenetre = new JDialog(FenetrePrincipale.getInstance().getFenetre(), BarreMenuPrincipale.MENU_GERER_UTILISATEURS, ModalityType.APPLICATION_MODAL);
		utilisateurs = new JTable();
		btnAjouter = new JButton(AjouterUtilisateurAction.getInstance(this));
		btnModifier = new JButton(ModifierUtilisateurAction.getInstance(this));
		btnSupprimer = new JButton(SupprimerUtilisateurAction.getInstance(this));
		filtre = new JTextFieldHint();
		filtre.setHint(AIDE_FILTRE);
		c = fenetre.getContentPane();
		
		c.setLayout(new GridBagLayout());

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
	
	public JButton getBtnAjouter() {
		return btnAjouter;
	}
	
	public JButton getBtnModifier() {
		return btnModifier;
	}
	
	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}
	
	public JDialog getFenetre() {
		return fenetre;
	}
	
	public JTable getUtilisateurs() {
		return utilisateurs;
	}
	
	public Utilisateur getUtilisateurSelectionne() {
		return utilisateurSelectionne;
	}

}
