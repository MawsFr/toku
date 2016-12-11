package fr.lille1.univ.coo.tp.discussion;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.filtre.Visiteur;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

@Table(nom="utilisateur_discussion")
public class AffectationDiscussion extends ObjetDomaine<Integer> {
	public static final int ETAT_EN_ATTENTE = 0; // L'utilisateur n'a pas encore vu la discussion
	public static final int ETAT_VU = 1; // L'utilisateur a vu la discussion (et donc lu) la premiere fois : cet etat sers pour la notification
	public static final int ETAT_LU = 2; // 
	
	@Id
	private Integer id;
	
	@PlusieursAUn(sonType=Utilisateur.class, saCle = "id_utilisateur")
	private IUtilisateur utilisateur;
	
	@PlusieursAUn(sonType=Discussion.class, saCle = "id_discussion")
	private IDiscussion discussion;
	
	@Colonne
	private Integer etat;
	
	public IUtilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(IUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
		
	}

	public IDiscussion getDiscussion() {
		return discussion;
	}

	public void setDiscussion(IDiscussion discussion) {
		this.discussion = discussion;
		
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
	}

	@Override
	public Integer getId() {
		return this.id;
	}
	
	/**
	 * @param id Le nouveau id
	 */
	public void setId(Integer id) {
		this.id = id;
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
		result = prime * result + ((discussion == null) ? 0 : discussion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((utilisateur == null) ? 0 : utilisateur.hashCode());
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
		if (!(obj instanceof AffectationDiscussion)) {
			return false;
		}
		AffectationDiscussion other = (AffectationDiscussion) obj;
		if (discussion == null) {
			if (other.discussion != null) {
				return false;
			}
		} else if (!discussion.equals(other.discussion)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (utilisateur == null) {
			if (other.utilisateur != null) {
				return false;
			}
		} else if (!utilisateur.equals(other.utilisateur)) {
			return false;
		}
		return true;
	}

	
	
	

}
