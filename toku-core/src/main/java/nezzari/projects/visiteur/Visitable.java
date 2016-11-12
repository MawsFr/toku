package nezzari.projects.visiteur;

import nezzari.projects.factory.DAOException;

/**
 * Represente un element visitable.
 * @author Mustapha Nezzari
 *
 */
public interface Visitable {
	/**
	 * Permet au visiteur passer en parametre d'effectuer un traitement specifique e cet element.
	 * @param visitor Le visiteur.
	 * @throws DAOException Erreur au niveau persistance.
	 */
	public void accept(Visiteur visitor) throws DAOException;

}
