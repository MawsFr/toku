package fr.lille1.univ.coo.tp.controlleurs;

import java.awt.event.MouseEvent;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.ObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableListMouseAdapter;

public class AmisListMouseAdapter extends JObservableListMouseAdapter<Utilisateur> {
	public AmisListMouseAdapter(JObservableList<Utilisateur> liste) {
		super(liste);
	}

	@Override
	public void doubleClic(Utilisateur element) {
		IObservableList<Utilisateur> membres = new ObservableList<>();
        membres.ajouter(Application.getInstance().getSession().getUtilisateur());
        membres.ajouter(element);
        FenetreDiscussion fenetre = new FenetreDiscussion(membres);
        fenetre.getLblTypeDiscussion().setText("Discussion privée : ");
        fenetre.getLblNomDiscussion().setText(element.getPseudo());
	}

	@Override
	public void clic(Utilisateur element) {
		
	}

	@Override
	public void clicDroit(Utilisateur element) {
		
	}
	
}
