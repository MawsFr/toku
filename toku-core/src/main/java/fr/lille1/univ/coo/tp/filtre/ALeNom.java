package fr.lille1.univ.coo.tp.filtre;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.message.Message;
import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class ALeNom extends Filtre {
	
	private String nom;
	
	public ALeNom(String nom) {
		this.nom = nom;
	}
	
	@Override
	public void visit(Utilisateur personne) throws DomainException {
		setResultat(personne.getNom().contains(nom));
		
	}

	@Override
	public void visit(Discussion discussion) throws DomainException {
		setResultat(discussion.getNom().contains(nom));
	}

	@Override
	public void visit(Message message) throws DomainException {
		setResultat(message.getUtilisateur().getNom().contains(nom));
	}

	@Override
	public void visit(Role role) throws DomainException {
		setResultat(role.getNom().contains(nom));
	}

	@Override
	public void visit(Amitie amitie) throws DomainException {
		setResultat(amitie.getAmi().getNom().contains(nom));
	}

	@Override
	public void visit(AffectationDiscussion affectation) throws DomainException {
		setResultat(affectation.getUtilisateur().getNom().contains(nom));
	}

}
