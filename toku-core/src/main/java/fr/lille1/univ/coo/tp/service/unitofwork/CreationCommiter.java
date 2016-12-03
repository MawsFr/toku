package fr.lille1.univ.coo.tp.service.unitofwork;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;

/**
 * Cette classe applique les creation d'objet du domaine sur la BDD.
 * 
 * @author Mustapha Nezzari
 *
 */
public class CreationCommiter extends Commiter {

	/**
	 * Cree un bureau dans la BDD.
	 * @throws DomainException 
	 */
	@Override
	public void action(Class<?> classe, IObjetDomaine o) throws DomainException {
		try {
		new DAOGenerique<>(classe).creer(o);
		} catch (DAOException e) {
			throw new DomainException(e);
		}
	}
}
