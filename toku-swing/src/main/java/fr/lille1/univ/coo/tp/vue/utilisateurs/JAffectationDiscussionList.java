package fr.lille1.univ.coo.tp.vue.utilisateurs;

import javax.swing.ListCellRenderer;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public class JAffectationDiscussionList extends JObservableList<AffectationDiscussion> {

	private static final long serialVersionUID = 1L;

	public JAffectationDiscussionList() {
		super();
	}

	public JAffectationDiscussionList(IObservableList<AffectationDiscussion> iObservableList) {
		super(iObservableList);
	}

	@Override
	public ListCellRenderer<? super AffectationDiscussion> getCellRenderer() {
		return new AffectationDiscussionListCellRenderer();
	}

	@Override
	public String getMessageVide() {
		return "Vous n'avez aucune discussion, cliquez sur +Groupes pour en ajouter !";
	}

}
