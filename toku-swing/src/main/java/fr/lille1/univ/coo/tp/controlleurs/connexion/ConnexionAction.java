package fr.lille1.univ.coo.tp.controlleurs.connexion;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.validateur.ValidationException;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;
import fr.lille1.univ.coo.tp.vue.PanneauPrincipal;
import fr.lille1.univ.coo.tp.vue.connexion.PanneauConnexion;

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
		
		IUtilisateur utilisateur = null;
		
		try {
			utilisateur = Service.getUtilisateurService().connecter(pseudo, mdp);
		} catch (ValidationException | ServiceException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(connexion.getFenetre().getFenetre(), e.getMessage(), "Erreur de connexion", JOptionPane.ERROR_MESSAGE);
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
			fenetre.getPanneauPrincipal().afficherEcran(PanneauPrincipal.PANNEAU_ACCUEIL);
			fenetre.getMenu().getMenuDeconnecter().setEnabled(true);
			fenetre.getPanneauPrincipal().getPanneauAccueil().initialiser();
			fenetre.getFenetre().pack();
		}
		
		
	}

}
