package nezzari.projects.utilisateur;

import java.util.List;

import nezzari.projects.factory.DAOException;
import nezzari.projects.factory.IObjetDomaine;
import nezzari.projects.visiteur.Visiteur;

/**
 * Cette classe represente un utilisateur
 * @author Mustapha NEZZARI
 *
 */
/**
 * @author maws
 *
 */
public class Utilisateur extends IObjetDomaine {
	private int id;
	private int role;
	private String pseudo;
	private String nom;
	private String prenom;
	private String motDePasse;
	private String avatar;
	
	private ListeAmis amis;
	
	public Utilisateur() {
		this.amis = new ListeAmis(this);
	}
	
	public Utilisateur(int role, String pseudo, String motDePasse, String nom, String prenom, String avatar) {
		this();
		this.role = role;
		this.avatar = avatar;
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
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
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

	public ListeAmis getAmis() {
		return amis;
	}

	public void setAmis(ListeAmis amis) {
		this.amis = amis;
	}

	@Override
	public void accept(Visiteur visitor) throws DAOException {
		visitor.visit(this);
	}
	
	
}
