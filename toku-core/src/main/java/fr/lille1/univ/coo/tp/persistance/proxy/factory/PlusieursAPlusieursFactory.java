/**
 * 
 */
package fr.lille1.univ.coo.tp.persistance.proxy.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;
import fr.lille1.univ.coo.tp.service.unitofwork.UnitOfWork;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.ObservableList;

/**
 * @author Maws
 *
 */
public class PlusieursAPlusieursFactory<T extends IObjetDomaine> implements Factory<IObservableList<T>> {

	private Class<?> tableAssociation;
	private String notreColonne;
	private Class<?> leurType;
	private Object id;
	
	public PlusieursAPlusieursFactory(Class<?> tableAssociation, String notreColonne,
			Class<?> leurType, Object id) {
		this.tableAssociation = tableAssociation;
		this.notreColonne = notreColonne;
		this.leurType = leurType;
		this.id = id;
	}

	@Override
	public IObservableList<T> creer() throws DAOException {
		DAOGenerique<T> dao = new DAOGenerique<>(tableAssociation);
		Map<String, Object> where = new HashMap<>();
		where.put(notreColonne, id);
		
//		List<Jointure> jointures = new ArrayList<>();
//		Jointure jointTableAssociee = new Jointure();
//		
//		jointTableAssociee.setLeurColonne(leurColonne);
//		jointTableAssociee.setLeurId(leurId);
//		jointTableAssociee.setLeurType(ReflectionUtils.nomTable(leurType));
//		jointTableAssociee.setTableAssociation(ReflectionUtils.nomTable(tableAssociation));
//		
//		System.out.println(jointTableAssociee);
//		
//		jointures.add(jointTableAssociee);
		
		try {
			List<T> liste = dao.rechercherParPropriete(notreColonne, id);
			ObservableList<T> o = new ObservableList<T>(liste);
			o.ajouterObservateur(UnitOfWork.getInstance(leurType));
			return o;
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		}
		
	}

}
