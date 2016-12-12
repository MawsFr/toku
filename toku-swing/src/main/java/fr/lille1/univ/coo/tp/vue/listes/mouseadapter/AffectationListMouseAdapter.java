package fr.lille1.univ.coo.tp.vue.listes.mouseadapter;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.vue.listes.JObservableList;

public class AffectationListMouseAdapter extends JObservableListMouseAdapter<AffectationDiscussion> {

	public AffectationListMouseAdapter(JObservableList<AffectationDiscussion> liste) {
		super(liste);
	}

	@Override
	public void doubleClic(AffectationDiscussion element) {
	}

	@Override
	public void clic(AffectationDiscussion element) {

	}

	@Override
	public void clicDroit(AffectationDiscussion element) {

	}

}
