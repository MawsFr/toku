package fr.lille1.univ.coo.tp.service.unitofwork;

import java.util.Set;

import fr.lille1.univ.coo.tp.visiteur.Visiteur;

/**
 * Cette classe permet de valider les changements sur les objet du domaine et
 * donc de repercuter ces changements dans la BDD.
 */
public abstract class Commiter extends Visiteur {
	protected Set<String> parametres;

	/**
	 * Retourne les parametre du commiter. Dans notre cas nous l'utilisons pour
	 * transmettre les noms des propriétés d'une classe qui ont changé.
	 * 
	 * @return La liste des parametre du commiter.
	 */
	public Set<String> getParametres() {
		return parametres;
	}

	/**
	 * Met a jour les parametres du commiter.
	 * 
	 * @param parametres
	 *            Les nouveaux paramètres
	 */
	public void setParametres(Set<String> parametres) {
		this.parametres = parametres;
	}

	/**
	 * Supprime les parametres du commiter.
	 */
	public void supprimerParametres() {
		this.parametres = null;
	}

}