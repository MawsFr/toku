package fr.lille1.univ.coo.tp.filtre;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.message.Message;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

/**
 * Cette represente un visiteur.
 * @author Mustapha Nezzari
 *
 */
public abstract class Visiteur<T> {
	protected T resultat;
	
	/**
	 * Visite un objet du domaine.
	 * @param objet L'objet a visiter.
	 * @throws DAOException Erreur lors de la visite.
	 */
	public void visit(IObjetDomaine<?> objet) throws DomainException {
		objet.accept(this);
	}
	
	/**
	 * Visite une personne.
	 * @param personne La personne a visiter.
	 * @throws DAOException Erreur lors de la visite.
	 */
	public abstract void visit(Utilisateur personne) throws DomainException;
	public abstract void visit(Discussion discussion) throws DomainException;
	public abstract void visit(Message message) throws DomainException;
	public abstract void visit(Role role) throws DomainException;
	public abstract void visit(Amitie amitie) throws DomainException;
	public abstract void visit(AffectationDiscussion affectation) throws DomainException;

	/**
	 * @return Le resultat
	 */
	public T getResultat() {
		return resultat;
	}

	/**
	 * @param resultat Le nouveau resultat
	 */
	public void setResultat(T resultat) {
		this.resultat = resultat;
	}
	
	
	
}
