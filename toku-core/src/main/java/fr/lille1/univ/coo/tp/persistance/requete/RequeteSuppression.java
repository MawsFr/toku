package fr.lille1.univ.coo.tp.persistance.requete;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;

public class RequeteSuppression extends RequeteWhere {

	public RequeteSuppression(Class<? extends IObjetDomaine> classe) {
		super(classe);
	}

	public RequeteSuppression where(Critere critere) {
		super.where(critere);
		return this;
	}
	
	@Override
	public void accept(RequeteParser requeteVisitor) {
		requeteVisitor.visit(this);
	}
}
