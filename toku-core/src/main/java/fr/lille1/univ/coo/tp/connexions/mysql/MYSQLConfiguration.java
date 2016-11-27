package fr.lille1.univ.coo.tp.connexions.mysql;

import fr.lille1.univ.coo.tp.connexions.Configuration;

public class MYSQLConfiguration extends Configuration {
	
	public static final String MYSQL_NOM_DRIVER= "com.mysql.cj.jdbc.Driver";
	public static final String MYSQL_HOTE= "jdbc:mysql://localhost:8889/";
	public static final String MYSQL_PSEUDO= "root";
	public static final String MYSQL_BDD = "toku";
	public static final String MYSQL_PARAMETRES = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";

	public MYSQLConfiguration() {
		super(MYSQL_NOM_DRIVER, MYSQL_HOTE, MYSQL_PSEUDO, MYSQL_BDD, MYSQL_PARAMETRES);
	}
	

}
