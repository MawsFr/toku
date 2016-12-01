package fr.lille1.univ.coo.tp.role;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.annotations.UnAPlusieurs;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.visiteur.Visiteur;

@Table
public class Role extends ObjetDomaine implements IRole {
	@Id
	private Integer id;
	
	@Colonne
	private String nom;
	
	@PlusieursAUn(saCle = "id_parent", sonType = Role.class, mappeePar="roles")
	private IRole parent;
	
	@UnAPlusieurs(leurType=Role.class, maCle="id_parent")
	private IObservableList<Role> roles;
	
	public Role() {
	}
	
	public Role(Integer id, String nom, Role parent) {
		this.id = id;
		this.nom = nom;
		this.parent = parent;
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
	 * @see fr.lille1.univ.coo.tp.role.IRole#getParent()
	 */
	@Override
	public IRole getParent() {
		return parent;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#setParent(fr.lille1.univ.coo.tp.role.Role)
	 */
	@Override
	public void setParent(IRole parent) {
		this.parent = parent;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#getRoles()
	 */
	@Override
	public IObservableList<Role> getRoles() {
		return roles;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#setRoles(java.util.List)
	 */
	@Override
	public void setRoles(IObservableList<Role> roles) {
		this.roles = roles;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#toString()
	 */
	@Override
	public String toString() {
		return nom;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#accept(fr.lille1.univ.coo.tp.visiteur.Visiteur)
	 */
	@Override
	public void accept(Visiteur visitor) throws DomainException {
		visitor.visit(this);
	}
	
}
