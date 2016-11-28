package fr.lille1.univ.coo.tp.vue.gestion.utilisateurs;

import javax.swing.JList;

import fr.lille1.univ.coo.tp.utilisateur.ListeUtilisateurs;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.accueil.UtilisateurListModel;

public class JListUtilisateur extends JList<Utilisateur> {
	
	private ListeUtilisateurs utilisateurs;
	private UtilisateurListModel model;
	
	public JListUtilisateur(ListeUtilisateurs utilisateurs) {
		this.utilisateurs = utilisateurs;
		model = new UtilisateurListModel(utilisateurs);
		this.setModel(model);
	}

	/**
	 * @return Le utilisateurs
	 */
	public ListeUtilisateurs getUtilisateurs() {
		return utilisateurs;
	}

	/**
	 * @param utilisateurs Le nouveau utilisateurs
	 */
	public void setUtilisateurs(ListeUtilisateurs utilisateurs) {
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
	
	
}
