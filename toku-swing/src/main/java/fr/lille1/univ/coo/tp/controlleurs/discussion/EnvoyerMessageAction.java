package fr.lille1.univ.coo.tp.controlleurs.discussion;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;

public class EnvoyerMessageAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private FenetreDiscussion fenetre;
	
	public EnvoyerMessageAction(FenetreDiscussion fenetre) {
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Discussion discussion = fenetre.getDiscussion();
		String texte = fenetre.getTxtMessage().getText();
		
		
		try {
			Service.getDiscussionService().envoyerMessage(discussion, texte);
		} catch (ServiceException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(fenetre, "Erreur lors de l'envoi du message", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
