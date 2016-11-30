package fr.lille1.univ.coo.tp.vue.gestion.utilisateurs;

import javax.swing.DefaultListModel;

import fr.lille1.univ.coo.tp.observateur.Observateur;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class UtilisateurListModel extends DefaultListModel<Utilisateur> implements Observateur<Utilisateur> {
	
	private static final long serialVersionUID = 1L;
//	private IObservableList<Utilisateur> utilisateurs;

	public UtilisateurListModel(IObservableList<Utilisateur> listeUtilisateur) {
//		this.utilisateurs = ListeUtilisateur;
		for(Utilisateur ami : listeUtilisateur.getListe()) {
			addElement(ami);
		}
		listeUtilisateur.ajouterObservateur(this);
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.observateur.Observateur#modification(java.lang.Object, java.lang.String)
	 */
	@Override
	public void modification(Utilisateur objet, String propriete) {
		this.fireContentsChanged(this, 0, getSize());
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.observateur.Observateur#creation(java.lang.Object)
	 */
	@Override
	public void creation(Utilisateur objet) {
		addElement(objet);
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.observateur.Observateur#suppression(java.lang.Object)
	 */
	@Override
	public void suppression(Utilisateur objet) {
		removeElement(objet);
	}
}
