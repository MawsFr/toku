package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.validateur.ValidationException;
import fr.lille1.univ.coo.tp.validateur.Valideur;

public class ConnexionValideur extends Valideur<Utilisateur> implements IConnexionValideur {

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
