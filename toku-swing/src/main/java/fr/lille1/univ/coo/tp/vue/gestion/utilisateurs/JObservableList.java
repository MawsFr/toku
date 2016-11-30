package fr.lille1.univ.coo.tp.vue.gestion.utilisateurs;

import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JList;

import fr.lille1.univ.coo.tp.filtre.Filtre;
import fr.lille1.univ.coo.tp.filtre.Filtreur;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public abstract class JObservableList<T> extends JList<T> implements Filtreur {
	private static final long serialVersionUID = 1L;
	// TODO : RENDRE GENERIQUE LA CLASSE
	private IObservableList<T> utilisateurs;
	private IObservableListModel<T> leModel;

	public JObservableList() {
		this.setCellRenderer(getCellRenderer());
	}
	
	public JObservableList(IObservableList<T> utilisateurs) {
		this();
		setUtilisateurs(utilisateurs);
	}

	/**
	 * @return Le utilisateurs
	 */
	public IObservableList<T> getUtilisateurs() {
		return utilisateurs;
	}

	/**
	 * @param utilisateurs Le nouveau utilisateurs
	 */
	public void setUtilisateurs(IObservableList<T> utilisateurs) {
		this.utilisateurs = utilisateurs;
		leModel = new IObservableListModel<T>(utilisateurs);
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

	@Override
	public void filtrer(Filtre filtre) {
		// TODO : Implémenter
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(utilisateurs.getListe().isEmpty()) {
			FontMetrics fm = g.getFontMetrics();
			String message = getMessageVide(); 
			g.drawString(message, (getWidth() - fm.stringWidth(message)) / 2, (getHeight()  - fm.getHeight()) / 2);
		}
	}
	
	public String getMessageVide() {
		return "Vous n'avez aucun amis, cliquez sur +Amis pour en ajouter !";
	}
	
}
