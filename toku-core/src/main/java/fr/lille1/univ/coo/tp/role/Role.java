package fr.lille1.univ.coo.tp.role;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;

@Table
public class Role {
	@Id
	private int id;
	
	@Colonne
	private String nom;
	
//	@Proxy
	@PlusieursAUn("id_parent")
	private Role parent;
	
	public Role() {
	}
	
	public Role(int id, String nom, Role parent) {
		this.id = id;
		this.nom = nom;
		this.parent = parent;
	}
	
	public int getId() {
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
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return nom;
	}
	
}
