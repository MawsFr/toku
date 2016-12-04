package fr.lille1.univ.coo.tp.filtre;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.discussion.message.Message;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class ALePseudo extends Filtre {
	
	private String pseudo;
	
	public ALePseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	@Override
	public void visit(Utilisateur personne) throws DomainException {
		setResultat(personne.getPseudo().contains(pseudo));
		
	}

	@Override
	public void visit(Discussion discussion) throws DomainException {
		setResultat(discussion.getNom().contains(pseudo));
	}

	@Override
	public void visit(Message message) throws DomainException {
		setResultat(message.getUtilisateur().getPseudo().contains(pseudo));
	}

	@Override
	public void visit(Role role) throws DomainException {
		setResultat(role.getNom().contains(pseudo));
	}

	@Override
	public void visit(Amitie amitie) throws DomainException {
		setResultat(amitie.getAmi().getPseudo().contains(pseudo));
	}

	@Override
	public void visit(AffectationDiscussion affectation) throws DomainException {
		setResultat(affectation.getUtilisateur().getPseudo().contains(pseudo));
	}

}
