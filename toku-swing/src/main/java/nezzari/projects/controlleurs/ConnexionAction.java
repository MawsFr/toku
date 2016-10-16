package nezzari.projects.controlleurs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import nezzari.projects.service.Service;
import nezzari.projects.utilisateur.Utilisateur;
import nezzari.projects.vue.connexion.PanneauConnexion;

public class ConnexionAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	private PanneauConnexion connexion;
	
	public static ConnexionAction instance;

	public static ConnexionAction getInstance(PanneauConnexion connexion) {
		if(instance == null) {
			instance = new ConnexionAction(connexion);
		}
		
		return instance;
	}
	
	private ConnexionAction(PanneauConnexion connexion) {
		super(PanneauConnexion.BTN_CONNECTER);
		this.connexion = connexion;
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		final String pseudo = connexion.getTxtPseudo().getText();
		final String mdp = new String(connexion.getTxtMdp().getPassword());
		
		Utilisateur utilisateur = Service.getUtilisateurService().connecter(pseudo, mdp);
		
		if(utilisateur == null) {
			JOptionPane.showMessageDialog(connexion.getFenetre().getFenetre(), "Ces informations ne correspondent à aucun compte", "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
