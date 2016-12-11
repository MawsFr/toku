package fr.lille1.univ.coo.tp.vue.listes;


import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class JUtilisateurList extends JFiltrableList<Utilisateur> {

	private static final long serialVersionUID = 1L;

	public JUtilisateurList(IObservableList<Utilisateur> iObservableList) {
		super(iObservableList);
	}

}
