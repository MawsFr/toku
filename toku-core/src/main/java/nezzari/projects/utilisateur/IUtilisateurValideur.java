package nezzari.projects.utilisateur;

import nezzari.projects.validateur.ValidationException;

public interface IUtilisateurValideur {

	void valider(Utilisateur utilisateur) throws ValidationException;

}