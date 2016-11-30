package fr.lille1.univ.coo.tp.vue.gestion.utilisateurs;

import javax.swing.DefaultListModel;

import fr.lille1.univ.coo.tp.observateur.Observateur;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public class IObservableListModel<T> extends DefaultListModel<T> implements Observateur<T> {
	
	private static final long serialVersionUID = 1L;
//	private IObservableList<Utilisateur> utilisateurs;

	public IObservableListModel(IObservableList<T> listeUtilisateur) {
//		this.utilisateurs = ListeUtilisateur;
		for(T ami : listeUtilisateur.getListe()) {
			addElement(ami);
		}
		listeUtilisateur.ajouterObservateur(this);
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.observateur.Observateur#modification(java.lang.Object, java.lang.String)
	 */
	@Override
	public void modification(T objet, String propriete) {
		this.fireContentsChanged(this, 0, getSize());
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.observateur.Observateur#creation(java.lang.Object)
	 */
	@Override
	public void creation(T objet) {
		addElement(objet);
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.observateur.Observateur#suppression(java.lang.Object)
	 */
	@Override
	public void suppression(T objet) {
		removeElement(objet);
	}
}
