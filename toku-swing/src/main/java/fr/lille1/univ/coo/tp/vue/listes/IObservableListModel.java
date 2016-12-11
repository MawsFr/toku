package fr.lille1.univ.coo.tp.vue.listes;

import javax.swing.DefaultListModel;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.filtre.Filtrable;
import fr.lille1.univ.coo.tp.filtre.Filtre;
import fr.lille1.univ.coo.tp.observateur.Observateur;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public class IObservableListModel<T extends IObjetDomaine<?>> extends DefaultListModel<T> implements Observateur<T>, Filtrable {

	private static final long serialVersionUID = 1L;
	private IObservableList<T> utilisateurs;

	public IObservableListModel(IObservableList<T> liste) {
		this.utilisateurs = liste;
		for(T element : liste.getListe()) {
			addElement(element);
		}
		liste.ajouterObservateur(this);
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

	@Override
	public void filtrer(Filtre filtre) throws DomainException {
		if(filtre == null) {
			for(T t : utilisateurs.getListe()) {
				if(!this.contains(t)) {
					this.addElement(t);
				}
			}
		} else {
			for(T t : utilisateurs.getListe()) {
				filtre.visit(t);
				if(filtre.getResultat().equals(true)) {
					if(!this.contains(t)) {
						this.addElement(t);
					}
				} else {
					if(this.contains(t)) {
						this.removeElement(t);
					}
				}
			}
		}
		
	}	
}