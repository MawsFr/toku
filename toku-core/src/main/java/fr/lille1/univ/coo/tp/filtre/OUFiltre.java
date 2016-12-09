package fr.lille1.univ.coo.tp.filtre;

import java.util.List;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.discussion.message.Message;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class OUFiltre extends Filtre {
	private List<Filtre > criteres;
	
	public OUFiltre(List<Filtre> criteres) {
		this.criteres = criteres;
	}

	public boolean accepte(IObjetDomaine obj) throws DomainException {
		setResultat(false);
		for(Filtre critere : criteres) {
			critere.visit(obj);
			if(critere.getResultat().equals(true)) {
				this.resultat = true;
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void visit(Utilisateur personne) throws DomainException {
		accepte(personne);
	}

	@Override
	public void visit(Discussion discussion) throws DomainException {
		accepte(discussion);
	}

	@Override
	public void visit(Message message) throws DomainException {
		accepte(message);
	}

	@Override
	public void visit(Role role) throws DomainException {
		accepte(role);
	}

	@Override
	public void visit(Amitie amitie) throws DomainException {
		accepte(amitie);		
	}

	@Override
	public void visit(AffectationDiscussion affectation) throws DomainException {
		accepte(affectation);		
	}

}
