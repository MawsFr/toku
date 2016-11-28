package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Proxy;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.visiteur.Visiteur;

/**
 * Cette classe represente un utilisateur
 * @author Mustapha NEZZARI
 *
 */
/**
 * @author maws
 *
 */
@Table
public class Utilisateur extends ObjetDomaine {
	@Id
	private Integer id;
	
	@Colonne("id_role")
	private Integer role;
	
	@Colonne
	private String pseudo;
	
	@Colonne
	private String nom;
	
	@Colonne
	private String prenom;
	
	@Colonne("mot_de_passe")
	private String motDePasse;
	
	@Colonne
	private String avatar;
	
	@Proxy
	@PlusieursAUn("id")
	private IListeUtilisateur amis;
	
	public Utilisateur() {
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

	public IListeUtilisateur getAmis() {
		return amis;
	}

	public void setAmis(IListeUtilisateur amis) {
		this.amis = amis;
	}

	@Override
	public void accept(Visiteur visitor) throws DomainException {
		visitor.visit(this);
	}
	
	
}
