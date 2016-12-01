package fr.lille1.univ.coo.tp.vue.utilisateurs;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.composants.AnnulerAction;
import fr.lille1.univ.coo.tp.controlleurs.composants.ValiderAction;
import fr.lille1.univ.coo.tp.cryptage.CryptageException;
import fr.lille1.univ.coo.tp.cryptage.CrypteurMD5;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;
import fr.lille1.univ.coo.tp.role.IRole;
import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.utils.OutilsSwing;
import fr.lille1.univ.coo.tp.vue.composants.GBC;
import fr.lille1.univ.coo.tp.vue.composants.JShowablePaswordTextFIeld;
import fr.lille1.univ.coo.tp.vue.composants.fenetre.Annulable;
import fr.lille1.univ.coo.tp.vue.composants.fenetre.Fermable;
import fr.lille1.univ.coo.tp.vue.composants.fenetre.Validable;

public class FenetreProfil extends JDialog implements Validable, Annulable, Fermable {
	private static final long serialVersionUID = 1L;

	public static enum ModeEdition {
		AJOUT, MODIF;
	}
	
	public static final String BTN_OK = "Créer";
	public static final String BTN_OK_ET_AUTRE = "Créer un autre utilisateur";
	public static final String BTN_ANNULER = "Annuler";
	
	public static final String TITRE_AJOUT = "Ajouter un utilisateur";
	public static final String TITRE_MODIF = "Modifier un profil";
	
	private GestionUtilisateurs parent;
	
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
	
	public FenetreProfil(GestionUtilisateurs parent, ModeEdition mode, Utilisateur utilisateur) {
		super(parent, mode == ModeEdition.AJOUT ? TITRE_AJOUT : TITRE_MODIF, ModalityType.APPLICATION_MODAL);
		this.parent = parent;
		c = this.getContentPane();
		this.utilisateur = utilisateur;
		
		txtPseudo = new JTextField();
		txtMDP = new JShowablePaswordTextFIeld();
		txtNom = new JTextField();
		txtPrenom = new JTextField();
//		Service.roleservice
		List<Role> roles = null;
		try {
			roles = new DAOGenerique<Role>(Role.class).rechercherTout();
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboRole = new JComboBox<Role>(roles.toArray(new Role[roles.size()]));
		
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
//			comboRole.setSelectedItem(utilisateur.getRole() - 1);
		}
		
		try {
			if(!Service.getUtilisateurService().estAdministrateur(Application.getInstance().getSession().getUtilisateur())) {
				txtPseudo.setEnabled(false);
			}
		} catch (ServiceException e) {
			// TODO : Erreur
		}
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	
	@Override
	public void valider() {
		utilisateur.setPseudo(txtPseudo.getText());
		utilisateur.setNom(txtNom.getText());
		utilisateur.setPrenom(txtPrenom.getText());
		utilisateur.setRole((Role) comboRole.getSelectedItem());
		try {
			utilisateur.setMotDePasse(new CrypteurMD5().crypter(new String(txtMDP.getPassword().getPassword())));
			parent.getUtilisateurs().ajouter(utilisateur);
			Service.getAdministrateurService().validerCreationUtilisateur();
		} catch (CryptageException | ServiceException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erreur lors du cryptage du mot de passe !", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
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
		this.dispose();
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

	public Container getC() {
		return c;
	}

	public void setC(Container c) {
		this.c = c;
	}

	public IUtilisateur getUtilisateur() {
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