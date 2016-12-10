package fr.lille1.univ.coo.tp.utilisateur;

import java.util.ArrayList;
import java.util.List;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.observateur.Observable;

public class ObservableList<T extends IObjetDomaine<?>> extends Observable implements IObservableList<T> {
	
	protected List<T> liste;
	
	public ObservableList() {
		this.liste = new ArrayList<>();
	}
	
	public ObservableList(List<T> liste) {
		this.liste = liste;
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur#ajouter(fr.lille1.univ.coo.tp.utilisateur.Utilisateur)
	 */
	@Override
	public void ajouter(T element) {
		this.liste.add(element);
		notifierCreation(element);
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur#supprimer(fr.lille1.univ.coo.tp.utilisateur.Utilisateur)
	 */
	@Override
	public void supprimer(T element) {
		this.liste.remove(element);
		notifierSuppression(element);
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur#getUtilisateurs()
	 */
	@Override
	public List<T> getListe() {
		return liste;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur#setUtilisateurs(java.util.List)
	 */
	@Override
	public void setListe(List<T> utilisateurs) {
		this.liste = utilisateurs;
	}

}
