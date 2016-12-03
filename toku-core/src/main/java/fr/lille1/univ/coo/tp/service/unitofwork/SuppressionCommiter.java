package fr.lille1.univ.coo.tp.service.unitofwork;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

/**
 * Cette classe applique les suppressions d'objet du domaine sur la BDD.
 * 
 * @author Mustapha Nezzari
 *
 */
public class SuppressionCommiter extends Commiter {
	/**
	 * Supprime un bureau de la BDD.
	 * @throws DomainException 
	 * @throws DAOException Erreur lors de la suppression
	 */
	@Override
	public void action(Class<?> classe, IObjetDomaine o) throws DomainException {
		try {
			new DAOGenerique<>(Utilisateur.class).supprimer(o.getId());
		} catch (DAOException e) {
			throw new DomainException(e);
		}
	}

}
