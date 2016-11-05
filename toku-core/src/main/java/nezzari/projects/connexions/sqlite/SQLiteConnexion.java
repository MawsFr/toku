package nezzari.projects.connexions.sqlite;

import java.sql.DriverManager;
import java.sql.SQLException;

import nezzari.projects.connexions.Connexion;
import nezzari.projects.factory.DAOException;

public class SQLiteConnexion extends Connexion {
	
	private static SQLiteConnexion instance;
	
	private SQLiteConnexion() {
		super(new SQLiteConfiguration());
	}
	
	public static SQLiteConnexion getInstance() {
		if(instance == null) {
			instance = new SQLiteConnexion();
		}
		return instance;
	}

	@Override
	public void initier() throws DAOException {
		try {
			super.initier();
			bddConnexion = DriverManager.getConnection(config.getHote());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
		
	}

}
