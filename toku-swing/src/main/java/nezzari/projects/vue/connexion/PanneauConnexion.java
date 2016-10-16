package nezzari.projects.vue.connexion;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import nezzari.projects.Application;
import nezzari.projects.Constantes;
import nezzari.projects.controlleurs.ConnexionAction;
import nezzari.projects.vue.FenetrePrincipale;
import nezzari.projects.vue.composants.GBC;
import nezzari.projects.vue.composants.JTextFieldHint;

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
	private JPasswordField txtMdp;

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
		txtMdp = new JPasswordField();
		txtMdp.setPreferredSize(new Dimension(150, 20));
		txtMdp.setMinimumSize(new Dimension(150, 20));
		txtPseudo.setHint(LABEL_EX_PSEUDO);

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
		return txtMdp;
	}
	
	public FenetrePrincipale getFenetre() {
		return fenetre;
	}
}
