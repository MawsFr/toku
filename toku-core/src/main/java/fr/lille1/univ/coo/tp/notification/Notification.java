package fr.lille1.univ.coo.tp.notification;

public abstract class Notification<T> {
	protected T objet;
	protected String texte;
	
	/**
	 * @return Le objet
	 */
	public T getObjet() {
		return objet;
	}

	/**
	 * @param objet Le nouveau objet
	 */
	public void setObjet(T objet) {
		this.objet = objet;
	}

	/**
	 * @return Le texte
	 */
	public String getTexte() {
		return texte;
	}

	/**
	 * @param texte Le nouveau texte
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	
	
	
	
}
