package fr.lille1.univ.coo.tp.persistance.requete;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;

public class RequeteSelection extends RequeteJoin {

	protected Set<String> clauseSelect;
	protected Integer clauseLimit;
	protected Set<String> clauseGroupBy;

	public RequeteSelection(Class<? extends IObjetDomaine<?>> classe, String... fields) {
		super(classe);
		this.clauseSelect = new HashSet<>();
		this.clauseGroupBy = new HashSet<>();
		Collections.addAll(clauseSelect, fields);
		clauseLimit = 0;
	}
	
	@Override
	public RequeteSelection where(Critere critere) {
		super.where(critere);
		return this;
	}
	
	@Override
	public RequeteSelection joindre(Class<? extends IObjetDomaine<?>> classe, Critere criteres) {
		super.joindre(classe, criteres);
		return this;
	}
	
	public RequeteSelection limiter(Integer i) {
		this.clauseLimit = i;
		return this;
	}
	
	public RequeteSelection groupBy(String... fields) {
		Collections.addAll(clauseGroupBy, fields);
		return this;
	}

	@Override
	public String accept(RequeteParser requeteVisitor) {
		return requeteVisitor.visit(this);
	}
}
