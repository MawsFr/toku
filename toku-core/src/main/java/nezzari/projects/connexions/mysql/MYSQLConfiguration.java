package nezzari.projects.connexions.mysql;

import nezzari.projects.connexions.Configuration;

public class MYSQLConfiguration extends Configuration {
	
	public static final String MYSQL_NOM_DRIVER= "com.mysql.cj.jdbc.Driver";
	public static final String MYSQL_HOTE= "jdbc:mysql://localhost:3306/";
	public static final String MYSQL_PSEUDO= "root";
	public static final String MYSQL_MDP= "root";
	public static final String MYSQL_BDD = "toku";
	public static final String MYSQL_PARAMETRES = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";

	public MYSQLConfiguration() {
		super(MYSQL_NOM_DRIVER, MYSQL_HOTE, MYSQL_PSEUDO, MYSQL_MDP, MYSQL_BDD, MYSQL_PARAMETRES);
	}
	

}