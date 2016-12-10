package fr.lille1.univ.coo.tp.persistance.proxy.factory;

import java.util.HashMap;
import java.util.Map;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;

public class PlusieursAUnFactory<T extends IObjetDomaine<?>> implements Factory<T>{
	
	private Class<?> sonType;
	private String sonId;
	private Object valeur;
	
	public PlusieursAUnFactory(Class<?> class1, String sonId, Object valeur) {
		this.sonId = sonId;
		this.sonType = class1;
		this.valeur = valeur;
	}
	
	@Override
	public T creer() throws DAOException {
		DAOGenerique<T> dao = new DAOGenerique<>(sonType);
		Map<String, Object> where = new HashMap<>();
		where.put(sonId, valeur);
		try {
			return dao.rechercherUnSeulParProprietes(where);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	
}
