package fr.lille1.univ.coo.tp.vue.gestion.utilisateurs;

import javax.swing.JList;

import fr.lille1.univ.coo.tp.filtre.Filtre;
import fr.lille1.univ.coo.tp.filtre.Filtreur;
import fr.lille1.univ.coo.tp.utilisateur.ObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.accueil.UtilisateurListModel;

public class JListUtilisateur extends JList<Utilisateur> implements Filtreur {
	private static final long serialVersionUID = 1L;
	// TODO : RENDRE GENERIQUE LA CLASSE
	private ObservableList<Utilisateur> utilisateurs;
	private UtilisateurListModel model;
	
	public JListUtilisateur(ObservableList<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
		model = new UtilisateurListModel(utilisateurs);
		this.setModel(model);
	}

	/**
	 * @return Le utilisateurs
	 */
	public ObservableList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	/**
	 * @param utilisateurs Le nouveau utilisateurs
	 */
	public void setUtilisateurs(ObservableList<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
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
	
	
}
