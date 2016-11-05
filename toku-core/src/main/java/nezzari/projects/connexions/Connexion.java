package nezzari.projects.connexions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import nezzari.projects.factory.DAOException;

/**
 * Cette classe contient la connexion a la BDD ainsi que la configuration
 * contenant les informations de connexion.
 * 
 * @author Mustapha Nezzari
 * 
 */
public class Connexion {
	protected Connection bddConnexion;
	protected Configuration config;

	/**
	 * Constructeur prenant en parametre :
	 * 
	 * @param configuration
	 *            La configuration contenant les informations de connexion a la
	 *            BDD
	 */
	public Connexion(Configuration configuration) {
		this.config = configuration;
	}

	/**
	 * Initie la connexion a la base de donnees.
	 * 
	 * @throws ClassNotFoundException
	 * @throws DAOException
	 * @throws SQLException 
	 */
	public void initier() throws DAOException {
		try {
			Class.forName(config.getNomDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

	/**
	 * Retourne la connexion a la BDD.
	 * 
	 * @return La connexion a la BDD.
	 */
	public Connection getBddConnexion() {
		return bddConnexion;
	}

	/**
	 * Met a jour la connexion a la base de donnees.
	 * 
	 * @return La nouvelle connexion a la base de donnees
	 */
	public Configuration getConfig() {
		return config;
	}

}
