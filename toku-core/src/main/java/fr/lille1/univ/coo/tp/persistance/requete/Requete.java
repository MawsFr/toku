package fr.lille1.univ.coo.tp.persistance.requete;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

/**
 * Cette classe permet de créer des requete
 *
 */
public abstract class Requete {
	protected Class<? extends IObjetDomaine<?>> classe;
	
	public Requete(Class<? extends IObjetDomaine<?>> classe) {
		this.classe = classe;
	}

	public static RequeteSelection selectionner(Class<? extends IObjetDomaine<?>> classe, String...fields) {
		return new RequeteSelection(classe, fields);
	}
	
	public static RequeteInsertion inserer(Class<? extends IObjetDomaine<?>> classe, String... fields) {
		return new RequeteInsertion(classe, fields);
	}
	
	public static RequeteMiseAJour mettreAJour(Class<? extends IObjetDomaine<?>> classe, String... fields) {
		return new RequeteMiseAJour(classe, fields);
	}
	
	public static RequeteSuppression supprimer(Class<? extends IObjetDomaine<?>> classe) {
		return new RequeteSuppression(classe);
	}
	
	public static void main(String[] args) {
		RequeteParser v = new RequeteParser();
		CritereEGALE nom = new CritereEGALE("nom");
		CritereEGALE prenom = new CritereEGALE("prenom");
		CritereEGALE pseudo = new CritereEGALE("pseudo");
		
		CritereET et = new CritereET();
		CritereOU ou = new CritereOU();
		ou.ajouter(nom).ajouter(prenom).ajouter(pseudo);
		et.ajouter(nom).ajouter(prenom).ajouter(ou).ajouter(pseudo);
//		System.out.println(Requete.selectionner(Utilisateur.class).joindre(Discussion.class, et).joindre(Amitie.class, et).where(et));
		System.out.println(v.visit(Requete.selectionner(Utilisateur.class).where(et)));
	}

	public abstract String accept(RequeteParser requeteVisitor);
	

}
