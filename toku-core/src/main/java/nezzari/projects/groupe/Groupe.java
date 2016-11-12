package nezzari.projects.groupe;

import nezzari.projects.factory.DAOException;
import nezzari.projects.factory.IObjetDomaine;
import nezzari.projects.visiteur.Visiteur;

/**
 * Cette classe represente un groupe
 * @author Mustapha NEZZARI
 *
 */
public class Groupe extends IObjetDomaine {
	private int id;
	private int createur;
	private String nom;
	private int moderateur;
	
	public Groupe() {}
	
	public Groupe(int createur, String nom, int moderateur) {
		this.createur = createur;
		this.nom = nom;
		this.moderateur = moderateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreateur() {
		return createur;
	}

	public void setCreateur(int createur) {
		this.createur = createur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getModerateur() {
		return moderateur;
	}

	public void setModerateur(int moderateur) {
		this.moderateur = moderateur;
	}

	@Override
	public void accept(Visiteur visitor) throws DAOException {
		visitor.visit(this);
	}
}
