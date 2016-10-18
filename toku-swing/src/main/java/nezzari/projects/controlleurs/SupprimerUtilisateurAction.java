package nezzari.projects.controlleurs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import nezzari.projects.vue.BarreMenuPrincipale;
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
		
	}

}
