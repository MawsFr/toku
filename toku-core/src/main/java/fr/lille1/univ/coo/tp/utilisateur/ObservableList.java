package fr.lille1.univ.coo.tp.utilisateur;

import java.util.ArrayList;
import java.util.List;

import fr.lille1.univ.coo.tp.observateur.Observable;

public class ObservableList<T> extends Observable implements IObservableList<T> {
	
	private List<T> utilisateurs;
	
	public ObservableList() {
		this.utilisateurs = new ArrayList<>();
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur#ajouter(fr.lille1.univ.coo.tp.utilisateur.Utilisateur)
	 */
	@Override
	public void ajouter(T utilisateur) {
		this.utilisateurs.add(utilisateur);
		notifierCreation(utilisateur);
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur#supprimer(fr.lille1.univ.coo.tp.utilisateur.Utilisateur)
	 */
	@Override
	public void supprimer(T utilisateur) {
		this.utilisateurs.remove(utilisateur);
		notifierSuppression(utilisateur);
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur#getUtilisateurs()
	 */
	@Override
	public List<T> getUtilisateurs() {
		return utilisateurs;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur#setUtilisateurs(java.util.List)
	 */
	@Override
	public void setUtilisateurs(List<T> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	
	
}
