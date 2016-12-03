package fr.lille1.univ.coo.tp.controlleurs.gestion.utilisateur;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.utilisateurs.FenetreProfil;
import fr.lille1.univ.coo.tp.vue.utilisateurs.GestionUtilisateurs;

public class ModifierUtilisateurAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

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
		Utilisateur selectionne = gestionUtilisateurs.getUtilisateurs().getElementSelectionne();
		final String mdp = Service.getAdministrateurService().getMotDePasse(selectionne);
		selectionne.setMotDePasse(mdp);
		new FenetreProfil(gestionUtilisateurs, FenetreProfil.ModeEdition.MODIF, selectionne);
	}

}
