package fr.lille1.univ.coo.tp;

import fr.lille1.univ.coo.tp.notification.GestionnaireNotification;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class Session {
	
	private Utilisateur utilisateur;
	private GestionnaireNotification gestionnaireNotification;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * @return Le gestionnaireNotification
	 */
	public GestionnaireNotification getGestionnaireNotification() {
		return gestionnaireNotification;
	}

	/**
	 * @param gestionnaireNotification Le nouveau gestionnaireNotification
	 */
	public void setGestionnaireNotification(GestionnaireNotification gestionnaireNotification) {
		this.gestionnaireNotification = gestionnaireNotification;
	}
	
	

}
