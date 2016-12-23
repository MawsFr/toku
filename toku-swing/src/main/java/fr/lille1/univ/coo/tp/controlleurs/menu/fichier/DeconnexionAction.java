package fr.lille1.univ.coo.tp.controlleurs.menu.fichier;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.vue.BarreMenuPrincipale;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;
import fr.lille1.univ.coo.tp.vue.PanneauPrincipal;

public class DeconnexionAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	public static DeconnexionAction instance;

	public static DeconnexionAction getInstance() {
		if(instance == null) {
			instance = new DeconnexionAction();
		}
		
		return instance;
	}
	
	private DeconnexionAction() {
		super(BarreMenuPrincipale.MENU_DECONNECTER);
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		FenetrePrincipale fenetre = FenetrePrincipale.getInstance();
		Service.getUtilisateurService().deconnecter();
		fenetre.getPanneauPrincipal().afficherEcran(PanneauPrincipal.PANNEAU_CONNEXION);
		fenetre.getPanneauPrincipal().getPanneauConnexion().getTxtPseudo().setText("");
		fenetre.getPanneauPrincipal().getPanneauConnexion().getTxtPseudo().requestFocus();
		fenetre.getPanneauPrincipal().getPanneauConnexion().getTxtMdp().setText("");
		fenetre.getMenu().getMenuDeconnecter().setEnabled(false);
		fenetre.getMenu().getMenuModifierProfil().setEnabled(false);
		fenetre.getMenu().cacherMenuAdmin();
		fenetre.getBarreEtat().setTexte("");
		fenetre.getFenetre().pack();
	}

}
