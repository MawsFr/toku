package fr.lille1.univ.coo.tp.vue.listes;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.filtre.EstValide;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public class JAmisList extends JFiltrableList<Amitie> {

	private static final long serialVersionUID = 1L;

	public JAmisList(IObservableList<Amitie> amities ) {
		super(amities);
		EstValide estValide = new EstValide();
		getLeModel().setFiltreDeBase(estValide);
		try {
			getLeModel().filtrer(estValide);
		} catch (DomainException e) {
			e.printStackTrace();
		}
	}

}
