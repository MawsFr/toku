package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.ColonneVue;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.annotations.UnAUn;
import fr.lille1.univ.coo.tp.annotations.Vue;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.filtre.Visiteur;

@Vue("amitie_view")
@Table("amitie")
public class Amitie extends ObjetDomaine<String> {
	public static final int ETAT_EN_ATTENTE = 0;
	public static final int ETAT_VALIDEE = 1;
	public static final int ETAT_REFUSEE = 2;
	public static final int ETAT_TRAITEE = 3;
	
	@Id
	private String id;
	
	@PlusieursAUn(sonType=Utilisateur.class, saCle = "id_utilisateur")
	private IUtilisateur utilisateur;
	
	@PlusieursAUn(sonType=Utilisateur.class, saCle = "id_ami")
	private IUtilisateur ami;
	
	@ColonneVue
	@PlusieursAUn(saCle="demandeur", sonType=Utilisateur.class)
	private IUtilisateur demandeur;
	
	@Colonne
	private Integer etat;
	
	public IUtilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(IUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
		notifierModification("utilisateur");
	}

	public IUtilisateur getAmi() {
		return ami;
	}

	public void setAmi(IUtilisateur ami) {
		this.ami = ami;
		notifierModification("ami");
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
		notifierModification("etat");
	}

	/**
	 * @return Le id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @return Le demandeur
	 */
	public IUtilisateur getDemandeur() {
		return demandeur;
	}

	/**
	 * @param demandeur Le nouveau demandeur
	 */
	public void setDemandeur(IUtilisateur demandeur) {
		this.demandeur = demandeur;
		notifierModification("demandeur");
	}

	/**
	 * @param id Le nouveau id
	 */
	public void setId(String id) {
		this.id = id;
		notifierModification("id");
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
		result = prime * result + ((ami == null) ? 0 : ami.hashCode());
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
		if (!(obj instanceof Amitie)) {
			return false;
		}
		Amitie other = (Amitie) obj;
		if (ami == null) {
			if (other.getAmi() != null) {
				return false;
			}
		} else if (!ami.equals(other.getAmi())) {
			return false;
		}
		if (id == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!id.equals(other.getId())) {
			return false;
		}
		if (utilisateur == null) {
			if (other.getUtilisateur() != null) {
				return false;
			}
		} else if (!utilisateur.equals(other.getUtilisateur())) {
			return false;
		}
		return true;
	}

	
	
}
