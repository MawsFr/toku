package nezzari.projects.service.unitofwork;

import java.util.HashSet;
import java.util.Set;

import nezzari.projects.factory.DAOException;
import nezzari.projects.factory.IObjetDomaine;
import nezzari.projects.observateur.ObjetDomaineObservateur;
import nezzari.projects.visiteur.Visiteur;

/**
 * Cette classe represente une transaction. Elle garde en memoire la liste des
 * element a mettre a jour et possede une methode pour valider ces changements
 * definitevement dans la BDD.
 * 
 * @author Mustapha Nezzari
 *
 */
public class UnitOfWork implements ObjetDomaineObservateur {

	private static UnitOfWork instance;
	private Set<IObjetDomaine> modifies;
	private Set<IObjetDomaine> nouveaux;
	private Set<IObjetDomaine> supprimes;

	/**
	 * Constructeur par defaut.
	 */
	private UnitOfWork() {
		modifies = new HashSet<>();
		nouveaux = new HashSet<>();
		supprimes = new HashSet<>();
	}

	/**
	 * Retourne l'instance unique de cette transaction.
	 * @return L'instance unique de cette transaction.
	 */
	public static UnitOfWork getInstance() {
		if (instance == null) {
			instance = new UnitOfWork();
		}

		return instance;
	}

	/**
	 * Applique definitivement les changement sur les objet du domaine dans la BDD.
	 * @throws DAOException Erreur lors du commit.
	 */
	public void commit() throws DAOException {
		Visiteur v = new ModificationCommiter();
		for (IObjetDomaine o : modifies) {
			v.visit(o);
		}
		modifies.clear();

		v = new SuppressionCommiter();
		for (IObjetDomaine o : supprimes) {
			v.visit(o);
		}
		supprimes.clear();

		v = new CreationCommiter();
		for (IObjetDomaine o : nouveaux) {
			v.visit(o);
		}
		nouveaux.clear();
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.observateur.Observateur#modification(java.lang.Object)
	 */
	@Override
	public void modification(IObjetDomaine objet) {
		modifies.add(objet);
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.observateur.Observateur#creation(java.lang.Object)
	 */
	@Override
	public void creation(IObjetDomaine observable) {
		nouveaux.add(observable);
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.observateur.Observateur#suppression(java.lang.Object)
	 */
	@Override
	public void suppression(IObjetDomaine observable) {
		supprimes.add(observable);
	}

}
