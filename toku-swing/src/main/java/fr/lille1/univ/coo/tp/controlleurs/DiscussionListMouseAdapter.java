package fr.lille1.univ.coo.tp.controlleurs;

import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JDiscussionList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableListMouseAdapter;

public class DiscussionListMouseAdapter extends JObservableListMouseAdapter<Discussion> {
	public DiscussionListMouseAdapter(JDiscussionList listeDiscussions) {
		super(listeDiscussions);
	}

	@Override
	public void doubleClic(Discussion element) {
//        new FenetreDiscussion(element.getDiscussion().getMembres());
	}

	@Override
	public void clic(Discussion element) {}

	@Override
	public void clicDroit(Discussion element) {}
	
}
