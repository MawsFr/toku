package fr.lille1.univ.coo.tp.visiteur;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

/**
 * Cette represente un visiteur.
 * @author Mustapha Nezzari
 *
 */
public abstract class Visiteur {
	
	/**
	 * Visite un objet du domaine.
	 * @param objet L'objet a visiter.
	 * @throws DAOException Erreur lors de la visite.
	 */
	public void visit(IObjetDomaine objet) throws DomainException {
		objet.accept(this);
	}
	
	/**
	 * Visite un utilisateur.
	 * @param utilisateur L' utilisateur a visiter.
	 * @throws DAOException Erreur lors de la visite.
	 */
	public abstract void visit(Utilisateur utilisateur) throws DomainException;
	
}
