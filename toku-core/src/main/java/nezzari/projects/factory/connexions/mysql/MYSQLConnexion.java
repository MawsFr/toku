package nezzari.projects.factory.connexions.mysql;

import java.sql.DriverManager;
import java.sql.SQLException;

import nezzari.projects.factory.connexions.Connexion;

public class MYSQLConnexion extends Connexion {
	
	private static MYSQLConnexion instance;
	
	private MYSQLConnexion() throws ClassNotFoundException, SQLException {
		super(new MYSQLConfiguration());
	}
	
	public static MYSQLConnexion getInstance() throws ClassNotFoundException, SQLException {
		if(instance == null) {
			instance = new MYSQLConnexion();
		}
		return instance;
	}

	@Override
	public void initier() throws ClassNotFoundException, SQLException {
		super.initier();
		bddConnexion = DriverManager.getConnection(config.getHote() + config.getBdd() + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", config.getPseudo(), config.getMdp());
	}

}
