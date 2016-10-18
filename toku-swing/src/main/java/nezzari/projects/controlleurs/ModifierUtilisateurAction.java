package nezzari.projects.controlleurs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import nezzari.projects.vue.BarreMenuPrincipale;
import nezzari.projects.vue.gestion.utilisateurs.GestionUtilisateurs;

public class ModifierUtilisateurAction extends AbstractAction {

	private static ModifierUtilisateurAction instance;
	private GestionUtilisateurs gestionUtilisateurs;
	
	public static ModifierUtilisateurAction getInstance(GestionUtilisateurs gestionUtilisateurs) {
		if(instance == null) {
			instance = new ModifierUtilisateurAction(gestionUtilisateurs);
		}
		
		return instance;
	}
	
	private ModifierUtilisateurAction(GestionUtilisateurs gestionUtilisateurs) {
		super(GestionUtilisateurs.MODIFIER_UTILISATEUR);
		this.gestionUtilisateurs = gestionUtilisateurs;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
