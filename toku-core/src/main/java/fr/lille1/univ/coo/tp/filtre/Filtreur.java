package fr.lille1.univ.coo.tp.filtre;

import fr.lille1.univ.coo.tp.domain.DomainException;

public abstract class Filtreur {
	private Filtrable filtrable;
	private Filtre filtre;
	
	public Filtreur(Filtrable filtrable) {
		this.filtrable = filtrable;
	}
	
	/**
	 * @return Le filtrable
	 */
	public Filtrable getFiltrable() {
		return filtrable;
	}

	/**
	 * @param filtrable Le nouveau filtrable
	 */
	public void setFiltrable(Filtrable filtrable) {
		this.filtrable = filtrable;
	}

	/**
	 * @return Le filtre
	 */
	public Filtre getFiltre() {
		return filtre;
	}

	/**
	 * @param filtre Le nouveau filtre
	 */
	public void setFiltre(Filtre filtre) {
		this.filtre = filtre;
	}

	public void filtrer() throws DomainException {
		filtrable.filtrer(filtre);
	}

}
