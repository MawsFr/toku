package fr.lille1.univ.coo.tp.role;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.filtre.Visiteur;

@Table
public class Role extends ObjetDomaine<Integer> implements IRole {
	@Id
	private Integer id;
	
	@Colonne
	private String nom;
	
	public Role() {
	}
	
	public Role(Integer id, String nom, Role parent) {
		this.id = id;
		this.nom = nom;
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#getNom()
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#setNom(java.lang.String)
	 */
	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#toString()
	 */
	@Override
	public String toString() {
		return nom;
	}

	@Override
	public void accept(Visiteur visitor) throws DomainException {
		visitor.visit(this);
	}
}
