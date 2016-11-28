package fr.lille1.univ.coo.tp.utilisateur;

import java.util.List;

public interface IListeUtilisateur {

	void ajouter(Utilisateur utilisateur);

	void supprimer(Utilisateur utilisateur);

	/**
	 * @return Le utilisateurs
	 */
	List<Utilisateur> getUtilisateurs();

	/**
	 * @param utilisateurs Le nouveau utilisateurs
	 */
	void setUtilisateurs(List<Utilisateur> utilisateurs);

}