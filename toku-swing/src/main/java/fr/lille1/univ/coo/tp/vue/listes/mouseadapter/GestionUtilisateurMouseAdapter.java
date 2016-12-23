package fr.lille1.univ.coo.tp.vue.listes.mouseadapter;

import java.awt.event.MouseEvent;

import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.listes.JObservableList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.GestionUtilisateurs;

public class GestionUtilisateurMouseAdapter extends JObservableListMouseAdapter<Utilisateur> {
	private GestionUtilisateurs gestionUtilisateur;

	public GestionUtilisateurMouseAdapter(GestionUtilisateurs gestionUtilisateurs, JObservableList<Utilisateur> liste) {
		super(liste);
		this.gestionUtilisateur = gestionUtilisateurs;
	}

	@Override
	public void doubleClic(Utilisateur element, MouseEvent e) {
		if(element == null) {
			return;
		}
		gestionUtilisateur.getBtnModifier().doClick();
	}

	@Override
	public void clic(Utilisateur element, MouseEvent e) {
	}

	@Override
	public void clicDroit(Utilisateur element, MouseEvent e) {
		
	}
	
}
