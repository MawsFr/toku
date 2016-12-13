package fr.lille1.univ.coo.tp.controlleurs.discussion;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;

public class QuitterGroupeAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private FenetreDiscussion fenetre;

	public QuitterGroupeAction(FenetreDiscussion fenetreDiscussion) {
		this.fenetre = fenetreDiscussion;
		putValue(NAME, FenetreDiscussion.BTN_QUITTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fenetre.quitter();
	}


}
