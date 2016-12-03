package fr.lille1.univ.coo.tp.persistance;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.service.unitofwork.UnitOfWork;

/**
 * Cette classe permet d'implémenté l'identity map qui permet d'avoir qu'une
 * seul instance des objet venant de la base.
 */
public class References {
	private static References instance;
	private Map<Class<?>, Map<Integer, WeakReference<? extends IObjetDomaine>>> references;

	/**
	 * Constructeur par défaut
	 */
	private References() {
		this.references = new HashMap<>();
	}

	/**
	 * @return L'instance unique de cet classe.
	 */
	public static References getInstance() {
		if (instance == null) {
			instance = new References();
		}
		return instance;
	}

	/**
	 * Retourne la map des objet pour une classe données.
	 * 
	 * @param classe
	 *            La classe.
	 * @return L'identity map correspondant à la classe.
	 */
	public Map<Integer, WeakReference<? extends IObjetDomaine>> get(Class<?> classe) {
		init(classe);
		return this.references.get(classe);
	}

	/**
	 * Initialise une map pour une classe données.
	 * 
	 * @param classe
	 *            la classe dont on veut créer l'identity map.
	 */
	public void init(Class<?> classe) {
		if (this.references.get(classe) == null) {
			this.references.put(classe, new HashMap<>());
		}
	}

	/**
	 * Recherche un objet dans l'identity map d'une classe données.
	 * 
	 * @param classe
	 *            La classe.
	 * @param id
	 *            L'id de l'objet.
	 * @return L'objet associé à l'id et à la classe.
	 */
	public Object rechercher(Class<?> classe, Integer id) {
		if (get(classe).containsKey(id) && get(classe).get(id).get() != null) {
			return get(classe).get(id).get();
		}
		supprimer(classe, id);
		return null;
	}

	/**
	 * Enregistre un obejt dans l'identity map d'une classe données.
	 * 
	 * @param classe
	 *            La classe.
	 * @param id
	 *            L'id de l'objet.
	 * @param objet
	 *            L'objet à stocker.
	 * @return 
	 */
	public WeakReference<? extends IObjetDomaine> enregistrer(Class<?> classe, Integer id, IObjetDomaine objet) {
		WeakReference<? extends IObjetDomaine> reference = new WeakReference<IObjetDomaine>(objet);
		get(classe).put(id, reference);
		objet.ajouterObservateur(UnitOfWork.getInstance(classe));
		return reference;
	}
	
	public void supprimer(Class<?> classe, Integer id) {
		get(classe).remove(id);
	}

}
