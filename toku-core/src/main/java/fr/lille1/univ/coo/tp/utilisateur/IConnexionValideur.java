package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.validateur.ValidationException;

public interface IConnexionValideur {

	void valider(Utilisateur utilisateur) throws ValidationException;

}