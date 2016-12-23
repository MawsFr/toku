package fr.lille1.univ.coo.tp.validateur;

import fr.lille1.univ.coo.tp.utilisateur.IConnexionValideur;
import fr.lille1.univ.coo.tp.utilisateur.ConnexionValideur;

/**
 * Cette classe est a extends par tout validateur d'objet (pour valider par exemple des champs saisies)
 * @author Maws
 *
 * @param <T>
 */
public abstract class Valideur<T> {
	
	public abstract void valider(T objet) throws ValidationException;
	
	public static IConnexionValideur getConnexionValideur() {
		return new ConnexionValideur();
	}

}
