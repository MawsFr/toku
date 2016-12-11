package fr.lille1.univ.coo.tp.vue.listes.mouseadapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.vue.listes.JObservableList;

public abstract class JObservableListMouseAdapter<T extends IObjetDomaine<?>> extends MouseAdapter {
	protected JObservableList<T> liste;

	public JObservableListMouseAdapter(JObservableList<T> liste) {
		this.liste = liste;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		T element = getElementSelectionne(e);
		liste.setElementSelectionne(element);
		
		if(e.getButton() == MouseEvent.BUTTON3) {
			System.out.println("Clique droit !");
			clicDroit(element);
		} else if(e.getButton() == MouseEvent.BUTTON1) {
			if(e.getClickCount() == 1) {
				clic(element);
			} else if (e.getClickCount() == 2) {
				doubleClic(element);
			}
		}
	}

	public abstract void doubleClic(T element);
	public abstract void clic(T element);
	public abstract void clicDroit(T element);

	public T getElementSelectionne(MouseEvent e) {
		if (e.getClickCount() > 0 && liste.getSelectedIndex() >= 0) {
			return liste.getModel().getElementAt(liste.locationToIndex(e.getPoint()));
		}
		
		return null;
	}
}
