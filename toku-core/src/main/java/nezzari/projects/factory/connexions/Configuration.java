package nezzari.projects.factory.connexions;

public class Configuration {
	protected String nomDriver;
	protected String hote;
	protected String pseudo;
	protected String mdp;
	protected String bdd;
	
	public Configuration(String nomDriver, String hote) {
		this.nomDriver = nomDriver;
		this.hote = hote;
	}
	
	public Configuration(String nomDriver, String hote, String pseudo, String mdp, String bdd) {
		this.nomDriver = nomDriver;
		this.hote = hote;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.bdd = bdd;
	}
	
	public String getNomDriver() {
		return nomDriver;
	}
	
	public void setNomDriver(String nomDriver) {
		this.nomDriver = nomDriver;
	}
	
	public String getHote() {
		return hote;
	}
	
	public void setHote(String hote) {
		this.hote = hote;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public String getBdd() {
		return bdd;
	}
	
	public void setBdd(String bdd) {
		this.bdd = bdd;
	}

	
	
}
