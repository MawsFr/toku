package nezzari.projects.visiteur;

import nezzari.projects.factory.DAOException;
import nezzari.projects.factory.IObjetDomaine;

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
	public void visit(IObjetDomaine objet) throws DAOException {
		objet.accept(this);
	}
	
//	/**
//	 * Visite une personne.
//	 * @param personne La personne a visiter.
//	 * @throws DAOException Erreur lors de la visite.
//	 */
//	public void visit(Personne personne) throws DAOException {
//		personne.accept(this);
//	}
//	/**
//	 * Visite un administratif.
//	 * @param administratif l'administratif a visiter;
//	 * @throws DAOException Erreur lors de la visite.
//	 */
//	public abstract void visit(Administratif administratif) throws DAOException;
//	
//	/**
//	 * Visite un chercheur.
//	 * @param chercheur Le chercheur a visiter
//	 * @throws DAOException Erreur lors de la visite.
//	 */
//	public abstract void visit(Chercheur chercheur) throws DAOException;
//	
//	/**
//	 * Visite un bureau.
//	 * @param bureau Le bureau a visiter
//	 * @throws DAOException Erreur lors de la visite.
//	 */
//	public abstract void visit(Bureau bureau) throws DAOException;
//	
//	/**
//	 * Visite une affectation.
//	 * @param affectation L'affectation a visiter
//	 * @throws DAOException Erreur lors de la visite.
//	 */
//	public abstract void visit(Affectation affectation) throws DAOException;
	
}
