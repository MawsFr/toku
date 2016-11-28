package fr.lille1.univ.coo.tp.utilisateur;

import java.util.ArrayList;
import java.util.List;

import fr.lille1.univ.coo.tp.observateur.Observable;

public class ListeUtilisateurs extends Observable implements IListeUtilisateur {
	
	private List<Utilisateur> utilisateurs;
	
	public ListeUtilisateurs() {
		this.utilisateurs = new ArrayList<>();
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur#ajouter(fr.lille1.univ.coo.tp.utilisateur.Utilisateur)
	 */
	@Override
	public void ajouter(Utilisateur utilisateur) {
		this.utilisateurs.add(utilisateur);
		notifierCreation(utilisateur);
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur#supprimer(fr.lille1.univ.coo.tp.utilisateur.Utilisateur)
	 */
	@Override
	public void supprimer(Utilisateur utilisateur) {
		this.utilisateurs.remove(utilisateur);
		notifierSuppression(utilisateur);
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur#getUtilisateurs()
	 */
	@Override
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur#setUtilisateurs(java.util.List)
	 */
	@Override
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	
	
	
}
