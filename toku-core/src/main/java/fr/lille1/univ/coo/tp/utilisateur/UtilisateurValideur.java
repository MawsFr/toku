package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.validateur.ValidationException;

public class UtilisateurValideur extends ConnexionValideur {

	/* (non-Javadoc)
	 * @see nezzari.projects.utilisateur.IUtilisateurValidateur#valider(nezzari.projects.utilisateur.Utilisateur)
	 */
	@Override
	public void valider(Utilisateur utilisateur) throws ValidationException {
		super.valider(utilisateur);
		if(utilisateur.getNom() == null) {
			throw new ValidationException("Le nom ne peut pas être null");
		}
		
		if(utilisateur.getNom().isEmpty()) {
			throw new ValidationException("Veuillez saisir un nom");
		}
		
		if(utilisateur.getPrenom() == null) {
			throw new ValidationException("Le prenom ne peut pas être null");
		}
		
		if(utilisateur.getPrenom().isEmpty()) {
			throw new ValidationException("Veuillez saisir un prenom");
		}
		
		if(utilisateur.getRole() == null) {
			throw new ValidationException("Le role ne peut pas etre null");
		}
		
	}

}
