package fr.lille1.univ.coo.tp.proxy.factory;

import java.util.HashMap;
import java.util.Map;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;

public class UnAUnFactory<T extends IObjetDomaine<?>> implements Factory<T> {

	private String sonId;
	private Class<?> type;
	private Object valeur;

	public UnAUnFactory(String colonne, Object valeur, Class<?> type) {
		this.sonId = colonne;
		this.valeur = valeur;
		this.type = type;
		
	}

	@Override
	public T creer() throws DAOException {
		DAOGenerique<T> dao = new DAOGenerique<>(type);
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
