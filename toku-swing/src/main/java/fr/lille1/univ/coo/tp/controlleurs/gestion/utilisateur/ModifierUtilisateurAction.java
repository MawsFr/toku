package fr.lille1.univ.coo.tp.controlleurs.gestion.utilisateur;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.vue.utilisateurs.FenetreProfil;
import fr.lille1.univ.coo.tp.vue.utilisateurs.GestionUtilisateurs;

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
		new FenetreProfil(gestionUtilisateurs, FenetreProfil.ModeEdition.MODIF, gestionUtilisateurs.getUtilisateurs().getElementSelectionne());
	}

}
