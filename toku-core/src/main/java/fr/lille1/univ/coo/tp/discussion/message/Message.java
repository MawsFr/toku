package fr.lille1.univ.coo.tp.discussion.message;

import java.util.Date;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.cryptage.CryptageException;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.discussion.IDiscussion;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.filtre.Visiteur;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

@Table
public class Message extends ObjetDomaine<Integer> {
	@Id
	private Integer id;
	
	@PlusieursAUn(sonType=Discussion.class, saCle="id_discussion")
	private IDiscussion discussion;
	
	@PlusieursAUn(sonType=Utilisateur.class, saCle="id_utilisateur")
	private IUtilisateur utilisateur;
	
	@Colonne
	private String texte;
	
	@Colonne
	private Date date_creation;
	
	@Colonne
	private Boolean accuse_reception;
	
	@Colonne
	private Boolean lu; //TODO : a enlever
	
	@Colonne
	private Integer expiration;
	
	@Colonne
	private Boolean prioritaire;
	
	@Colonne
	private Boolean chiffre;

	/**
	 * @return Le id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return Le discussion
	 */
	public IDiscussion getDiscussion() {
		return discussion;
	}

	/**
	 * @return Le texte
	 */
	public String getTexte() {
		return texte;
	}

	/**
	 * @param texte Le nouveau texte
	 */
	public void setTexte(String texte) {
		this.texte = texte;
		notifierModification("texte");
	}
	
	/**
	 * @return Le utilisateur
	 */
	public IUtilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur Le nouveau utilisateur
	 */
	public void setUtilisateur(IUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
		notifierModification("utilisateur");
	}
	
	/**
	 * @return Le date_creation
	 */
	public Date getDate_creation() {
		return date_creation;
	}

	/**
	 * @param date_creation Le nouveau date_creation
	 */
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
		notifierModification("date_creation");
	}

	/**
	 * @return Le accuse_reception
	 */
	public Boolean getAccuse_reception() {
		return accuse_reception;
	}

	/**
	 * @param accuse_reception Le nouveau accuse_reception
	 */
	public void setAccuse_reception(Boolean accuse_reception) {
		this.accuse_reception = accuse_reception;
		notifierModification("accuse_reception");
	}

	/**
	 * @return Le lu
	 */
	public Boolean getLu() {
		return lu;
	}

	/**
	 * @param lu Le nouveau lu
	 */
	public void setLu(Boolean lu) {
		this.lu = lu;
		notifierModification("lu");
	}

	/**
	 * @return Le expiration
	 */
	public Integer getExpiration() {
		return expiration;
	}

	/**
	 * @param expiration Le nouveau expiration
	 */
	public void setExpiration(Integer expiration) {
		this.expiration = expiration;
		notifierModification("expiration");
	}

	/**
	 * @return Le prioritaire
	 */
	public Boolean getPrioritaire() {
		return prioritaire;
	}

	/**
	 * @param prioritaire Le nouveau prioritaire
	 */
	public void setPrioritaire(Boolean prioritaire) {
		this.prioritaire = prioritaire;
		notifierModification("prioritaire");
	}

	/**
	 * @return Le chiffre
	 */
	public Boolean getChiffre() {
		return chiffre;
	}

	/**
	 * @param chiffre Le nouveau chiffre
	 */
	public void setChiffre(Boolean chiffre) {
		this.chiffre = chiffre;
		notifierModification("chiffre");
	}
	
	

	/**
	 * @param id Le nouveau id
	 */
	public void setId(Integer id) {
		this.id = id;
		notifierModification("id");
	}

	/**
	 * @param discussion Le nouveau discussion
	 */
	public void setDiscussion(IDiscussion discussion) {
		this.discussion = discussion;
		notifierModification("discussion");
	}

	@Override
	public void accept(Visiteur<?> visitor) throws DomainException {
		visitor.visit(this);
	}
	
	// TODO : Enlever
	public static void main(String[] args) throws CryptageException {
		Message m = new Message();
		m.setExpiration(100);
		m.setTexte("bonjour");
		m = new ChiffreDecorator(m);
		System.out.println(m.getExpiration());
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
		if (!(obj instanceof Message)) {
			return false;
		}
		Message other = (Message) obj;
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
