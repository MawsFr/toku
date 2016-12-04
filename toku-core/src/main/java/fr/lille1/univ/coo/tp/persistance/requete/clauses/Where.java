package fr.lille1.univ.coo.tp.persistance.requete.clauses;

import fr.lille1.univ.coo.tp.persistance.requete.Critere;

public interface Where<T> {
	public void where(Critere critere);
}
