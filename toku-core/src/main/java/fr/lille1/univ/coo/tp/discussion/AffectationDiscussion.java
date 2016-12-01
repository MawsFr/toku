package fr.lille1.univ.coo.tp.discussion;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.visiteur.Visiteur;

@Table("utilisateur_discussion")
public class AffectationDiscussion extends ObjetDomaine {
	
	@PlusieursAUn(sonType=Utilisateur.class, saCle = "id_utilisateur")
	private Utilisateur utilisateur;
	
	@PlusieursAUn(sonType=Discussion.class, saCle = "id_discussion")
	private Discussion discussion;
	
	@Colonne
	private Integer etat;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Discussion getDiscussion() {
		return discussion;
	}

	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
	}

	@Override
	public void accept(Visiteur visitor) throws DomainException {
		visitor.visit(this);
	}

}
