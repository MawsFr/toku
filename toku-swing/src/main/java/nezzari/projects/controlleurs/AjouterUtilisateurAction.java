package nezzari.projects.controlleurs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import nezzari.projects.vue.BarreMenuPrincipale;
import nezzari.projects.vue.gestion.utilisateurs.GestionUtilisateurs;

public class AjouterUtilisateurAction extends AbstractAction {

	private static AjouterUtilisateurAction instance;
	
	private GestionUtilisateurs gestionUtilisateurs;

	public static AjouterUtilisateurAction getInstance(GestionUtilisateurs gestionUtilisateurs) {
		if(instance == null) {
			instance = new AjouterUtilisateurAction(gestionUtilisateurs);
		}
		
		return instance;
	}
	
	private AjouterUtilisateurAction(GestionUtilisateurs gestionUtilisateurs) {
		super(GestionUtilisateurs.AJOUTER_UTILISATEUR);
		this.gestionUtilisateurs = gestionUtilisateurs;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
