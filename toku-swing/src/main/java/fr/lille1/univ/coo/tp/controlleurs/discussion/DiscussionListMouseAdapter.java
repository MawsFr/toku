package fr.lille1.univ.coo.tp.controlleurs.discussion;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JDiscussionList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableListMouseAdapter;

public class DiscussionListMouseAdapter extends JObservableListMouseAdapter<AffectationDiscussion> {
	public DiscussionListMouseAdapter(JDiscussionList listeDiscussions) {
		super(listeDiscussions);
	}

	@Override
	public void doubleClic(AffectationDiscussion element) {
        new FenetreDiscussion(element.getDiscussion());
	}

	@Override
	public void clic(AffectationDiscussion element) {}

	@Override
	public void clicDroit(AffectationDiscussion element) {}
	
}
