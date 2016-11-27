package fr.lille1.univ.coo.tp.connexions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.lille1.univ.coo.tp.persistance.DAOException;

/**
 * Cette classe contient la connexion a la BDD ainsi que la configuration
 * contenant les informations de connexion.
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
	 */
	public void initier() throws DAOException {
		try {
			Class.forName(config.getNomDriver());
			bddConnexion = DriverManager.getConnection(
					config.getHote() + "/" + config.getBdd() + config.getParametres(), config.getPseudo(),
					config.getMdp());
			System.out.println("Connecte a la base " + config.getBdd());
		} catch (SQLException | ClassNotFoundException e) {
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
