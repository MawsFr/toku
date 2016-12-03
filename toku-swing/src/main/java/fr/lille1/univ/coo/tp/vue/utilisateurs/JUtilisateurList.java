package fr.lille1.univ.coo.tp.vue.utilisateurs;

import javax.swing.ListCellRenderer;

import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class JUtilisateurList extends JFiltrableList<Utilisateur> {

	private static final long serialVersionUID = 1L;

	public JUtilisateurList() {
		super();
	}

	public JUtilisateurList(IObservableList<Utilisateur> iObservableList) {
		super(iObservableList);
	}

	@Override
	public ListCellRenderer<? super Utilisateur> getCellRenderer() {
		return new UtilisateurListCellRenderer();
	}

	@Override
	public String getMessageVide() {
		return "Aucun utilisateurs !";
	}

}
