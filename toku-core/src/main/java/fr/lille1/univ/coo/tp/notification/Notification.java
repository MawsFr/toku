package fr.lille1.univ.coo.tp.notification;

public abstract class Notification<T> {
	protected T objet;
	protected String texte;
	
	public abstract void supprimer();
	public abstract void accepter();
	public abstract void refuser();
	
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
	
	
	
}
