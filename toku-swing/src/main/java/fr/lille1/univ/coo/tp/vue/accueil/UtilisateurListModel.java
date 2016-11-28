package fr.lille1.univ.coo.tp.vue.accueil;

import javax.swing.DefaultListModel;

import fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class UtilisateurListModel extends DefaultListModel<Utilisateur> {
	
	private static final long serialVersionUID = 1L;
	private IListeUtilisateur utilisateurs;

	public UtilisateurListModel(IListeUtilisateur ListeUtilisateur) {
		this.utilisateurs = ListeUtilisateur;
		for(Utilisateur ami : ListeUtilisateur.getUtilisateurs()) {
			addElement(ami);
		}
	}
}
