package fr.lille1.univ.coo.tp.utilisateur;

import java.util.List;

import fr.lille1.univ.coo.tp.observateur.Observateur;

public interface IObservableList<T> {

	void ajouter(T utilisateur);

	void supprimer(T utilisateur);

	/**
	 * @return Le utilisateurs
	 */
	List<T> getUtilisateurs();

	/**
	 * @param utilisateurs Le nouveau utilisateurs
	 */
	void setUtilisateurs(List<T> utilisateurs);

	void ajouterObservateur(Observateur<T> utilisateurListModel);

}