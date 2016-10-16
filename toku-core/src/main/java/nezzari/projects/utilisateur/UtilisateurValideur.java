package nezzari.projects.utilisateur;

import nezzari.projects.validateur.ValidationException;
import nezzari.projects.validateur.Valideur;

public class UtilisateurValideur extends Valideur<Utilisateur> implements IUtilisateurValideur {

	/* (non-Javadoc)
	 * @see nezzari.projects.utilisateur.IUtilisateurValidateur#valider(nezzari.projects.utilisateur.Utilisateur)
	 */
	@Override
	public void valider(Utilisateur utilisateur) throws ValidationException {
		if(utilisateur.getPseudo() == null) {
			throw new ValidationException("Le pseudo ne peut pas être null");
		}
		
		if(utilisateur.getPseudo().isEmpty()) {
			throw new ValidationException("Veuillez saisir un pseudonyme");
		}
		
		if(utilisateur.getMotDePasse() == null) {
			throw new ValidationException("Le mot de passe ne peut pas être null");
		}
		
		if(utilisateur.getMotDePasse().isEmpty()) {
			throw new ValidationException("Veuillez saisir un mot de passe");
		}
		
	}

}
