package fr.lille1.univ.coo.tp.controlleurs.discussion;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;

public class EnvoyerMessageAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private FenetreDiscussion fenetre;
	
	public EnvoyerMessageAction(FenetreDiscussion fenetre) {
		this.fenetre = fenetre;
		putValue(NAME, FenetreDiscussion.BTN_ENVOYER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		fenetre.envoyer();
	}
	
}
