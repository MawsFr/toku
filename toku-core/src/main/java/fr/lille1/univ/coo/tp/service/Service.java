package fr.lille1.univ.coo.tp.service;

import fr.lille1.univ.coo.tp.utilisateur.IUtilisateurService;
import fr.lille1.univ.coo.tp.utilisateur.UtilisateurService;
import fr.lille1.univ.coo.tp.utilisateur.administrateur.AdministrateurService;
import fr.lille1.univ.coo.tp.utilisateur.administrateur.IAdministrateurService;
import fr.lille1.univ.coo.tp.utilisateur.moderateur.IModerateurService;
import fr.lille1.univ.coo.tp.utilisateur.moderateur.ModerateurService;

public abstract class Service<T> {
	
	public static IUtilisateurService getUtilisateurService() {
		return UtilisateurService.getInstance();
	}

	public static IModerateurService getModerateurService() {
		return ModerateurService.getInstance();
	}
	
	public static IAdministrateurService getAdministrateurService() {
		return AdministrateurService.getInstance();
	}
}
