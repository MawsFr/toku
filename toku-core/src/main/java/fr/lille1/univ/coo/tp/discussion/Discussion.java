package fr.lille1.univ.coo.tp.discussion;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAPlusieurs;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.annotations.UnAPlusieurs;
import fr.lille1.univ.coo.tp.annotations.UnAUn;
import fr.lille1.univ.coo.tp.discussion.message.Message;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.role.IRole;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.visiteur.Visiteur;

/**
 * Cette classe represente un groupe
 * @author Mustapha NEZZARI
 *
 */
@Table
public class Discussion extends ObjetDomaine implements IDiscussion {
	public static final int ETAT_EN_ATTENTE = 0; // L'utilisateur n'a pas encore vu la discussion
	public static final int ETAT_VU = 1; // L'utilisateur a vu la discussion (et donc lu) la premiere fois : cet etat sers pour la notification
	public static final int ETAT_LU = 2; // 
	
	@Id
	protected Integer id;
	
	@Colonne
	protected String nom;
	
	@Colonne("id_moderateur")
	protected Integer moderateur;
	
	@PlusieursAPlusieurs(table_assoc=AffectationDiscussion.class, leurCle="id_utilisateur", notreCle="id_discussion", type=AffectationDiscussion.class)
	protected IObservableList<AffectationDiscussion> membres;
	
	// select * from message where 
	@UnAPlusieurs(leurType=Message.class, maCle="id_discussion")
	protected IObservableList<Message> messages;
	
	public Discussion() {}
	
//	public Discussion(int createur, String nom, int moderateur) {
//		this.createur = createur;
//		this.nom = nom;
//		this.moderateur = moderateur;
//	}

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
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.discussion.IDiscussion#getModerateur()
	 */
	@Override
	public Integer getModerateur() {
		return moderateur;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.discussion.IDiscussion#setModerateur(java.lang.Integer)
	 */
	@Override
	public void setModerateur(Integer moderateur) {
		this.moderateur = moderateur;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.discussion.IDiscussion#getMembres()
	 */
	@Override
	public IObservableList<AffectationDiscussion> getMembres() {
		return membres;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.discussion.IDiscussion#setMembres(fr.lille1.univ.coo.tp.utilisateur.IObservableList)
	 */
	@Override
	public void setMembres(IObservableList<AffectationDiscussion> membres) {
		this.membres = membres;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.discussion.IDiscussion#accept(fr.lille1.univ.coo.tp.visiteur.Visiteur)
	 */
	@Override
	public void accept(Visiteur visitor) throws DomainException {
		visitor.visit(this);
	}
	
	
}
