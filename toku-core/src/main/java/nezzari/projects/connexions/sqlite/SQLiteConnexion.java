package nezzari.projects.connexions.sqlite;

import java.sql.DriverManager;
import java.sql.SQLException;

import nezzari.projects.connexions.Connexion;

public class SQLiteConnexion extends Connexion {
	
	private static SQLiteConnexion instance;
	
	private SQLiteConnexion() throws ClassNotFoundException, SQLException {
		super(new SQLiteConfiguration());
	}
	
	public static SQLiteConnexion getInstance() throws ClassNotFoundException, SQLException {
		if(instance == null) {
			instance = new SQLiteConnexion();
		}
		return instance;
	}

	@Override
	public void initier() throws ClassNotFoundException, SQLException {
		super.initier();
		bddConnexion = DriverManager.getConnection(config.getHote());
		
	}

}
