package fr.lille1.univ.coo.tp.connexions;

public class LocalMysqlConfiguration extends Configuration {

	public static final String MYSQL_HOTE = "jdbc:mysql://localhost:8889";
	public static final String MYSQL_PSEUDO = "root";
	public static final String MYSQL_BDD = "toku";

	public LocalMysqlConfiguration() {
		super(MYSQL_NOM_DRIVER, MYSQL_HOTE, MYSQL_PSEUDO, MYSQL_BDD, MYSQL_PARAMETRES);
	}

}
