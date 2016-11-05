package nezzari.projects.connexions.mysql;

import java.sql.DriverManager;
import java.sql.SQLException;

import nezzari.projects.connexions.Connexion;
import nezzari.projects.factory.DAOException;

public class MYSQLConnexion extends Connexion {

	private static MYSQLConnexion instance;

	private MYSQLConnexion() {
		super(new MYSQLConfiguration());
	}

	public static MYSQLConnexion getInstance() {
		if (instance == null) {
			instance = new MYSQLConnexion();
		}
		return instance;
	}

	@Override
	public void initier() throws DAOException {
		try {
			super.initier();
			bddConnexion = DriverManager.getConnection(config.getHote() + config.getBdd() + config.getParametres(),
					config.getPseudo(), config.getMdp());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		}
	}

}
