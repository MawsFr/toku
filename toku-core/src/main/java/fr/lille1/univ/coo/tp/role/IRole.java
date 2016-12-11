package fr.lille1.univ.coo.tp.role;

import fr.lille1.univ.coo.tp.annotations.Table;

@Table(nom="role")
public interface IRole {

	Integer getId();

	/**
	 * @return Le nom
	 */
	String getNom();

	/**
	 * @param nom Le nouveau nom
	 */
	void setNom(String nom);

	/**
	 * @param id Le nouveau id
	 */
	void setId(Integer id);

	String toString();


}