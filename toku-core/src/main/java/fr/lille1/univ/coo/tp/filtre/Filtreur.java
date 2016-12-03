package fr.lille1.univ.coo.tp.filtre;

public abstract class Filtreur<T> {
	private Filtrable<T> filtrable;
	private Filtre<T> filtre;
	
	public Filtreur(Filtrable<T> filtrable) {
		this.filtrable = filtrable;
	}
	
	/**
	 * @return Le filtrable
	 */
	public Filtrable<T> getFiltrable() {
		return filtrable;
	}

	/**
	 * @param filtrable Le nouveau filtrable
	 */
	public void setFiltrable(Filtrable<T> filtrable) {
		this.filtrable = filtrable;
	}

	/**
	 * @return Le filtre
	 */
	public Filtre<T> getFiltre() {
		return filtre;
	}

	/**
	 * @param filtre Le nouveau filtre
	 */
	public void setFiltre(Filtre<T> filtre) {
		this.filtre = filtre;
	}

	public void filtrer() {
		filtrable.filtrer(filtre);
	}

}
