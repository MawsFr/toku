package fr.lille1.univ.coo.tp.vue.utilisateurs;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public abstract class JFiltrableList<T extends IObjetDomaine<?>> extends JObservableList<T> {
	private static final long serialVersionUID = 1L;
	private JTexteFiltre<T> texte;

	public JFiltrableList() {
		super();
	}
	
	public JFiltrableList(IObservableList<T> utilisateurs) {
		super(utilisateurs);
	}
	
	@Override
	public void setListe(IObservableList<T> liste) {
		super.setListe(liste);
		this.texte = new JTexteFiltre<T>(this.leModel);
	}

	/**
	 * @return Le texte
	 */
	public JTexteFiltre<T> getTexte() {
		return texte;
	}

	/**
	 * @param texte Le nouveau texte
	 */
	public void setTexte(JTexteFiltre<T> texte) {
		this.texte = texte;
	}

}
