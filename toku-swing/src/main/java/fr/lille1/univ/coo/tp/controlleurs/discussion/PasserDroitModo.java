package fr.lille1.univ.coo.tp.controlleurs.discussion;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;

public class PasserDroitModo extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private FenetreDiscussion fenetre;

	public PasserDroitModo(FenetreDiscussion fenetre) {
		putValue(NAME, FenetreDiscussion.LBL_PASSER_DROIT_MODO);
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		fenetre.passerDroitModo();
	}
	
	
}
