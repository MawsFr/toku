package nezzari.projects.factory.connexions;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Connexion {
	protected Connection bddConnexion;
	protected Configuration config;

	public Connexion(Configuration configuration) throws ClassNotFoundException, SQLException {
		this.config = configuration;
	}
	public void initier() throws ClassNotFoundException, SQLException {
		Class.forName(config.getNomDriver());
	}
	
	public Connection getBddConnexion() {
		return bddConnexion;
	}

	public Configuration getConfig() {
		return config;
	}

}
