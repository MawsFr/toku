package fr.lille1.univ.coo.tp.persistance.requete;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;

public class RequeteMiseAJour extends RequeteWhere {
	private String[] fields;
	
	public RequeteMiseAJour(Class<? extends IObjetDomaine<?>> classe, String...fields) {
		super(classe);
		this.fields = fields;
	}
	
	/**
	 * @return Le fields
	 */
	public String[] getFields() {
		return fields;
	}

	/**
	 * @param fields Le nouveau fields
	 */
	public void setFields(String[] fields) {
		this.fields = fields;
	}

	@Override
	public String accept(RequeteParser requeteVisitor) {
		return requeteVisitor.visit(this);
		
	}
}
