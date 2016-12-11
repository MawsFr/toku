package fr.lille1.univ.coo.tp.persistance.requete;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;

public class RequeteWhere extends Requete {
	protected Critere clauseWhere;
	
	public RequeteWhere(Class<? extends IObjetDomaine<?>> classe, Critere clauseWhere) {
		super(classe);
		this.clauseWhere = clauseWhere;
	}
	
	public RequeteWhere(Class<? extends IObjetDomaine<?>> classe) {
		super(classe);
	}
	
	public Requete where(Critere criteres) {
		this.clauseWhere = criteres;
		return this;
	}

	@Override
	public String accept(RequeteParser requeteVisitor) {
		return requeteVisitor.visit(this);
	}

}
