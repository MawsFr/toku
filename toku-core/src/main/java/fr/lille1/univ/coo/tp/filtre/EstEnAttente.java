package fr.lille1.univ.coo.tp.filtre;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.message.Message;
import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class EstEnAttente extends Filtre {

	@Override
	public void visit(Utilisateur personne) throws DomainException {
		
	}

	@Override
	public void visit(Discussion discussion) throws DomainException {
		
	}

	@Override
	public void visit(Message message) throws DomainException {
		
	}

	@Override
	public void visit(Role role) throws DomainException {
		
	}

	@Override
	public void visit(Amitie amitie) throws DomainException {
		setResultat(amitie.getEtat().equals(Amitie.ETAT_EN_ATTENTE));
	}

	@Override
	public void visit(AffectationDiscussion affectation) throws DomainException {
		setResultat(affectation.getEtat().equals(AffectationDiscussion.ETAT_NOUVELLE_DISCUSSION) || affectation.getEtat().equals(AffectationDiscussion.ETAT_NOUVEAUX_MESSAGES) );
	}
	
	

}
