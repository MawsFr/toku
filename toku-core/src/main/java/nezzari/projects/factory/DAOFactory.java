package nezzari.projects.factory;

import java.sql.Connection;
import java.sql.SQLException;

import nezzari.projects.connexions.mysql.MYSQLConnexion;
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
	
	public static void setConnexion(Connection connexion) {
		DAOFactory.connexion = connexion;
	}
	
	public static void fermerConnexion() throws SQLException {
		connexion.close();
	}


}
