package fr.lille1.univ.coo.tp.filtre;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.discussion.message.Message;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class NONFiltre extends Filtre {
	private Filtre critere;
	
	public NONFiltre() {}
	
	public NONFiltre(Filtre critere) {
		this.critere = critere;
	}

	@Override
	public void visit(Utilisateur personne) throws DomainException {
		critere.visit(personne);
		setResultat(!critere.getResultat());
	}

	@Override
	public void visit(Discussion discussion) throws DomainException {
		critere.visit(discussion);
		setResultat(!critere.getResultat());
	}

	@Override
	public void visit(Message message) throws DomainException {
		critere.visit(message);
		setResultat(!critere.getResultat());
	}

	@Override
	public void visit(Role role) throws DomainException {
		critere.visit(role);
		setResultat(!critere.getResultat());
	}

	@Override
	public void visit(Amitie amitie) throws DomainException {
		critere.visit(amitie);
		setResultat(!critere.getResultat());
	}

	@Override
	public void visit(AffectationDiscussion affectation) throws DomainException {
		critere.visit(affectation);
		setResultat(!critere.getResultat());
	}

	/**
	 * @return Le criteres
	 */
	public Filtre getCritere() {
		return critere;
	}

	/**
	 * @param criteres Le nouveau criteres
	 */
	public void setCritere(Filtre critere) {
		this.critere = critere;
	}
	
	

}
