package nezzari.projects.controlleurs.connexion;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import nezzari.projects.service.Service;
import nezzari.projects.service.ServiceException;
import nezzari.projects.utilisateur.Utilisateur;
import nezzari.projects.validateur.ValidationException;
import nezzari.projects.vue.FenetrePrincipale;
import nezzari.projects.vue.PanneauPrincipal;
import nezzari.projects.vue.connexion.PanneauConnexion;

public class ConnexionAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	private PanneauConnexion connexion;
	private FenetrePrincipale fenetre;
	
	public static ConnexionAction instance;

	public static ConnexionAction getInstance(PanneauConnexion connexion) {
		if(instance == null) {
			instance = new ConnexionAction(connexion);
		}
		
		return instance;
	}
	
	private ConnexionAction(PanneauConnexion connexion) {
		super(PanneauConnexion.BTN_CONNECTER);
		putValue(MNEMONIC_KEY, KeyEvent.VK_C);
		this.connexion = connexion;
		this.fenetre = connexion.getFenetre();
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		fenetre.getBarreEtat().setEnCours();
		final String pseudo = connexion.getTxtPseudo().getText();
		final String mdp = new String(connexion.getTxtMdp().getPassword());
		
		Utilisateur utilisateur = null;
		
		try {
			utilisateur = Service.getUtilisateurService().connecter(pseudo, mdp);
		} catch (ValidationException | ServiceException e) {
			JOptionPane.showMessageDialog(connexion.getFenetre().getFenetre(), e.getCause().getMessage(), "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
		} finally {
			fenetre.getBarreEtat().setFini();
		}
		
		if(utilisateur != null) {
			fenetre.getBarreEtat().setTexte("Bienvenue " + utilisateur.getPseudo() + " !");
			try {
				if(Service.getUtilisateurService().estAdministrateur(utilisateur)) {
					fenetre.getMenu().afficherMenuAdmin();
				}
			} catch (ServiceException e) {
				JOptionPane.showMessageDialog(connexion.getFenetre().getFenetre(), e.getCause().getMessage(), "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
			}
			fenetre.getPanneauPrincipal().afficherEcran(PanneauPrincipal.PANNEAU_DISCUSSION);
			fenetre.getMenu().getMenuDeconnecter().setEnabled(true);
		}
		
		
	}

}
