package fr.lille1.univ.coo.tp.persistance.proxy.factory;

import java.util.List;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;
import fr.lille1.univ.coo.tp.service.unitofwork.UnitOfWork;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.ObservableList;

public class UnAPlusieursFactory<T extends IObjetDomaine> implements Factory<IObservableList<T>>{
	
	private Class<?> sonType;
	private String maCle;
	private Object valeur;
	
	public UnAPlusieursFactory(Class<?> class1, String sonId, Object valeur) {
		this.maCle = sonId;
		this.sonType = class1;
		this.valeur = valeur;
	}
	
	@Override
	public IObservableList<T> creer() throws DAOException {
		DAOGenerique<T> dao = new DAOGenerique<>(sonType);
		try {
			List<T> liste = dao.rechercherParPropriete(maCle, valeur);
			ObservableList<T> o = new ObservableList<>(liste);
			o.ajouterObservateur(UnitOfWork.getInstance(sonType));
			return o;
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	
}
