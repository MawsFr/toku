package fr.lille1.univ.coo.tp.validateur;

import fr.lille1.univ.coo.tp.utilisateur.IConnexionValideur;
import fr.lille1.univ.coo.tp.utilisateur.ConnexionValideur;

public abstract class Valideur<T> {
	
	public abstract void valider(T objet) throws ValidationException;
	
	public static IConnexionValideur getConnexionValideur() {
		return new ConnexionValideur();
	}

}
