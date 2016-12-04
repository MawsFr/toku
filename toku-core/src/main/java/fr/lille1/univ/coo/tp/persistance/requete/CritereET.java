package fr.lille1.univ.coo.tp.persistance.requete;

import java.util.ArrayList;
import java.util.List;

public class CritereET extends Critere {
	private List<Critere > criteres;
	
	public CritereET() {
		this.criteres = new ArrayList<>();
	}
	
	public CritereET(List<Critere> criteres) {
		this.criteres = criteres;
	}
	
	public CritereET ajouter(Critere critere) {
		this.criteres.add(critere);
		return this;
	}
	
	public CritereET supprimer(Critere critere) {
		this.criteres.remove(critere);
		return this;
	}
	
	/**
	 * @return Le criteres
	 */
	public List<Critere> getCriteres() {
		return criteres;
	}

	/**
	 * @param criteres Le nouveau criteres
	 */
	public void setCriteres(List<Critere> criteres) {
		this.criteres = criteres;
	}

	@Override
	public String accept(RequeteParser requeteVisitor) {
		return requeteVisitor.visit(this);
	}
}
