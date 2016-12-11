package fr.lille1.univ.coo.tp.vue.listes;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public class JAffectationList extends JFiltrableList<AffectationDiscussion> {

	private static final long serialVersionUID = 1L;

	public JAffectationList(IObservableList<AffectationDiscussion> iObservableList) {
		super(iObservableList);
	}

}
