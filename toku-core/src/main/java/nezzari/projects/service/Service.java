package nezzari.projects.service;

import nezzari.projects.utilisateur.IUtilisateurService;
import nezzari.projects.utilisateur.UtilisateurService;
import nezzari.projects.utilisateur.moderateur.IModerateurService;
import nezzari.projects.utilisateur.moderateur.ModerateurService;

public abstract class Service<T> {
	
	public static IUtilisateurService getUtilisateurService() {
		return UtilisateurService.getInstance();
	}

	public static IModerateurService getModerateurService() {
		return ModerateurService.getInstance();
	}
}
