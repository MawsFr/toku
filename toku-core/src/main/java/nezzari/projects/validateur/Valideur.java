package nezzari.projects.validateur;

import nezzari.projects.utilisateur.IUtilisateurValideur;
import nezzari.projects.utilisateur.UtilisateurValideur;

public abstract class Valideur<T> {
	
	public abstract void valider(T objet) throws ValidationException;
	
	public static IUtilisateurValideur getUtilisateurValideur() {
		return new UtilisateurValideur();
	}

}
