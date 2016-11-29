package fr.lille1.univ.coo.tp.persistance.proxy.factory;

import fr.lille1.univ.coo.tp.persistance.DAOException;

/**
 * Cette interface est implémenté par des {@link Factory} permettant de remonter
 * des objets de façon paresseuse.
 * 
 * @param <T>
 *            Le type d'objet à remonter depuis ma BDD.
 */
public interface Factory<T> {
	/**
	 * Crée un objet de type T.
	 * 
	 * @return Un objet de type T remonté depuis la BDD
	 * @throws DAOException 
	 */
	public T creer() throws DAOException;

}
