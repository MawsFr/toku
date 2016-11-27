package fr.lille1.univ.coo.tp.persistance;

import java.sql.Connection;
import java.sql.SQLException;

import fr.lille1.univ.coo.tp.connexions.Configuration;
import fr.lille1.univ.coo.tp.connexions.Connexion;

/**
 * Cette classe permet de gérer la connexion à la BDD.
 */
public class GestionnaireConnexion {

	private static Connection connexion;

	/**
	 * Initialise la connexion a la BDD.
	 * 
	 * @throws ClassNotFoundException
	 *             Si le driver n'est pas trouve.
	 * @throws DAOException
	 *             Erreur lors de la connexion a la BDD.
	 */
	public static void ouvrirConnexion(Configuration config) throws DAOException {
		Connexion co = new Connexion(config);
		co.initier();
		GestionnaireConnexion.setConnexion(co.getBddConnexion());
	}

	/**
	 * Retourne la connexion a la BDD.
	 * 
	 * @return La connexion à la BDD
	 */
	public static Connection getConnexion() {
		return connexion;
	}

	/**
	 * Met a jour la connexion a la BDD.
	 * 
	 * @param connexion
	 *            La nouvelle connexion a la BDD.
	 */
	public static void setConnexion(Connection connexion) {
		GestionnaireConnexion.connexion = connexion;
	}

	/**
	 * Ferme la connexion a la BDD en cours.
	 * 
	 * @throws DAOException
	 *             Erreur lors de la fermeture de la connexion a la BDD.
	 */
	public static void fermerConnexion() throws DAOException {
		System.out.println("Fermeture de la connexion");
		try {
			if (connexion != null) {
				connexion.close();
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
