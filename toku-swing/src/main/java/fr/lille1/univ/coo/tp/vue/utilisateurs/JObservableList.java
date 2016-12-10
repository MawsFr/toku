package fr.lille1.univ.coo.tp.vue.utilisateurs;

import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JList;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public abstract class JObservableList<T extends IObjetDomaine<?>> extends JList<T> {
	protected static final long serialVersionUID = 1L;
	protected IObservableList<T> liste;
	protected IObservableListModel<T> leModel;
	protected JObservableListMouseAdapter<T> listener;
	
	private T elementSelectionne;

	public JObservableList() {
		this.setCellRenderer(getCellRenderer());
	}
	
	public JObservableList(IObservableList<T> utilisateurs) {
		this();
		setListe(utilisateurs);
	}

	/**
	 * @return Le utilisateurs
	 */
	public IObservableList<T> getListe() {
		return liste;
	}

	/**
	 * @param liste Le nouveau utilisateurs
	 */
	public void setListe(IObservableList<T> liste) {
		this.liste = liste;
		leModel = new IObservableListModel<T>(liste);
		this.setModel(leModel);

	}
	
	/**
	 * @return Le leModel
	 */
	public IObservableListModel<T> getLeModel() {
		return leModel;
	}

	/**
	 * @param leModel Le nouveau leModel
	 */
	public void setLeModel(IObservableListModel<T> leModel) {
		this.leModel = leModel;
	}
	
	public void ajouter(T t) {
		this.liste.ajouter(t);
	}
	
	public void suppression(T t) {
		this.liste.supprimer(t);
	}
	
	/**
	 * @return Le listener
	 */
	public JObservableListMouseAdapter<T> getListener() {
		return listener;
	}

	/**
	 * @param listener Le nouveau listener
	 */
	public void setListener(JObservableListMouseAdapter<T> listener) {
		this.listener = listener;
	}

	/**
	 * @return Le elementSelectionne
	 */
	public T getElementSelectionne() {
		return elementSelectionne;
	}

	/**
	 * @param elementSelectionne Le nouveau elementSelectionne
	 */
	public void setElementSelectionne(T elementSelectionne) {
		this.elementSelectionne = elementSelectionne;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(liste.getListe().isEmpty()) {
			FontMetrics fm = g.getFontMetrics();
			String message = getMessageVide(); 
			g.drawString(message, (getWidth() - fm.stringWidth(message)) / 2, (getHeight()  - fm.getHeight()) / 2);
		}
	}
	
	public abstract String getMessageVide();
	
	
}
