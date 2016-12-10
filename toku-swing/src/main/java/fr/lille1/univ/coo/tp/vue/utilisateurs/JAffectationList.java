package fr.lille1.univ.coo.tp.vue.utilisateurs;

import javax.swing.ListCellRenderer;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public class JAffectationList extends JDiscussionList {

	private static final long serialVersionUID = 1L;

	public JAffectationList() {
		super();
	}

	public JAffectationList(IObservableList<AffectationDiscussion> affectations) {
		super(affectations);
	}

	@Override
	public ListCellRenderer<? super AffectationDiscussion> getCellRenderer() {
		return new AffectationListCellRenderer();
	}

	@Override
	public String getMessageVide() {
		return "Aucun utilisateur sur cette dicussion !";
	}

}
