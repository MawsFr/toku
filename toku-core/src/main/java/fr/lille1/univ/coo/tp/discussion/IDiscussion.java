package fr.lille1.univ.coo.tp.discussion;

import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

@Table("discussion")
public interface IDiscussion {

	/**
	 * @return Le id
	 */
	Integer getId();

	/**
	 * @param id Le nouveau id
	 */
	void setId(Integer id);

	/**
	 * @return Le nom
	 */
	String getNom();

	/**
	 * @param nom Le nouveau nom
	 */
	void setNom(String nom);

	/**
	 * @return Le moderateur
	 */
	IUtilisateur getModerateur();

	/**
	 * @param moderateur Le nouveau moderateur
	 */
	void setModerateur(IUtilisateur moderateur);

	/**
	 * @return Le membres
	 */
	IObservableList<Utilisateur> getMembres();

	/**
	 * @param membres Le nouveau membres
	 */
	void setMembres(IObservableList<Utilisateur> membres);
}