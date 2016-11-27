package fr.lille1.univ.coo.tp.service.unitofwork;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

/**
 * Cette classe applique les modification d'objet du domaine sur la BDD.
 */
public class ModificationCommiter extends Commiter {

	/**
	 * Modifie une personne dans la BDD.
	 */
	@Override
	public void visit(Utilisateur personne) throws DomainException {
		try {
			new DAOGenerique<>(Utilisateur.class).modifier(personne, this.parametres);
		} catch (DAOException e) {
			throw new DomainException(e);
		}
	}

}
