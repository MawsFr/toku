package fr.lille1.univ.coo.tp.discussion;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.visiteur.Visiteur;

/**
 * Cette classe represente un groupe
 * @author Mustapha NEZZARI
 *
 */
public class Discussion extends ObjetDomaine {
	private Integer id;
	private Integer createur;
	private String nom;
	private Integer moderateur;
	private IObservableList<Utilisateur> membres;
	
	public Discussion() {}
	
//	public Discussion(int createur, String nom, int moderateur) {
//		this.createur = createur;
//		this.nom = nom;
//		this.moderateur = moderateur;
//	}

	/**
	 * @return Le id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id Le nouveau id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return Le createur
	 */
	public Integer getCreateur() {
		return createur;
	}

	/**
	 * @param createur Le nouveau createur
	 */
	public void setCreateur(Integer createur) {
		this.createur = createur;
	}

	/**
	 * @return Le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom Le nouveau nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return Le moderateur
	 */
	public Integer getModerateur() {
		return moderateur;
	}

	/**
	 * @param moderateur Le nouveau moderateur
	 */
	public void setModerateur(Integer moderateur) {
		this.moderateur = moderateur;
	}

	/**
	 * @return Le membres
	 */
	public IObservableList<Utilisateur> getMembres() {
		return membres;
	}

	/**
	 * @param membres Le nouveau membres
	 */
	public void setMembres(IObservableList<Utilisateur> membres) {
		this.membres = membres;
	}

	@Override
	public void accept(Visiteur visitor) throws DomainException {
		visitor.visit(this);
	}
}
