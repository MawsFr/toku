package fr.lille1.univ.coo.tp.controlleurs.menu.admin;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.vue.BarreMenuPrincipale;
import fr.lille1.univ.coo.tp.vue.gestion.utilisateurs.GestionUtilisateurs;

public class GestionUtilisateursAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private static GestionUtilisateursAction instance;

	public static GestionUtilisateursAction getInstance() {
		if(instance == null) {
			instance = new GestionUtilisateursAction();
		}
		
		return instance;
	}
	
	private GestionUtilisateursAction() {
		super(BarreMenuPrincipale.MENU_GERER_UTILISATEURS);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		new GestionUtilisateurs();
	}

}
