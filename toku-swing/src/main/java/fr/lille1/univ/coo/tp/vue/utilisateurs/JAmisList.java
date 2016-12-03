package fr.lille1.univ.coo.tp.vue.utilisateurs;

import javax.swing.ListCellRenderer;

import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class JAmisList extends JUtilisateurList {

	private static final long serialVersionUID = 1L;

	public JAmisList() {
		super();
	}

	public JAmisList(IObservableList<Utilisateur> iObservableList) {
		super(iObservableList);
	}

	@Override
	public ListCellRenderer<? super Utilisateur> getCellRenderer() {
		return new AmitieListCellRenderer();
	}

	@Override
	public String getMessageVide() {
		return "Vous n'avez aucun amis, cliquez sur +Amis pour en ajouter !";
	}

}
