package fr.lille1.univ.coo.tp.discussion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAPlusieurs;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.annotations.UnAPlusieurs;
import fr.lille1.univ.coo.tp.discussion.message.Message;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.filtre.Visiteur;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

/**
 * Cette classe represente un groupe
 * @author Mustapha NEZZARI
 *
 */
@Table
public class Discussion extends ObjetDomaine<Integer> implements IDiscussion {
	
	public static final int TYPE_GROUPE = 1;
	public static final int TYPE_PRIVE = 2;
	
	@Id
	protected Integer id;
	
	@Colonne
	protected String nom;
	
	@Colonne
	protected Integer leType;
	
	@PlusieursAUn(sonType = Utilisateur.class, saCle = "id_moderateur")
	protected IUtilisateur moderateur;
	
	@PlusieursAPlusieurs(table_assoc=AffectationDiscussion.class, leurCle="id_utilisateur", nosCle="id_discussion", type=AffectationDiscussion.class)
	protected IObservableList<AffectationDiscussion> affectations;
	
	@UnAPlusieurs(leurType=Message.class, maCle="id_discussion")
	protected IObservableList<Message> messages;
	
	public Discussion() {}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.discussion.IDiscussion#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.discussion.IDiscussion#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
		notifierModification("id");
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.discussion.IDiscussion#getNom()
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.discussion.IDiscussion#setNom(java.lang.String)
	 */
	@Override
	public void setNom(String nom) {
		this.nom = nom;
		notifierModification("nom");
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.discussion.IDiscussion#getModerateur()
	 */
	@Override
	public IUtilisateur getModerateur() {
		return moderateur;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.discussion.IDiscussion#setModerateur(java.lang.Integer)
	 */
	@Override
	public void setModerateur(IUtilisateur moderateur) {
		this.moderateur = moderateur;
		notifierModification("moderateur");
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.discussion.IDiscussion#getMembres()
	 */
	@Override
	public IObservableList<AffectationDiscussion> getAffectations() {
		return affectations;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.discussion.IDiscussion#setMembres(fr.lille1.univ.coo.tp.utilisateur.IObservableList)
	 */
	@Override
	public void setAffectations(IObservableList<AffectationDiscussion> membres) {
		this.affectations = membres;
//		notifierModification("affectations");
	}

	/**
	 * @return Le leType
	 */
	@Override
	public Integer getLeType() {
		return leType;
	}

	/**
	 * @param leType Le nouveau leType
	 */
	@Override
	public void setLeType(Integer leType) {
		this.leType = leType;
		notifierModification("leType");
	}

	/**
	 * @return Le messages
	 */
	@Override
	public IObservableList<Message> getMessages() {
		return messages;
	}

	/**
	 * @param messages Le nouveau messages
	 */
	@Override
	public void setMessages(IObservableList<Message> messages) {
		this.messages = messages;
//		notifierModification("messages");
	}

	@Override
	public List<IUtilisateur> getMembres() {
		List<IUtilisateur> membres = new ArrayList<>();
		for(AffectationDiscussion a : this.affectations.getListe()) {
			membres.add(a.getUtilisateur());
		}
		return membres;
	}
	
	@Override
	public void accept(Visiteur<?> visitor) throws DomainException {
		visitor.visit(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Discussion)) {
			return false;
		}
		Discussion other = (Discussion) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
	
	
}
