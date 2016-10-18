package nezzari.projects.vue.gestion.utilisateurs;

import java.awt.Container;
import java.awt.Dialog.ModalityType;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import nezzari.projects.OutilsSwing;
import nezzari.projects.role.Role;
import nezzari.projects.utilisateur.Utilisateur;
import nezzari.projects.vue.composants.GBC;
import nezzari.projects.vue.composants.JShowablePaswordTextFIeld;

public class FenetreProfil {
	public static enum ModeEdition {
		AJOUT, MODIF;
	}
	
	public static final String TITRE_AJOUT = "Ajouter un utilisateur";
	public static final String TITRE_MODIF = "Modifier un profil";
	
	private JDialog fenetre;
	private Container c;
	private Utilisateur utilisateur;
	
	private JTextField txtPseudo;
	private JShowablePaswordTextFIeld txtMDP;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JComboBox<Role> comboRole;
	
	private JButton btnOk;
	private JCheckBox okEtNouveau;
	private JButton btnAnnuler;
	
	public FenetreProfil(Window parent, ModeEdition mode) {
		fenetre = new JDialog(parent, mode == ModeEdition.AJOUT ? TITRE_AJOUT : TITRE_MODIF, ModalityType.DOCUMENT_MODAL);
		c = fenetre.getContentPane();
		
		txtPseudo = new JTextField();
		txtMDP = new JShowablePaswordTextFIeld();
		txtNom = new JTextField();
		txtPrenom = new JTextField();
		comboRole = new JComboBox<>(Role.values());
		
		OutilsSwing.setTaille(150, 20, txtPseudo, txtMDP, txtNom, txtPrenom, comboRole);
		
		btnOk = new JButton("Ajouter");
		okEtNouveau = new JCheckBox("Créer un autre utilisateur");
		btnAnnuler = new JButton("Annuler");
		
		c.setLayout(new GridBagLayout());
		GBC gbc = new GBC(c);
		
		gbc.setPosition(0, 0).setAnchor(GBC.BASELINE_TRAILING).ajouter(new JLabel("Pseudonyme :"));
		gbc.avancer().ajouter(txtPseudo);
		gbc.descendre().reculer().ajouter(new JLabel("Mot de passe :"));
		gbc.avancer().ajouter(txtMDP);
		gbc.descendre().reculer().ajouter(new JLabel("Nom :"));
		gbc.avancer().ajouter(txtNom);
		gbc.descendre().reculer().ajouter(new JLabel("Prénom :"));
		gbc.avancer().ajouter(txtPrenom);
		gbc.descendre().reculer().ajouter(new JLabel("Rôle:"));
		gbc.avancer().ajouter(comboRole);
		
		if(mode == ModeEdition.MODIF) {
			
		}
		
		fenetre.pack();
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);

	}

}
