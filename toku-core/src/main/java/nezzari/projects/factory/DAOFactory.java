package nezzari.projects.factory;

import java.sql.Connection;
import java.sql.SQLException;

import nezzari.projects.connexions.Configuration;
import nezzari.projects.connexions.Connexion;
import nezzari.projects.groupe.GroupeDAO;
import nezzari.projects.utilisateur.IUtilisateurDAO;
import nezzari.projects.utilisateur.UtilisateurDAO;

/**
 * Cette classe permet de regrouper tout les DAO et d'y acceder rapidement.
 * @author Mustapha NEZZARI
 *
 */
public class DAOFactory {
	
	private static Connection connexion;
	
	public static IUtilisateurDAO getUtilisateurDAO() {
		return UtilisateurDAO.getInstance(connexion);
	}
	
	public static GroupeDAO getGroupeDAO() {
		return GroupeDAO.getInstance(connexion);
	}
	
	/**
	 * Initialise la connexion a la BDD.
	 * @throws ClassNotFoundException Si le driver n'est pas trouve.
	 * @throws DAOException Erreur lors de la connexion a la BDD.
	 * @throws SQLException 
	 */
	public static void ouvrirConnexion(Configuration config) throws DAOException {
		Connexion co = new Connexion(config);
		co.initier();
		DAOFactory.setConnexion(co.getBddConnexion());
	}
	
//	/**
//	 * Efface le contenu de toute les tables (grace a des on delete cascade)
//	 * @throws DAOException Erreur lors de la suppression.
//	 */
//	public static void reinitialiserTables() throws DAOException {
//		getPersonneDAO().effacerTout();
//		getBureauDAO().effacerTout();
//		
//	}
	
	/**
	 * Retourne la connexion a la BDD.
	 * @return La connexion à la BDD
	 */
	public static Connection getConnexion() {
		return connexion;
	}
	
	/**
	 * Met a jour la connexion a la BDD.
	 * @param connexion La nouvelle connexion a la BDD.
	 */
	public static void setConnexion(Connection connexion) {
		DAOFactory.connexion = connexion;
	}
	
	/**
	 * Ferme la connexion a la BDD en cours.
	 * @throws DAOException Erreur lors de la fermeture de la connexion a la BDD.
	 */
	public static void fermerConnexion() throws DAOException {
		try {
			if(connexion != null) {
				connexion.close();
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}


}
