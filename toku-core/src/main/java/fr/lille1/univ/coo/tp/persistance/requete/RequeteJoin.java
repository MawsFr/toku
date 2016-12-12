package fr.lille1.univ.coo.tp.persistance.requete;

import java.util.HashMap;
import java.util.Map;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;

public abstract class RequeteJoin extends RequeteWhere {
	protected Map<Class<?>, Critere> clauseJoin;

	public RequeteJoin(Class<? extends IObjetDomaine<?>> classe) {
		super(classe);
		this.clauseJoin = new HashMap<>();
	}

	public RequeteJoin joindre(Class<? extends IObjetDomaine<?>> classe, Critere criteres) {
		this.clauseJoin.put(classe, criteres);
		return this;
	}

}