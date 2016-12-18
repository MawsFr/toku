package fr.lille1.univ.coo.tp.service;

import fr.lille1.univ.coo.tp.discussion.DiscussionService;
import fr.lille1.univ.coo.tp.discussion.IDiscussionService;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateurService;
import fr.lille1.univ.coo.tp.utilisateur.UtilisateurService;
import fr.lille1.univ.coo.tp.utilisateur.administrateur.AdministrateurService;
import fr.lille1.univ.coo.tp.utilisateur.administrateur.IAdministrateurService;

public abstract class Service<T> {
	
	public static IUtilisateurService getUtilisateurService() {
		return UtilisateurService.getInstance();
	}

	public static IDiscussionService getDiscussionService() {
		return DiscussionService.getInstance();
	}
	
	public static IAdministrateurService getAdministrateurService() {
		return AdministrateurService.getInstance();
	}
}
