package fr.lille1.univ.coo.tp.controlleurs;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.discussion.IDiscussion;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.ObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;
import fr.lille1.univ.coo.tp.vue.gestion.utilisateurs.JDiscussionList;

public class DiscussionListMouseAdapter extends MouseAdapter {
	private JDiscussionList list;
	
	public DiscussionListMouseAdapter(JDiscussionList listeDiscussion) {
		this.list = listeDiscussion;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            // Double-click detected
            IDiscussion discussion = list.getModel().getElementAt(list.locationToIndex(e.getPoint()));
            new FenetreDiscussion(discussion.getMembres());
            
//            fenetre.getLblTypeDiscussion().setText("Discussion privée : ");
//            fenetre.getLblNomDiscussion().setText(discussion.getPseudo());
            //MAP DISCUSSION UTILISATEUR
        }
	}
	
}
