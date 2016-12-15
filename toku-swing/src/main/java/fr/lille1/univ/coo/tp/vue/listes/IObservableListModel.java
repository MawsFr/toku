package fr.lille1.univ.coo.tp.vue.listes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.filtre.ETFiltre;
import fr.lille1.univ.coo.tp.filtre.Filtrable;
import fr.lille1.univ.coo.tp.filtre.Filtre;
import fr.lille1.univ.coo.tp.observateur.Observateur;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public class IObservableListModel<T extends IObjetDomaine<?>> extends DefaultListModel<T> implements Observateur<T>, Filtrable {

	private static final long serialVersionUID = 1L;
	private IObservableList<T> utilisateurs;
	private Filtre filtreDeBase;

	public IObservableListModel(IObservableList<T> liste) {
		this.utilisateurs = liste;
		for(T element : liste.getListe()) {
			addElement(element);
			element.ajouterObservateur(this);
		}
		liste.ajouterObservateur(this);
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.observateur.Observateur#modification(java.lang.Object, java.lang.String)
	 */
	@Override
	public void modification(T objet, String propriete) {
		this.fireContentsChanged(this, 0, getSize());
		try {
			filtrer(filtreDeBase);
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.observateur.Observateur#creation(java.lang.Object)
	 */
	@Override
	public void creation(T objet) {
		addElement(objet);
		try {
			filtrer(filtreDeBase);
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.observateur.Observateur#suppression(java.lang.Object)
	 */
	@Override
	public void suppression(T objet) {
		removeElement(objet);
		try {
			filtrer(filtreDeBase);
		} catch (DomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void filtrer(Filtre filtre) throws DomainException {
		if(filtre == null && filtreDeBase == null) {
			for(T t : utilisateurs.getListe()) {
				if(!this.contains(t)) {
					this.addElement(t);
				}
			}
		} 
		if (filtreDeBase != null || filtre != null) {
			for(T t : utilisateurs.getListe()) {
				List<Filtre> filtres = new ArrayList<>();
				if(filtreDeBase != null) {
					filtres.add(filtreDeBase);
				}
				if(filtre != null) {
					filtres.add(filtre);
				}
				ETFiltre et = new ETFiltre(filtres);
				filtre = et;
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

	/**
	 * @return Le utilisateurs
	 */
	public IObservableList<T> getUtilisateurs() {
		return utilisateurs;
	}

	/**
	 * @param utilisateurs Le nouveau utilisateurs
	 */
	public void setUtilisateurs(IObservableList<T> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	/**
	 * @return Le filtreDeBase
	 */
	public Filtre getFiltreDeBase() {
		return filtreDeBase;
	}

	/**
	 * @param filtreDeBase Le nouveau filtreDeBase
	 */
	public void setFiltreDeBase(Filtre filtreDeBase) {
		this.filtreDeBase = filtreDeBase;
	}	
	
	
}
