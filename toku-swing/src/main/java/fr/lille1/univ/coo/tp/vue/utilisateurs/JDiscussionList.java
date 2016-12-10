package fr.lille1.univ.coo.tp.vue.utilisateurs;

import javax.swing.ListCellRenderer;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public class JDiscussionList extends JObservableList<AffectationDiscussion> {

	private static final long serialVersionUID = 1L;

	public JDiscussionList() {
		super();
	}

	public JDiscussionList(IObservableList<AffectationDiscussion> iObservableList) {
		super(iObservableList);
	}

	@Override
	public ListCellRenderer<? super AffectationDiscussion> getCellRenderer() {
		return new DiscussionListCellRenderer();
	}

	@Override
	public String getMessageVide() {
		return "Vous n'avez aucune discussion, cliquez sur +Groupes pour en ajouter !";
	}

}
