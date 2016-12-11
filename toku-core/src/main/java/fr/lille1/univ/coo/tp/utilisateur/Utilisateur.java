package fr.lille1.univ.coo.tp.utilisateur;

import java.util.ArrayList;
import java.util.List;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAPlusieurs;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.annotations.Transient;
import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.IDiscussion;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.filtre.Visiteur;
import fr.lille1.univ.coo.tp.role.IRole;
import fr.lille1.univ.coo.tp.role.Role;

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
public class Utilisateur extends ObjetDomaine<Integer> implements IUtilisateur {
	@Id
	private Integer id;

	@PlusieursAUn(saCle = "id_role", sonType = Role.class)
	private IRole role;

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

	/*
	 * SELECT *
		FROM projet_utilisateur, projet_amitie
		WHERE
		
		CASE
		WHEN projet_amitie.id_utilisateur = '1'
		THEN projet_amitie.id_ami = projet_utilisateur.id
		WHEN projet_amitie.id_ami = '1'
		THEN projet_amitie.id_utilisateur = projet_utilisateur.id
		END
	 */
	//SELECT * FROM utilisateur join utilisateur_amis on utilisateur.id = utilisateur_amis.id_ami where utilisateur_amis.id_utilisateur = ?
	@PlusieursAPlusieurs(leurCle = "id_ami", table_assoc = Amitie.class, type = Amitie.class, nosCle="id_utilisateur")
	private IObservableList<Amitie> amitie;

	//select * from discussion join utilisateur_groupe on discussion.id = utilisateur_groupe.id_groupe where utilisateur_groupe.id_utilisateur = ?
	@PlusieursAPlusieurs(leurCle="id_discussion", nosCle="id_utilisateur", table_assoc=AffectationDiscussion.class, type=AffectationDiscussion.class)
	private IObservableList<AffectationDiscussion> affectations;

	public Utilisateur() {
	}

	public Utilisateur(Role role, String pseudo, String motDePasse, String nom, String prenom, String avatar) {
		this.role = role;
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
	public Integer getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setId(int)
	 */
	@Override
	public void setId(Integer id) {
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

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getRole()
	 */
	@Override
	public IRole getRole() {
		return role;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setRole(fr.lille1.univ.coo.tp.role.IRole)
	 */
	@Override
	public void setRole(IRole role) {
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
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getDiscussions()
	 */
	@Override
	public IObservableList<AffectationDiscussion> getAffectations() {
		return affectations;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setDiscussions(fr.lille1.univ.coo.tp.utilisateur.IObservableList)
	 */
	@Override
	public void setAffectations(IObservableList<AffectationDiscussion> discussions) {
		this.affectations = discussions;
	}
	
//	/* (non-Javadoc)
//	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#accept(fr.lille1.univ.coo.tp.visiteur.Visiteur)
//	 */
//	public static void main(String[] args) throws DAOException {
//		LocalMysqlConfiguration c = new LocalMysqlConfiguration();
//		c.setMdp("root");
//		GestionnaireConnexion.ouvrirConnexion(c);
//		IUtilisateur u = new DAOGenerique<Utilisateur>(Utilisateur.class).rechercher(4);
//		System.out.println(u);
//		System.out.println(u.getAffectations());
//	}

	/**
	 * @return Le amitie
	 */
	@Override
	public IObservableList<Amitie> getAmitie() {
		return amitie;
	}

	/**
	 * @param amitie Le nouveau amitie
	 */
	@Override
	public void setAmitie(IObservableList<Amitie> amitie) {
		this.amitie = amitie;
	}

	@Override
	public List<IDiscussion> getDiscussion() {
		List<IDiscussion> discussions = new ArrayList<>();
		for(AffectationDiscussion a : this.affectations.getListe()) {
			discussions.add(a.getDiscussion());
		}
		return discussions;
	}

	@Override
	public void accept(Visiteur<?> visitor) throws DomainException {
		visitor.visit(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Utilisateur)) {
			return false;
		}
		Utilisateur other = (Utilisateur) obj;
		if (id == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!id.equals(other.getId())) {
			return false;
		}
		return true;
	}
	
	

}
