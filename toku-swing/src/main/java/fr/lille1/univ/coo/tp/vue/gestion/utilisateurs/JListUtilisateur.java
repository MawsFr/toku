package fr.lille1.univ.coo.tp.vue.gestion.utilisateurs;

import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JList;

import fr.lille1.univ.coo.tp.filtre.Filtre;
import fr.lille1.univ.coo.tp.filtre.Filtreur;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class JListUtilisateur extends JList<Utilisateur> implements Filtreur {
	private static final long serialVersionUID = 1L;
	// TODO : RENDRE GENERIQUE LA CLASSE
	private IObservableList<Utilisateur> utilisateurs;
	private UtilisateurListModel model;

	public JListUtilisateur() {
		this.setCellRenderer(new UtilisateurListCellRenderer());
	}
	
	public JListUtilisateur(IObservableList<Utilisateur> utilisateurs) {
		this();
		setUtilisateurs(utilisateurs);
	}

	/**
	 * @return Le utilisateurs
	 */
	public IObservableList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	/**
	 * @param utilisateurs Le nouveau utilisateurs
	 */
	public void setUtilisateurs(IObservableList<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
		model = new UtilisateurListModel(utilisateurs);
		this.setModel(model);

	}

	/**
	 * @return Le model
	 */
	public UtilisateurListModel getModel() {
		return model;
	}

	/**
	 * @param model Le nouveau model
	 */
	public void setModel(UtilisateurListModel model) {
		this.model = model;
	}

	@Override
	public void filtrer(Filtre filtre) {
		// TODO : Implémenter
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(utilisateurs.getUtilisateurs().isEmpty()) {
			FontMetrics fm = g.getFontMetrics();
			String message = "Vous n'avez aucun amis, cliquez sur +Amis pour en ajouter !";
			g.drawString(message, (getWidth() - fm.stringWidth(message)) / 2, (getHeight()  - fm.getHeight()) / 2);
		}
	}

}
