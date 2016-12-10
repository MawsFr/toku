package fr.lille1.univ.coo.tp.filtre;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.persistance.DAOException;

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
	public void accept(Visiteur<?> visitor) throws DomainException;

}
