/**
 * 
 */
package fr.lille1.univ.coo.tp.persistance.proxy.factory;

import fr.lille1.univ.coo.tp.persistance.DAOException;

/**
 * @author Maws
 *
 */
public class PlusieursAPlusieursFactory<T> implements Factory<T> {

	private String tableAssociation;
	private Class<?> type;
	private String colonne;
	private Object valeur;
	
	@Override
	public T creer() throws DAOException {
		return null;
	}

}
