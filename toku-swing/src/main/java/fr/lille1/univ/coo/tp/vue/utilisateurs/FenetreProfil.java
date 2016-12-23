package fr.lille1.univ.coo.tp.vue.utilisateurs;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.utilisateur.UtilisateurValideur;
import fr.lille1.univ.coo.tp.utils.OutilsSwing;
import fr.lille1.univ.coo.tp.validateur.ValidationException;
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

	public static final String BTN_CREER = "Créer";
	public static final String BTN_MODIFIER = "Modifier";

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

	private ModeEdition mode;
	private String mdp;

	public FenetreProfil(GestionUtilisateurs parent, ModeEdition mode, Utilisateur utilisateur, String mdp) {
		super(parent, mode == ModeEdition.AJOUT ? TITRE_AJOUT : TITRE_MODIF, ModalityType.APPLICATION_MODAL);
		this.parent = parent;
		init(mode, utilisateur, mdp);

	}

	/**
	 * @param mode
	 * @param utilisateur
	 * @param mdp
	 */
	public void init(ModeEdition mode, Utilisateur utilisateur, String mdp) {
		this.mode = mode;
		this.utilisateur = utilisateur;
		this.mdp = mdp;

		c = this.getContentPane();
		txtPseudo = new JTextField();
		txtMDP = new JShowablePaswordTextFIeld();
		txtNom = new JTextField();
		txtPrenom = new JTextField();
		List<Role> roles = null;
		try {
			roles = new DAOGenerique<Role>(Role.class).rechercherTout();
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboRole = new JComboBox<Role>(roles.toArray(new Role[roles.size()]));

		OutilsSwing.setTaille(150, 20, txtPseudo, txtMDP, txtNom, txtPrenom, comboRole);

		ValiderAction valider = new ValiderAction(this, mode == ModeEdition.AJOUT ? BTN_CREER : BTN_MODIFIER);
		btnOk = new JButton(valider);
		txtMDP.getPassword().addActionListener(valider);
		txtPseudo.addActionListener(valider);
		txtPrenom.addActionListener(valider);
		txtNom.addActionListener(valider);
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
//			txtMDP.getPassword().setText(mdp);
			txtNom.setText(utilisateur.getNom());
			txtPrenom.setText(utilisateur.getPrenom());
			okEtNouveau.setVisible(false);
			comboRole.setSelectedItem(utilisateur.getRole());
		}

		try {
			if(!Service.getUtilisateurService().estAdministrateur(Application.getInstance().getSession().getUtilisateur())) {
				txtPseudo.setEnabled(false);
				comboRole.setEnabled(false);
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

	public FenetreProfil(JFrame parent, ModeEdition mode, Utilisateur utilisateur2, String mdp) {
		super(parent, mode == ModeEdition.AJOUT ? TITRE_AJOUT : TITRE_MODIF, ModalityType.APPLICATION_MODAL);
		init(mode, utilisateur2, mdp);
	}

	@Override
	public void valider() { // TODO : A déplacer dans la couche Service
		UtilisateurValideur valideur = new UtilisateurValideur();
		String motDePasse;
		try {
			motDePasse = new String(txtMDP.getPassword().getPassword());
			switch (mode) {
			case AJOUT:
				utilisateur.setPseudo(txtPseudo.getText());
				utilisateur.setNom(txtNom.getText());
				utilisateur.setPrenom(txtPrenom.getText());
				utilisateur.setRole((Role) comboRole.getSelectedItem());
				utilisateur.setMotDePasse(motDePasse);
				valideur.valider(utilisateur);
				utilisateur.setMotDePasse(new CrypteurMD5().crypter(motDePasse));
				parent.getUtilisateurs().ajouter(utilisateur);
				Service.getUtilisateurService().validerChangements();
				if(okEtNouveau.isSelected()) {
					txtPseudo.setText("");
					txtMDP.getPassword().setText("");;
					txtNom.setText("");
					txtPrenom.setText("");
					comboRole.setSelectedItem(0);
					
					utilisateur = new Utilisateur();
				} else {
					fermer();
				}
				break;
			case MODIF:
				Utilisateur tmp = new Utilisateur(comboRole.getItemAt(comboRole.getSelectedIndex()), txtPseudo.getText(), motDePasse.isEmpty() ? mdp : motDePasse, txtNom.getText(), txtPrenom.getText(), null);
				valideur.valider(tmp);
				if(!utilisateur.getPseudo().equals(txtPseudo.getText())) {
					utilisateur.setPseudo(txtPseudo.getText());
				}

				if(!motDePasse.isEmpty() && !mdp.equals(motDePasse)) {
					utilisateur.setMotDePasse(new CrypteurMD5().crypter(motDePasse));
				}

				if(!utilisateur.getNom().equals(txtNom.getText())) {
					utilisateur.setNom(txtNom.getText());
				}
				
				if(!utilisateur.getPrenom().equals(txtPrenom.getText())) {
					utilisateur.setPrenom(txtPrenom.getText());
				}

				if(!utilisateur.getRole().equals(comboRole.getSelectedItem())) {
					utilisateur.setRole((Role) comboRole.getSelectedItem());
				}
				Service.getUtilisateurService().validerChangements();
				fermer();
				break;
			default:
				break;

			}
		} catch (CryptageException | ValidationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		} catch (ServiceException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Ce pseudo est déjà pris existe déjà", "Erreur", JOptionPane.ERROR_MESSAGE);
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
