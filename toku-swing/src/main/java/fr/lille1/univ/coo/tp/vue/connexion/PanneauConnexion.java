package fr.lille1.univ.coo.tp.vue.connexion;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.connexion.ConnexionAction;
import fr.lille1.univ.coo.tp.utils.Constantes;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;
import fr.lille1.univ.coo.tp.vue.composants.GBC;
import fr.lille1.univ.coo.tp.vue.composants.JShowablePaswordTextFIeld;
import fr.lille1.univ.coo.tp.vue.composants.JTextFieldHint;

public class PanneauConnexion extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final String LABEL_CONNECTER = "Connectez-vous";
	public static final String LABEL_PSEUDO = "Pseudonyme :";
	public static final String LABEL_MDP = "Mot de passe :";
	public static final String LABEL_EX_PSEUDO = "ex : Maws";
	public static final String BTN_CONNECTER = "Connecter";

	private FenetrePrincipale fenetre;
	private GridBagLayout layout;
	private JButton btnConnexion;
	private JTextFieldHint txtPseudo;
	private JShowablePaswordTextFIeld txtMdp;

	public PanneauConnexion(FenetrePrincipale fenetre) {
		this.fenetre = fenetre;
		layout = new GridBagLayout();
		this.setLayout(layout);

		GBC gbc = new GBC(this);

		// Logo
		URL img = Application.class.getResource(Constantes.CHEMIN_LOGO);
		ImageIcon icon = new ImageIcon(img);
		JLabel label = new JLabel(icon);
		gbc.reset().setPosition(0, 0).setWidth(GBC.REMAINDER).setAnchor(GBC.PAGE_START).ajouter(label);

		// Label "Connectez vous"

		JLabel lblPseudo = new JLabel(LABEL_PSEUDO);
		JLabel lblMdp= new JLabel(LABEL_MDP);
		txtPseudo = new JTextFieldHint();
		txtMdp = new JShowablePaswordTextFIeld();
		txtMdp.setPreferredSize(new Dimension(150, 20));
		txtMdp.setMinimumSize(new Dimension(150, 20));
		txtPseudo.setHint(LABEL_EX_PSEUDO);
		
		lblPseudo.setLabelFor(txtPseudo);
		lblPseudo.setDisplayedMnemonic(KeyEvent.VK_P);
		lblMdp.setLabelFor(txtMdp);
		lblMdp.setDisplayedMnemonic(KeyEvent.VK_M);
		txtPseudo.setAction(ConnexionAction.getInstance(this));
		txtMdp.getPassword().setAction(ConnexionAction.getInstance(this));
		
		gbc.reset().descendre().setWidth(GBC.REMAINDER).setAnchor(GBC.LINE_START).ajouter(lblPseudo);
		gbc.reset().descendre().setWidth(GBC.REMAINDER).setAnchor(GBC.LINE_START).ajouter(txtPseudo);
		gbc.reset().descendre().setWidth(GBC.REMAINDER).setAnchor(GBC.LINE_START).ajouter(lblMdp);
		gbc.reset().descendre().setWidth(GBC.REMAINDER).setAnchor(GBC.LINE_START).ajouter(txtMdp);
		
		// Bouton connexion
		btnConnexion = new JButton(ConnexionAction.getInstance(this));
		gbc.reset().descendre().setWidth(GBC.REMAINDER).ajouter(btnConnexion);
		
	}

	public JTextFieldHint getTxtPseudo() {
		return txtPseudo;
	}
	
	public JPasswordField getTxtMdp() {
		return txtMdp.getPassword();
	}
	
	public FenetrePrincipale getFenetre() {
		return fenetre;
	}
}
