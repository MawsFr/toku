package fr.lille1.univ.coo.tp.controlleurs;

import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.ObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableListMouseAdapter;

public class AmisListMouseAdapter extends JObservableListMouseAdapter<Amitie> {
	public AmisListMouseAdapter(JObservableList<Amitie> liste) {
		super(liste);
	}

	@Override
	public void doubleClic(Amitie element) {
		IObservableList<Utilisateur> membres = new ObservableList<>();
        membres.ajouter(element.getUtilisateur());
        membres.ajouter(element.getAmi());
        FenetreDiscussion fenetre = new FenetreDiscussion(membres);
        fenetre.getLblTypeDiscussion().setText("Discussion privée : ");
        fenetre.getLblNomDiscussion().setText(element.getAmi().getPseudo());
	}

	@Override
	public void clic(Amitie element) {
		
	}

	@Override
	public void clicDroit(Amitie element) {
		
	}
	
}
