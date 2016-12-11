package fr.lille1.univ.coo.tp.controlleurs.composants;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.filtre.Filtreur;
import fr.lille1.univ.coo.tp.vue.listes.JFiltrableList;

public abstract class FiltrerAction<T extends IObjetDomaine> extends Filtreur implements DocumentListener {

	protected JFiltrableList<T> liste;

	public FiltrerAction(JFiltrableList<T> liste) {
		super(liste.getTexte().getLeModel());
		this.liste = liste;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		notifier(e);
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		notifier(e);
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		notifier(e);
	}

	public abstract void notifier(DocumentEvent e);

}
