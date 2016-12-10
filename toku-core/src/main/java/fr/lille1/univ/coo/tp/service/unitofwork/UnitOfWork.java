package fr.lille1.univ.coo.tp.service.unitofwork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.observateur.ObjetDomaineObservateur;
import fr.lille1.univ.coo.tp.persistance.DAOException;

/**
 * Cette classe represente une transaction. Elle garde en memoire la liste des
 * element a mettre a jour et possede une methode pour valider ces changements
 * definitevement dans la BDD.
 * 
 * @param <T>
 *            Le type de classe à manipuler.
 */
public class UnitOfWork implements ObjetDomaineObservateur {

	private static Map<Class<?>, UnitOfWork> instances;
	private Map<IObjetDomaine<?>, Set<String>> modifies;
	private Set<IObjetDomaine<?>> crees;
	private Set<IObjetDomaine<?>> supprimes;
	private Class<?> classe;

	/**
	 * Constructeur par defaut.
	 * @param classe 
	 */
	private UnitOfWork(Class<?> classe) {
		modifies = new HashMap<>();
		crees = new HashSet<>();
		supprimes = new HashSet<>();
		this.classe = classe;
	}

	public static UnitOfWork getInstance(Class<?> classe) {
		if(instances == null) {
			instances = new HashMap<>();
		}
		if (!instances.containsKey(classe)) {
			instances.put(classe, new UnitOfWork(classe));
		}

		return instances.get(classe);
	}

	/**
	 * Applique definitivement les changement sur les objet du domaine dans la
	 * BDD.
	 * 
	 * @throws DAOException
	 *             Erreur lors du commit.
	 */
	public void commit() throws DomainException {
		ModificationCommiter mc = new ModificationCommiter();
		for (Map.Entry<IObjetDomaine<?>, Set<String>> o : modifies.entrySet()) {
			mc.setParametres(o.getValue());
			mc.action(classe, o.getKey());
			mc.supprimerParametres();
		}
		modifies.clear();

		CreationCommiter cc = new CreationCommiter();
		for (IObjetDomaine<?> o : crees) {
			cc.action(classe, o);
		}
		crees.clear();

		SuppressionCommiter sc = new SuppressionCommiter();
		for (IObjetDomaine<?> o : supprimes) {
			sc.action(classe, o);
		}
		supprimes.clear();
	}

	public void annuler() {
		modifies.clear();
		crees.clear();
		supprimes.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.lille1.univ.coo.tp.observateur.Observateur#modification(java.lang.
	 * Object)
	 */
	@Override
	public void modification(IObjetDomaine<?> objet, String propriete) {
		if (!modifies.containsKey(objet)) {
			modifies.put(objet, new HashSet<>());
		}
		modifies.get(objet).add(propriete);
	}

	@Override
	public void creation(IObjetDomaine<?> objet) {
		crees.add(objet);
	}

	@Override
	public void suppression(IObjetDomaine<?> objet) {
		supprimes.add(objet);
	}

}
