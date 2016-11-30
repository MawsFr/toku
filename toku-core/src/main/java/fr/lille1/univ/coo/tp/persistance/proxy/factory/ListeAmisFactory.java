//package fr.lille1.univ.coo.tp.persistance.proxy.factory;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import fr.lille1.univ.coo.tp.persistance.proxy.VirtualProxyBuilder;
//import fr.lille1.univ.coo.tp.role.Role;
//import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
//import fr.lille1.univ.coo.tp.utilisateur.ObservableList;
//import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
//
///**
// * Cette classe couplé avec un {@link VirtualProxyBuilder} permet de récupérer
// * la liste des fils d'une {@link Personne} de façon paresseuse.
// */
//public class ListeAmisFactory implements Factory<IObservableList<Utilisateur>> {
//
//	private Integer pere;
//
//	/**
//	 * Constructeur prenant en parametre l'id du pere dont on veut les fils
//	 * @param id L'id du pere dont on veut les fils
//	 */
//	public ListeAmisFactory(Integer id) {
//		this.pere = id;
//	}
//
//	/**
//	 * Récupère la liste des fils d'un pere.
//	 * @return La liste des fils d'un pere
//	 */
//	@Override
//	public IObservableList<Utilisateur> creer() {
//		IObservableList<Utilisateur> fils = new ObservableList<Utilisateur>();
//		List<Utilisateur> utilisateurs = new ArrayList<>();
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "mmoiroux", "mdp", "Moiroux", "Maxime", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "jcatrix", "mdp", "Catrix", "Julien", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "cdelrue", "mdp", "Delrue", "Cédric", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "knew", "mdp", "Nezzari", "Khalil", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "aypub", "mdp", "Nez", "Ayoub", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "mmoiroux", "mdp", "Moiroux", "Maxime", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "jcatrix", "mdp", "Catrix", "Julien", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "cdelrue", "mdp", "Delrue", "Cédric", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "knew", "mdp", "Nezzari", "Khalil", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "aypub", "mdp", "Nez", "Ayoub", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "mmoiroux", "mdp", "Moiroux", "Maxime", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "jcatrix", "mdp", "Catrix", "Julien", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "cdelrue", "mdp", "Delrue", "Cédric", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "knew", "mdp", "Nezzari", "Khalil", null));
//		utilisateurs.add(new Utilisateur(new Role(1, "Utilisateur", null), "aypub", "mdp", "Nez", "Ayoub", null));
////		try {
////			utilisateurs = new DAOGenerique<Personne>(Personne.class).rechercherParPropriete("pere", pere);
////		} catch (DAOException e) {
////			e.printStackTrace();
////		}
//		
//		fils.setListe(utilisateurs);
//
//		return fils;
//	}
//
//}
