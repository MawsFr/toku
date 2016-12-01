package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.TableAssociation;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.visiteur.Visiteur;

@TableAssociation("utilisateur_amis")
public class Amitie extends ObjetDomaine {
	
	@PlusieursAUn(sonType=Utilisateur.class, saCle = "id_utilisateur")
	private Utilisateur utilisateur;
	
	@PlusieursAUn(sonType=Utilisateur.class, saCle = "id_ami")
	private Utilisateur ami;
	
	@Override
	public void accept(Visiteur visitor) throws DomainException {
		visitor.visit(this);
	}

}
