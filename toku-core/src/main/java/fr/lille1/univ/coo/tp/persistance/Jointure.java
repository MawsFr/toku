package fr.lille1.univ.coo.tp.persistance;

public class Jointure {
	protected String tableAssociation;
	protected String leurColonne;
	protected String leurType;
	protected String leurId;
	
	/**
	 * @return Le tableAssociation
	 */
	public String getTableAssociation() {
		return tableAssociation;
	}

	/**
	 * @param tableAssociation Le nouveau tableAssociation
	 */
	public void setTableAssociation(String tableAssociation) {
		this.tableAssociation = tableAssociation;
	}

	/**
	 * @return Le leurColonne
	 */
	public String getLeurColonne() {
		return leurColonne;
	}

	/**
	 * @param leurColonne Le nouveau leurColonne
	 */
	public void setLeurColonne(String leurColonne) {
		this.leurColonne = leurColonne;
	}
	
	/**
	 * @return Le leurType
	 */
	public String getLeurType() {
		return leurType;
	}

	/**
	 * @param leurType Le nouveau leurType
	 */
	public void setLeurType(String leurType) {
		this.leurType = leurType;
	}

	/**
	 * @return Le leurId
	 */
	public String getLeurId() {
		return leurId;
	}

	/**
	 * @param leurId Le nouveau leurId
	 */
	public void setLeurId(String leurId) {
		this.leurId = leurId;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("JOIN ").append(tableAssociation).append(" ON ").append(leurType).append(".").append(leurId).append(" = ").append(tableAssociation).append(".").append(leurColonne).toString();
	}
}
