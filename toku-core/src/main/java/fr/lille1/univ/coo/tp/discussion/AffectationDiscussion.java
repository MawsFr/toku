package fr.lille1.univ.coo.tp.discussion;

import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.TableAssociation;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.visiteur.Visiteur;

@TableAssociation("utilisateur_groupe")
public class AffectationDiscussion extends ObjetDomaine {
	
	@PlusieursAUn(sonType=Utilisateur.class, saCle = "id_utilisateur")
	private Utilisateur utilisateur;
	
	@PlusieursAUn(sonType=Discussion.class, saCle = "id_groupe")
	private Utilisateur ami;
	
	@Override
	public void accept(Visiteur visitor) throws DomainException {
		visitor.visit(this);
	}

}
