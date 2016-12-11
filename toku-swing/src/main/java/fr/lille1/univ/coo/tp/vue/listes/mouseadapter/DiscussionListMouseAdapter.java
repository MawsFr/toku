package fr.lille1.univ.coo.tp.vue.listes.mouseadapter;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;
import fr.lille1.univ.coo.tp.vue.listes.JAffectationList;

public class DiscussionListMouseAdapter extends JObservableListMouseAdapter<AffectationDiscussion> {
	public DiscussionListMouseAdapter(JAffectationList listeDiscussions) {
		super(listeDiscussions);
	}

	@Override
	public void doubleClic(AffectationDiscussion element) {
		if(element == null) {
			return;
		}
        new FenetreDiscussion(element.getDiscussion());
	}

	@Override
	public void clic(AffectationDiscussion element) {}

	@Override
	public void clicDroit(AffectationDiscussion element) {}
	
}
