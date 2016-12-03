package fr.lille1.univ.coo.tp.controlleurs.gestion.utilisateur;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.utilisateurs.FenetreProfil;
import fr.lille1.univ.coo.tp.vue.utilisateurs.GestionUtilisateurs;

public class AjouterUtilisateurAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

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
		new FenetreProfil(gestionUtilisateurs, FenetreProfil.ModeEdition.AJOUT, new Utilisateur());
		
	}

}
