/**
 * 
 */
package fr.lille1.univ.coo.tp.persistance.proxy.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.DAOGenerique;
import fr.lille1.univ.coo.tp.persistance.Jointure;
import fr.lille1.univ.coo.tp.service.unitofwork.UnitOfWork;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.ObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.utils.ReflectionUtils;

/**
 * @author Maws
 *
 */
public class PlusieursAPlusieursFactory<T extends IObjetDomaine> implements Factory<IObservableList<T>> {

	private String tableAssociation;
	private String leurColonne;
	private String notreColonne;
	private Class<?> leurType;
	private String leurId;
	private Object id;
	
	public PlusieursAPlusieursFactory(String tableAssociation, String leurColonne, String notreColonne,
			Class<?> leurType, String leurId, Object id) {
		this.tableAssociation = tableAssociation;
		this.leurColonne = leurColonne;
		this.notreColonne = notreColonne;
		this.leurType = leurType;
		this.leurId = leurId;
		this.id = id;
	}

	@Override
	public IObservableList<T> creer() throws DAOException {
		DAOGenerique<T> dao = new DAOGenerique<>(leurType);
		Map<String, Object> where = new HashMap<>();
		where.put(notreColonne, id);
		
		List<Jointure> jointures = new ArrayList<>();
		Jointure jointTableAssociee = new Jointure();
		
		jointTableAssociee.setLeurColonne(leurColonne);
		jointTableAssociee.setLeurId(leurId);
		jointTableAssociee.setLeurType(ReflectionUtils.nomTable(leurType));
		jointTableAssociee.setTableAssociation(tableAssociation);
		
		System.out.println(jointTableAssociee);
		
		jointures.add(jointTableAssociee);
		
		try {
			List<T> liste = dao.rechercherParJointure(jointures, where);
			ObservableList<T> o = new ObservableList<>(liste);
			o.ajouterObservateur(UnitOfWork.getInstance(leurType));
			return o;
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		}
		
	}

}
