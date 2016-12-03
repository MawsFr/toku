package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;

@Table("amitie")
public class Amitie extends ObjetDomaine {
	public static final int ETAT_EN_ATTENTE = 0;
	public static final int ETAT_VALIDEE = 1;
	public static final int ETAT_REFUSEE = 2;
	public static final int ETAT_VOUS = 3;
	
	
	@PlusieursAUn(sonType=Utilisateur.class, saCle = "id_utilisateur")
	private Utilisateur utilisateur;
	
	@PlusieursAUn(sonType=Utilisateur.class, saCle = "id_ami")
	private Utilisateur ami;
	
	@Colonne
	private Integer etat;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Utilisateur getAmi() {
		return ami;
	}

	public void setAmi(Utilisateur ami) {
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

}
