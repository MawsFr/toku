package nezzari.projects.connexions;

/**
 * Cette classe regroupe les informations de connexion a une base de donnees.
 * 
 * @author Mustapha Nezzari
 *
 */
public class Configuration {
	
	public static final String MYSQL_NOM_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_PARAMETRES = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
	
	protected String nomDriver;
	protected String hote;
	protected String pseudo;
	protected String mdp;
	protected String bdd;
	protected String parametres;

	/**
	 * Constructeur prenant en parametres :
	 * 
	 * @param nomDriver
	 *            Le nom du driver JDBC
	 * @param hote
	 *            L'adresse de l'hote
	 * @param pseudo
	 *            L'adresse de l'hote
	 * @param bdd
	 *            Le nom de la BDD
	 * @param parametres
	 *            Les parametres de connexion
	 */
	
	public Configuration() {}
	
	public Configuration(String nomDriver, String hote, String pseudo, String bdd, String parametres) {
		this.nomDriver = nomDriver;
		this.hote = hote;
		this.pseudo = pseudo;
		this.bdd = bdd;
		this.parametres = parametres;
	}
	
	public Configuration(String nomDriver, String hote) {
		this.nomDriver = nomDriver;
		this.hote = hote;
	}

	/**
	 * Retourne le nom du driver JDBC.
	 * 
	 * @return Le nom du driver JDBC
	 */
	public String getNomDriver() {
		return nomDriver;
	}

	/**
	 * Met a jour le nom du driver JDBC.
	 * 
	 * @param nomDriver
	 *            Le nouveau nom du driver JDBC
	 */
	public void setNomDriver(String nomDriver) {
		this.nomDriver = nomDriver;
	}

	/**
	 * Retourne le nom de l'adresse de l'hote de la BDD.
	 * 
	 * @return Le nom de l'adresse de l'hote de la BDD
	 */
	public String getHote() {
		return hote;
	}

	/**
	 * Met a jour le nom de l'adresse de l'hote de la BDD.
	 * 
	 * @param hote
	 *            Le nouveau nom de l'adresse de l'hote de la BDD
	 */
	public void setHote(String hote) {
		this.hote = hote;
	}

	/**
	 * Retourne le pseudo.
	 * 
	 * @return Le pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Met a jour le pseudo.
	 * 
	 * @param pseudo
	 *            Le nouveau pseudo
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Retourne le mot de passe de connexion.
	 * 
	 * @return Le mot de passe de connexion
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * Met a jour le mot de passe de connexion.
	 * 
	 * @param mdp
	 *            Le nouveau mot de passe de connexion
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * Retourne le nom de la BDD.
	 * 
	 * @return Le nom de la BDD
	 */
	public String getBdd() {
		return bdd;
	}

	/**
	 * Met a jout le nom de la BDD.
	 * 
	 * @param bdd
	 *            Le nouveau nom de la BDD
	 */
	public void setBdd(String bdd) {
		this.bdd = bdd;
	}

	/**
	 * Retourne les parametres de connexion a la BDD.
	 * 
	 * @return Les parametres de connexion a la BDD
	 */
	public String getParametres() {
		return parametres;
	}

	/**
	 * Met a jour les parametres de connexion a la BDD.
	 * 
	 * @param parametres
	 *            Les nouveaux parametres de connexion a la BDD.
	 */
	public void setParametres(String parametres) {
		this.parametres = parametres;
	}

}
