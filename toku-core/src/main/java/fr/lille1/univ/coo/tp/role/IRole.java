package fr.lille1.univ.coo.tp.role;

import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.visiteur.Visiteur;

@Table("role")
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
	 * @return Le parent
	 */
	IRole getParent();

	/**
	 * @param parent Le nouveau parent
	 */
	void setParent(IRole parent);

	/**
	 * @param id Le nouveau id
	 */
	void setId(Integer id);

	/**
	 * @return Le roles
	 */
	IObservableList<Role> getRoles();

	/**
	 * @param roles Le nouveau roles
	 */
	void setRoles(IObservableList<Role> roles);

	String toString();

	void accept(Visiteur visitor) throws DomainException;

}