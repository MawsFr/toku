package nezzari.projects.controlleurs.gestion.utilisateur;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import nezzari.projects.utilisateur.Utilisateur;
import nezzari.projects.vue.gestion.utilisateurs.FenetreProfil;
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
		new FenetreProfil(gestionUtilisateurs.getFenetre(), FenetreProfil.ModeEdition.MODIF, gestionUtilisateurs.getUtilisateurSelectionne());
	}

}
