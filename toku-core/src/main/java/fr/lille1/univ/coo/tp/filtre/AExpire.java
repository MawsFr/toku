package fr.lille1.univ.coo.tp.filtre;

import java.util.Date;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.discussion.message.Message;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class AExpire extends Filtre {
	
	public AExpire() {
	}
	
	@Override
	public void visit(Utilisateur personne) throws DomainException {
		
	}

	@Override
	public void visit(Discussion discussion) throws DomainException {
	}

	@Override
	public void visit(Message message) throws DomainException {
		setResultat(new Date(message.getDate_creation().getTime() + (86400 * message.getExpiration())).compareTo(new Date()) < 0);
	}

	@Override
	public void visit(Role role) throws DomainException {
	}

	@Override
	public void visit(Amitie amitie) throws DomainException {
	}

	@Override
	public void visit(AffectationDiscussion affectation) throws DomainException {
	}

}
