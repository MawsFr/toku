package fr.lille1.univ.coo.tp.service;

import fr.lille1.univ.coo.tp.discussion.DiscussionService;
import fr.lille1.univ.coo.tp.discussion.IDiscussionService;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateurService;
import fr.lille1.univ.coo.tp.utilisateur.UtilisateurService;

public abstract class Service<T> {
	
	public static IUtilisateurService getUtilisateurService() {
		return UtilisateurService.getInstance();
	}

	public static IDiscussionService getDiscussionService() {
		return DiscussionService.getInstance();
	}
}
