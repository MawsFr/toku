package fr.lille1.univ.coo.tp.vue.gestion.utilisateurs;

import javax.swing.ListCellRenderer;

import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class JDiscussionList extends JObservableList<Discussion> {

	private static final long serialVersionUID = 1L;
	
	public JDiscussionList() {
		super();
	}
	
	public JDiscussionList(IObservableList<Discussion> iObservableList) {
		super(iObservableList);
	}

	@Override
	public ListCellRenderer<? super Discussion> getCellRenderer() {
		return new DiscussionListCellRenderer();
	}

}
