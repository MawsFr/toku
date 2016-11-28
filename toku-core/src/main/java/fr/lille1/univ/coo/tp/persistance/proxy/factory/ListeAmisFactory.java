package fr.lille1.univ.coo.tp.persistance.proxy.factory;

import java.util.ArrayList;
import java.util.List;

import fr.lille1.univ.coo.tp.persistance.proxy.VirtualProxyBuilder;
import fr.lille1.univ.coo.tp.utilisateur.IListeUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.ListeUtilisateurs;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

/**
 * Cette classe couplé avec un {@link VirtualProxyBuilder} permet de récupérer
 * la liste des fils d'une {@link Personne} de façon paresseuse.
 */
public class ListeAmisFactory implements Factory<IListeUtilisateur> {

	private Integer pere;

	/**
	 * Constructeur prenant en parametre l'id du pere dont on veut les fils
	 * @param id L'id du pere dont on veut les fils
	 */
	public ListeAmisFactory(Integer id) {
		this.pere = id;
	}

	/**
	 * Récupère la liste des fils d'un pere.
	 * @return La liste des fils d'un pere
	 */
	@Override
	public IListeUtilisateur creer() {
		IListeUtilisateur fils = new ListeUtilisateurs();
		List<Utilisateur> utilisateurs = new ArrayList<>();
//		try {
//			utilisateurs = new DAOGenerique<Personne>(Personne.class).rechercherParPropriete("pere", pere);
//		} catch (DAOException e) {
//			e.printStackTrace();
//		}
		
		fils.setUtilisateurs(utilisateurs);

		return fils;
	}

}
