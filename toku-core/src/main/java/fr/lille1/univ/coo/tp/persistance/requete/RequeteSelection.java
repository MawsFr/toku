package fr.lille1.univ.coo.tp.persistance.requete;

import java.util.HashSet;
import java.util.Set;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;

public class RequeteSelection extends RequeteJoin {

	protected Set<String> clauseSelect;
	protected Integer clauseLimit;

	public RequeteSelection(Class<? extends IObjetDomaine> classe, String... fields) {
		super(classe);
		this.clauseSelect = new HashSet<>();
		clauseLimit = 0;
		for(String field : fields) {
			clauseSelect.add(field);
		}
	}
	
	@Override
	public RequeteSelection where(Critere critere) {
		super.where(critere);
		return this;
	}
	
	@Override
	public RequeteSelection joindre(Class<? extends IObjetDomaine> classe, Critere criteres) {
		super.joindre(classe, criteres);
		return this;
	}
	
	public RequeteSelection limiter(Integer i) {
		this.clauseLimit = i;
		return this;
	}

	@Override
	public void accept(RequeteVisitor requeteVisitor) {
		requeteVisitor.visit(this);
	}
}
