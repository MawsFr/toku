package fr.lille1.univ.coo.tp.role;

import java.util.List;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.annotations.UnAPlusieurs;

@Table
public class Role {
	@Id
	private Integer id;
	
	@Colonne
	private String nom;
	
	@PlusieursAUn(saCle = "id_parent", sonType = Role.class, mappeePar="roles")
	private Role parent;
	
	@UnAPlusieurs(leurType=Role.class, maCle="id_parent")
	private List<Role> roles;
	
	public Role() {
	}
	
	public Role(Integer id, String nom, Role parent) {
		this.id = id;
		this.nom = nom;
		this.parent = parent;
	}
	
	public Integer getId() {
		return id;
	}
	
	/**
	 * @return Le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom Le nouveau nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return Le parent
	 */
	public Role getParent() {
		return parent;
	}

	/**
	 * @param parent Le nouveau parent
	 */
	public void setParent(Role parent) {
		this.parent = parent;
	}

	/**
	 * @param id Le nouveau id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return Le roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles Le nouveau roles
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return nom;
	}
	
}
