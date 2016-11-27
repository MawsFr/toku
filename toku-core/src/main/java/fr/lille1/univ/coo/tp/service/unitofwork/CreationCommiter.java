package fr.lille1.univ.coo.tp.service.unitofwork;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

/**
 * Cette classe applique les creation d'objet du domaine sur la BDD.
 * 
 * @author Mustapha Nezzari
 *
 */
public class CreationCommiter extends Commiter {

	/**
	 * Cree un bureau dans la BDD.
	 */
	@Override
	public void visit(Utilisateur personne) throws DomainException {
		try {
		new DAOGenerique<>(Utilisateur.class).creer(personne);
		} catch (DAOException e) {
			throw new DomainException(e);
		}
	}
}
