package fr.lille1.univ.coo.tp.connexions;

/**
 * Cette classe contient toute les information de connexion à la BDD du webtp.
 */
public class WebtpConfiguration extends Configuration {

	public static final String MYSQL_HOTE = "jdbc:mysql://webtp.fil.univ-lille1.fr";
	public static final String MYSQL_PSEUDO = "nezzari";
	public static final String MYSQL_BDD = "nezzari";

	/**
	 * Constructeur par défaut
	 */
	public WebtpConfiguration() {
		super(MYSQL_NOM_DRIVER, MYSQL_HOTE, MYSQL_PSEUDO, MYSQL_BDD, MYSQL_PARAMETRES);
	}

}
