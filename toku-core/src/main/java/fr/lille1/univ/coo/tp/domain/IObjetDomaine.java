package fr.lille1.univ.coo.tp.domain;

import fr.lille1.univ.coo.tp.filtre.Visitable;
import fr.lille1.univ.coo.tp.observateur.Observateur;

/**
 * Cette classe represente un objet du domaine.
 * 
 * @author Mustapha Nezzari
 *
 */
public interface IObjetDomaine extends Visitable {
	public Integer getId();
	public void ajouterObservateur(Observateur<?> obs);
}
