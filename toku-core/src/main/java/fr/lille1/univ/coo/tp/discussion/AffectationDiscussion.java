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

@Table("utilisateur_discussion")
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
		return utilisateur.getId();
	}
	
	/**
	 * @param id Le nouveau id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public void accept(Visiteur visitor) throws DomainException {
		visitor.visit(this);
	}

}
