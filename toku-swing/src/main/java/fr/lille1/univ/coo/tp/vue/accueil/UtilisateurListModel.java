package fr.lille1.univ.coo.tp.vue.accueil;

import javax.swing.DefaultListModel;

import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class UtilisateurListModel extends DefaultListModel<Utilisateur> {
	
	private static final long serialVersionUID = 1L;
	private IObservableList<Utilisateur> utilisateurs;

	public UtilisateurListModel(IObservableList<Utilisateur> ListeUtilisateur) {
		this.utilisateurs = ListeUtilisateur;
		for(Utilisateur ami : ListeUtilisateur.getUtilisateurs()) {
			addElement(ami);
		}
	}
}
