package fr.lille1.univ.coo.tp.persistance.requete;

public class CritereNONEGALE extends Critere {
	private String field;

	public CritereNONEGALE(String field) {
		this.field = field;
	}

	/**
	 * @return Le field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field Le nouveau field
	 */
	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String accept(RequeteVisitor requeteVisitor) {
		return requeteVisitor.visit(this);
	}
}
