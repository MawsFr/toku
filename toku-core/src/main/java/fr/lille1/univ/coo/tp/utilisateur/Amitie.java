package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.filtre.Visiteur;

@Table("amitie")
public class Amitie extends ObjetDomaine {
	public static final int ETAT_EN_ATTENTE = 0;
	public static final int ETAT_VALIDEE = 1;
	public static final int ETAT_REFUSEE = 2;
	public static final int ETAT_VOUS = 3;
	
	@Id
	private Integer id;
	
	@PlusieursAUn(sonType=Utilisateur.class, saCle = "id_utilisateur")
	private IUtilisateur utilisateur;
	
	@PlusieursAUn(sonType=Utilisateur.class, saCle = "id_ami")
	private IUtilisateur ami;
	
	@Colonne
	private Integer etat;
	
	public IUtilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(IUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public IUtilisateur getAmi() {
		return ami;
	}

	public void setAmi(IUtilisateur ami) {
		this.ami = ami;
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void accept(Visiteur visitor) throws DomainException {
		visitor.visit(this);
	}

}
