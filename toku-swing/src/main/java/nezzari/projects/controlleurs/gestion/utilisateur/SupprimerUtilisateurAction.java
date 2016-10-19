package nezzari.projects.controlleurs.gestion.utilisateur;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import nezzari.projects.service.Service;
import nezzari.projects.utilisateur.Utilisateur;
import nezzari.projects.vue.gestion.utilisateurs.GestionUtilisateurs;

public class SupprimerUtilisateurAction extends AbstractAction {

	private static SupprimerUtilisateurAction instance;
	private GestionUtilisateurs gestionUtilisateurs;
	
	public static SupprimerUtilisateurAction getInstance(GestionUtilisateurs gestionUtilisateurs) {
		if(instance == null) {
			instance = new SupprimerUtilisateurAction(gestionUtilisateurs);
		}
		
		return instance;
	}
	
	private SupprimerUtilisateurAction(GestionUtilisateurs gestionUtilisateurs) {
		super(GestionUtilisateurs.SUPPRIMER_UTILISATEUR);
		this.gestionUtilisateurs = gestionUtilisateurs;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Utilisateur utilisateur = gestionUtilisateurs.getUtilisateurSelectionne();
		if(JOptionPane.showConfirmDialog(gestionUtilisateurs.getFenetre(),
			    "Êtes-vous sûr de vouloir supprimer l'utilisateur " + gestionUtilisateurs.getUtilisateurSelectionne().getPseudo() + " ?",
			    "Suppression utilisateur",
			    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			Service.getAdministrateurService().supprimerUtilisateur(utilisateur.getId());
			
		}
	}

}
