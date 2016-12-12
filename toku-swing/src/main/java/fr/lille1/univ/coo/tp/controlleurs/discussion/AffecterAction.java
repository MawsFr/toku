package fr.lille1.univ.coo.tp.controlleurs.discussion;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.vue.discussion.FenetreAffectation;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;

public class AffecterAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private FenetreDiscussion fenetre;

	public AffecterAction(FenetreDiscussion fenetreDiscussion) {
		this.fenetre = fenetreDiscussion;
		putValue(NAME, FenetreDiscussion.BTN_PLUS);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new FenetreAffectation(fenetre);
	}

}
