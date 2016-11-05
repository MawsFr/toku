package nezzari.projects.vue.gestion.utilisateurs;

import java.awt.Container;
import java.awt.Dialog.ModalityType;
import java.awt.GridBagLayout;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import nezzari.projects.Application;
import nezzari.projects.OutilsSwing;
import nezzari.projects.controlleurs.composants.AnnulerAction;
import nezzari.projects.controlleurs.composants.ValiderAction;
import nezzari.projects.role.Role;
import nezzari.projects.service.Service;
import nezzari.projects.service.ServiceException;
import nezzari.projects.utilisateur.Utilisateur;
import nezzari.projects.vue.composants.GBC;
import nezzari.projects.vue.composants.JShowablePaswordTextFIeld;
import nezzari.projects.vue.composants.fenetre.Annulable;
import nezzari.projects.vue.composants.fenetre.Fermable;
import nezzari.projects.vue.composants.fenetre.Validable;

public class FenetreProfil implements Validable, Annulable, Fermable {
	public static enum ModeEdition {
		AJOUT, MODIF;
	}
	
	public static final String BTN_OK = "Créer";
	public static final String BTN_OK_ET_AUTRE = "Créer un autre utilisateur";
	public static final String BTN_ANNULER = "Annuler";
	
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
	
	public FenetreProfil(Window parent, ModeEdition mode, Utilisateur utilisateur) {
		fenetre = new JDialog(parent, mode == ModeEdition.AJOUT ? TITRE_AJOUT : TITRE_MODIF, ModalityType.APPLICATION_MODAL);
		c = fenetre.getContentPane();
		this.utilisateur = utilisateur;
		
		txtPseudo = new JTextField();
		txtMDP = new JShowablePaswordTextFIeld();
		txtNom = new JTextField();
		txtPrenom = new JTextField();
		comboRole = new JComboBox<>(Role.values());
		
		OutilsSwing.setTaille(150, 20, txtPseudo, txtMDP, txtNom, txtPrenom, comboRole);
		
		btnOk = new JButton(new ValiderAction(this, BTN_OK));
		okEtNouveau = new JCheckBox(BTN_OK_ET_AUTRE);
		btnAnnuler = new JButton(new AnnulerAction(this, BTN_ANNULER));
		
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
		
		gbc.descendre().reculer().ajouter(okEtNouveau);
		gbc.avancer().ajouter(btnOk);
		gbc.avancer().ajouter(btnAnnuler);
		
		
		if(mode == ModeEdition.MODIF) {
			txtPseudo.setText(utilisateur.getPseudo());
			txtMDP.getPassword().setText(utilisateur.getMotDePasse());
			txtNom.setText(utilisateur.getNom());
			txtPrenom.setText(utilisateur.getPrenom());
			comboRole.setSelectedItem(utilisateur.getRole() - 1);
		}
		
		try {
			if(!Service.getUtilisateurService().estAdministrateur(Application.getInstance().getSession().getUtilisateur())) {
				txtPseudo.setEnabled(false);
			}
		} catch (ServiceException e) {
			// TODO : Erreur
		}
		
		fenetre.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		fenetre.pack();
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);

	}
	
	@Override
	public void valider() {
		utilisateur.setPseudo(txtPseudo.getText());
		utilisateur.setMotDePasse(new String(txtMDP.getPassword().getPassword()));
		utilisateur.setNom(txtNom.getText());
		utilisateur.setPrenom(txtPrenom.getText());
		utilisateur.setRole(comboRole.getSelectedIndex() + 1);
		Service.getAdministrateurService().creerUtilisateur(utilisateur);
		if(okEtNouveau.isSelected()) {
			txtPseudo.setText("");
			txtMDP.getPassword().setText("");;
			txtNom.setText("");
			txtPrenom.setText("");
			comboRole.setSelectedItem(0);
		} else {
			fermer();
		}
	}
	
	@Override
	public void annuler() {
		fermer();
	}
	
	@Override
	public void fermer() {
		fenetre.dispose();
	}
	
	public JCheckBox getOkEtNouveau() {
		return okEtNouveau;
	}
	
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
	
	public JButton getBtnOk() {
		return btnOk;
	}

	public JDialog getFenetre() {
		return fenetre;
	}

	public void setFenetre(JDialog fenetre) {
		this.fenetre = fenetre;
	}

	public Container getC() {
		return c;
	}

	public void setC(Container c) {
		this.c = c;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public JTextField getTxtPseudo() {
		return txtPseudo;
	}

	public void setTxtPseudo(JTextField txtPseudo) {
		this.txtPseudo = txtPseudo;
	}

	public JShowablePaswordTextFIeld getTxtMDP() {
		return txtMDP;
	}

	public void setTxtMDP(JShowablePaswordTextFIeld txtMDP) {
		this.txtMDP = txtMDP;
	}

	public JTextField getTxtNom() {
		return txtNom;
	}

	public void setTxtNom(JTextField txtNom) {
		this.txtNom = txtNom;
	}

	public JTextField getTxtPrenom() {
		return txtPrenom;
	}

	public void setTxtPrenom(JTextField txtPrenom) {
		this.txtPrenom = txtPrenom;
	}

	public JComboBox<Role> getComboRole() {
		return comboRole;
	}

	public void setComboRole(JComboBox<Role> comboRole) {
		this.comboRole = comboRole;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	public void setOkEtNouveau(JCheckBox okEtNouveau) {
		this.okEtNouveau = okEtNouveau;
	}

	public void setBtnAnnuler(JButton btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}
	
	

}
