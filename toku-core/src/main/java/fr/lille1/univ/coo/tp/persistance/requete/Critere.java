package fr.lille1.univ.coo.tp.persistance.requete;

public abstract class Critere {
	public abstract String accept(RequeteVisitor requeteVisitor);
}
