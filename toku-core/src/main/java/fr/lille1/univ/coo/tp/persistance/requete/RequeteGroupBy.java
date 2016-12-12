package fr.lille1.univ.coo.tp.persistance.requete;

import java.util.Set;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;

public class RequeteGroupBy extends Requete {
	protected Set<String> clauseGroupBy;
	
	public RequeteGroupBy(Class<? extends IObjetDomaine<?>> classe, Set<String> clauseGroupBy) {
		super(classe);
		this.clauseGroupBy = clauseGroupBy;
	}
	
	public RequeteGroupBy(Class<? extends IObjetDomaine<?>> classe) {
		super(classe);
	}
	
	public Requete groupBy(Set<String> criteres) {
		this.clauseGroupBy = criteres;
		return this;
	}

	@Override
	public String accept(RequeteParser requeteVisitor) {
		return requeteVisitor.visit(this);
	}

}
