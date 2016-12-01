package fr.lille1.univ.coo.tp.controlleurs;

import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableListMouseAdapter;

public class DiscussionListMouseAdapter extends JObservableListMouseAdapter<Discussion> {
	public DiscussionListMouseAdapter(JObservableList<Discussion> liste) {
		super(liste);
	}

	@Override
	public void doubleClic(Discussion element) {
        new FenetreDiscussion(element.getMembres());
	}

	@Override
	public void clic(Discussion element) {}

	@Override
	public void clicDroit(Discussion element) {}
	
}
