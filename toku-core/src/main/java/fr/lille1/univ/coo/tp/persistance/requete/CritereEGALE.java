package fr.lille1.univ.coo.tp.persistance.requete;

public class CritereEGALE extends Critere {
	private String field;

	public CritereEGALE(String field) {
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
	public String accept(RequeteParser requeteVisitor) {
		return requeteVisitor.visit(this);
	}
}
