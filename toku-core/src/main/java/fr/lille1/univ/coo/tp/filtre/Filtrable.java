package fr.lille1.univ.coo.tp.filtre;

import fr.lille1.univ.coo.tp.domain.DomainException;

public interface Filtrable {
	public void filtrer(Filtre filtre) throws DomainException;

}
