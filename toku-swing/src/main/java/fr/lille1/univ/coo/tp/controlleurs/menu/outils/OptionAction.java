package fr.lille1.univ.coo.tp.controlleurs.menu.outils;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.BarreMenuPrincipale;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;
import fr.lille1.univ.coo.tp.vue.utilisateurs.FenetreProfil;
import fr.lille1.univ.coo.tp.vue.utilisateurs.FenetreProfil.ModeEdition;

public class OptionAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	
	public static OptionAction instance;
	
	private OptionAction() {
		super(BarreMenuPrincipale.MENU_OPTIONS);
	}

	public static OptionAction getInstance() {
		if(instance == null) {
			instance = new OptionAction();
		}
		
		return instance;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String mdp = null;
		try {
			Utilisateur utilisateur = Application.getInstance().getSession().getUtilisateur();
			mdp = Service.getUtilisateurService().getMotDePasse(utilisateur);
			new FenetreProfil(FenetrePrincipale.getInstance().getFenetre(), ModeEdition.MODIF, utilisateur, mdp);

		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
