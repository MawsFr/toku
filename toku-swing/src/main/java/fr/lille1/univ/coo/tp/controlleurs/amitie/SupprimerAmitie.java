package fr.lille1.univ.coo.tp.controlleurs.amitie;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;

public class SupprimerAmitie  extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private FenetreDiscussion fenetre;

	public SupprimerAmitie(FenetreDiscussion fenetreDiscussion) {
		this.fenetre = fenetreDiscussion;
		putValue(NAME, FenetreDiscussion.BTN_MOINS);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
