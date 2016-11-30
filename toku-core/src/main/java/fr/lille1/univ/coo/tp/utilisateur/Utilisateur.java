package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAPlusieurs;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.annotations.Transient;
import fr.lille1.univ.coo.tp.annotations.UnAUn;
import fr.lille1.univ.coo.tp.connexions.LocalMysqlConfiguration;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;
import fr.lille1.univ.coo.tp.persistance.GestionnaireConnexion;
import fr.lille1.univ.coo.tp.role.Role;
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
public class Utilisateur extends ObjetDomaine implements IUtilisateur {
	@Id
	private Integer id;
	
	@PlusieursAUn("id_role")
	private Role role;
	
	@Colonne
	private String pseudo;
	
	@Colonne
	private String nom;
	
	@Colonne
	private String prenom;
	
	@Transient
	@Colonne("mot_de_passe")
	private String motDePasse;
	
	@Colonne
	private String avatar;
	
	//SELECT * FROM utilisateur join utilisateur_amis on utilisateur.id = utilisateur_amis.id_ami where utilisateur_amis.id_utilisateur = ?
//	@PlusieursAPlusieurs(table_assoc=)
	@PlusieursAPlusieurs(table_assoc="utilisateur_amis", notreCle="id_utilisateur", leurCle="id_ami", type=Utilisateur.class)
	private IObservableList<Utilisateur> amis;
	
	//select * from discussion join utilisateur_groupe on discussion.id = utilisateur_groupe.id_groupe where utilisateur_groupe.id_utilisateur = ?
	@PlusieursAPlusieurs(table_assoc="utilisateur_groupe", notreCle="id_utilisateur", leurCle="id_groupe", type=Discussion.class)
	private IObservableList<Discussion> discussions;
	
	@UnAUn(type=Humeur.class)
	private IHumeur humeur;
	
	public Utilisateur() {
	}
	
	public Utilisateur(Role role, String pseudo, String motDePasse, String nom, String prenom, String avatar) {
//		this.role = role;
		this.avatar = avatar;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getId()
	 */
	@Override
	public int getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setId(int)
	 */
	@Override
	public void setId(int id) {
		this.id = id;
		notifierModification("id");
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getAvatar()
	 */
	@Override
	public String getAvatar() {
		return avatar;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setAvatar(java.lang.String)
	 */
	@Override
	public void setAvatar(String avatar) {
		this.avatar = avatar;
		notifierModification("avatar");
	}

	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
		notifierModification("role");
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getPseudo()
	 */
	@Override
	public String getPseudo() {
		return pseudo;
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setPseudo(java.lang.String)
	 */
	@Override
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
		notifierModification("pseudo");
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getNom()
	 */
	@Override
	public String getNom() {
		return nom;
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setNom(java.lang.String)
	 */
	@Override
	public void setNom(String nom) {
		this.nom = nom;
		notifierModification("nom");
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getPrenom()
	 */
	@Override
	public String getPrenom() {
		return prenom;
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setPrenom(java.lang.String)
	 */
	@Override
	public void setPrenom(String prenom) {
		this.prenom = prenom;
		notifierModification("prenom");
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getMotDePasse()
	 */
	@Override
	public String getMotDePasse() {
		return motDePasse;
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setMotDePasse(java.lang.String)
	 */
	@Override
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
		notifierModification("motDePasse");
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getHumeur()
	 */
	@Override
	public IHumeur getHumeur() {
		return humeur;
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setHumeur(fr.lille1.univ.coo.tp.utilisateur.IHumeur)
	 */
	@Override
	public void setHumeur(IHumeur humeur) {
		this.humeur = humeur;
	}
	
	public IObservableList<Utilisateur> getAmis() {
		return amis;
	}

	public void setAmis(IObservableList<Utilisateur> amis) {
		this.amis = amis;
		notifierModification("amis");
	}
	
	

	/**
	 * @return Le discussions
	 */
	public IObservableList<Discussion> getDiscussions() {
		return discussions;
	}

	/**
	 * @param discussions Le nouveau discussions
	 */
	public void setDiscussions(IObservableList<Discussion> discussions) {
		this.discussions = discussions;
	}

	/**
	 * @param id Le nouveau id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#accept(fr.lille1.univ.coo.tp.visiteur.Visiteur)
	 */
	@Override
	public void accept(Visiteur visitor) throws DomainException {
		visitor.visit(this);
	}
	
	public static void main(String[] args) throws DAOException {
		LocalMysqlConfiguration c = new LocalMysqlConfiguration();
		c.setMdp("root");
		GestionnaireConnexion.ouvrirConnexion(c);
		Utilisateur u = new DAOGenerique<Utilisateur>(Utilisateur.class).rechercher(4);
		System.out.println(u);
		System.out.println(u.getDiscussions());
	}
	
}
