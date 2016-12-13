package fr.lille1.univ.coo.tp.vue.listes.mouseadapter;

import java.awt.event.MouseEvent;

import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreAffectation;
import fr.lille1.univ.coo.tp.vue.listes.JObservableList;

public class NouvelleAffectationListMouseAdapter extends JObservableListMouseAdapter<Amitie> {
	private FenetreAffectation fenetreAffectation;

	public NouvelleAffectationListMouseAdapter(FenetreAffectation fenetreAffectation, JObservableList<Amitie> liste) {
		super(liste);
		this.fenetreAffectation = fenetreAffectation;
	}

	@Override
	public void doubleClic(Amitie element, MouseEvent e) {
		fenetreAffectation.ajouterAmi(element);
	}

	@Override
	public void clic(Amitie element, MouseEvent e) {

	}

	@Override
	public void clicDroit(Amitie element, MouseEvent e) {

	}

}
