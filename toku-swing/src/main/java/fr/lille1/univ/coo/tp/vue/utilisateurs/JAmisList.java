package fr.lille1.univ.coo.tp.vue.utilisateurs;

import javax.swing.ListCellRenderer;

import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public class JAmisList extends JFiltrableList<Amitie> {

	private static final long serialVersionUID = 1L;

	public JAmisList() {
		super();
	}

	public JAmisList(IObservableList<Amitie> amities ) {
		super(amities);
	}

	@Override
	public ListCellRenderer<? super Amitie> getCellRenderer() {
		return new AmitieListCellRenderer();
	}

	@Override
	public String getMessageVide() {
		return "Vous n'avez aucun amis, cliquez sur +Amis pour en ajouter !";
	}

}
