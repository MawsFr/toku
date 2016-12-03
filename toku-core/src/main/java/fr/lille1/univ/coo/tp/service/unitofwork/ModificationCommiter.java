package fr.lille1.univ.coo.tp.service.unitofwork;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;

/**
 * Cette classe applique les modification d'objet du domaine sur la BDD.
 */
public class ModificationCommiter extends Commiter {

	/**
	 * Modifie une personne dans la BDD.
	 */
	@Override
	public void action(Class<?> classe, IObjetDomaine o) throws DomainException {
		try {
			new DAOGenerique<>(classe).modifier(o, this.parametres);
		} catch (DAOException e) {
			throw new DomainException(e);
		}
	}

}
