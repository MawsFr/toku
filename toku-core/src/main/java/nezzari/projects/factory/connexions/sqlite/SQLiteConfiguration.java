package nezzari.projects.factory.connexions.sqlite;

import nezzari.projects.factory.connexions.Configuration;

public class SQLiteConfiguration extends Configuration {
	public static final String SQLITE_NOM_DRIVER= "org.sqlite.JDBC";
	public static final String SQLITE_HOTE= "jdbc:sqlite:bdd.db";
	
	public SQLiteConfiguration() {
		super(SQLITE_NOM_DRIVER, SQLITE_HOTE);
	}
	
}
