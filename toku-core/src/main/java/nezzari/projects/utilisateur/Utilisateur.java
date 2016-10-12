package nezzari.projects.utilisateur;

/**
 * Cette classe represente un utilisateur
 * @author Mustapha NEZZARI
 *
 */
public class Utilisateur {
	private int id;
	private int role;
	private String pseudo;
	private String nom;
	private String prenom;
	private String motDePasse;
	
	public Utilisateur() {}
	
	public Utilisateur(int role, String pseudo, String motDePasse, String nom, String prenom) {
		this.role = role;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRole() {
		return role;
	}
	
	public void setRole(int role) {
		this.role = role;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
}
