package fr.lille1.univ.coo.tp.persistance.proxy.factory;

import java.util.List;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;
import fr.lille1.univ.coo.tp.service.unitofwork.UnitOfWork;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.ObservableList;

public class RechercherToutFactory<T extends IObjetDomaine<?>> implements Factory<IObservableList<T>>{
	
	private Class<?> sonType;
	
	public RechercherToutFactory(Class<?> sonType) {
		this.sonType = sonType;
	}
	
	@Override
	public IObservableList<T> creer() throws DAOException {
		DAOGenerique<T> dao = new DAOGenerique<>(sonType);
		try {
			List<T> liste = dao.rechercherTout();
			ObservableList<T> o = new ObservableList<T>(liste);
			o.ajouterObservateur(UnitOfWork.getInstance(sonType));
			return o;
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	
}
