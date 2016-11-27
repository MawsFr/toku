package fr.lille1.univ.coo.tp.domain;

import fr.lille1.univ.coo.tp.observateur.Observateur;
import fr.lille1.univ.coo.tp.visiteur.Visitable;

/**
 * Cette classe represente un objet du domaine.
 * 
 * @author Mustapha Nezzari
 *
 */
public interface IObjetDomaine extends Visitable {
	public void ajouter(Observateur<?> obs);
}
