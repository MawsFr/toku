package fr.lille1.univ.coo.tp.controlleurs;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JAffectationDiscussionList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableListMouseAdapter;

public class DiscussionListMouseAdapter extends JObservableListMouseAdapter<AffectationDiscussion> {
	public DiscussionListMouseAdapter(JAffectationDiscussionList listeDiscussions) {
		super(listeDiscussions);
	}

	@Override
	public void doubleClic(AffectationDiscussion element) {
        new FenetreDiscussion(element.getDiscussion().getMembres());
	}

	@Override
	public void clic(AffectationDiscussion element) {}

	@Override
	public void clicDroit(AffectationDiscussion element) {}
	
}
