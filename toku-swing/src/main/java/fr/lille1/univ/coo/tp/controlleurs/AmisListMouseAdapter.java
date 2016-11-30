package fr.lille1.univ.coo.tp.controlleurs;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.ObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;
import fr.lille1.univ.coo.tp.vue.gestion.utilisateurs.JUtilisateurList;

public class AmisListMouseAdapter extends MouseAdapter {
	private JUtilisateurList list;
	
	public AmisListMouseAdapter(JUtilisateurList listeUtilisateur) {
		this.list = listeUtilisateur;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            // Double-click detected
            Utilisateur destinataire = list.getModel().getElementAt(list.locationToIndex(e.getPoint()));
            IObservableList<Utilisateur> membres = new ObservableList<>();
            membres.ajouter(Application.getInstance().getSession().getUtilisateur());
            membres.ajouter(destinataire);
            FenetreDiscussion fenetre = new FenetreDiscussion(membres);
            fenetre.getLblTypeDiscussion().setText("Discussion privée : ");
            fenetre.getLblNomDiscussion().setText(destinataire.getPseudo());
            //MAP DISCUSSION UTILISATEUR
        }
	}
	
}
