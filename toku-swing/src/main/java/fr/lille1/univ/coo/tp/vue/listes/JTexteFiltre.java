package fr.lille1.univ.coo.tp.vue.listes;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.vue.composants.JTextFieldHint;

public class JTexteFiltre<T extends IObjetDomaine<?>> extends JTextFieldHint {
	private static final long serialVersionUID = 1L;
	private IObservableListModel<T> leModel;
	private JFiltrableList<T> liste;
	
	public JTexteFiltre(JObservableList<T> leModel) {
		this.leModel = leModel.getLeModel();
	}

	/**
	 * @return Le model
	 */
	public IObservableListModel<T> getLeModel() {
		return leModel;
	}

	/**
	 * @param model Le nouveau model
	 */
	public void setLeModel(IObservableListModel<T> model) {
		this.leModel = model;
	}

	/**
	 * @return Le liste
	 */
	public JFiltrableList<T> getListe() {
		return liste;
	}

	/**
	 * @param liste Le nouveau liste
	 */
	public void setListe(JFiltrableList<T> liste) {
		this.liste = liste;
	}
	
	
}
