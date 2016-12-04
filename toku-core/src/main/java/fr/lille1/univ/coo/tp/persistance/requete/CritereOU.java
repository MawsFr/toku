package fr.lille1.univ.coo.tp.persistance.requete;

import java.util.ArrayList;
import java.util.List;

public class CritereOU extends Critere {
	private List<Critere > criteres;
	
	public CritereOU() {
		this.criteres = new ArrayList<>();
	}

	public CritereOU(List<Critere> criteres) {
		this.criteres = criteres;
	}
	
	public CritereOU ajouter(Critere critere) {
		this.criteres.add(critere);
		return this;
	}
	
	public CritereOU supprimer(Critere critere) {
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
	public String accept(RequeteVisitor requeteVisitor) {
		return requeteVisitor.visit(this);
	}
}
