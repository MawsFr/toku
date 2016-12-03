package fr.lille1.univ.coo.tp.utilisateur;

import java.util.List;

import fr.lille1.univ.coo.tp.observateur.Observateur;

public interface IObservableList<T> {

	void ajouter(T t);

	void supprimer(T t);

	/**
	 * @return Le utilisateurs
	 */
	List<T> getListe();

	/**
	 * @param liste Le nouveau utilisateurs
	 */
	void setListe(List<T> liste);

	void ajouterObservateur(Observateur<T> observateur);

}