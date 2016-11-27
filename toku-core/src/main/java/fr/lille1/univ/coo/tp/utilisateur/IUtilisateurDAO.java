//package fr.lille1.univ.coo.tp.utilisateur;
//
//import fr.lille1.univ.coo.tp.factory.DAOException;
//
//public interface IUtilisateurDAO {
//
//	public static final String RECHERCHER_UTILISATEUR = "SELECT * FROM UTILISATEUR WHERE id = ?";
//	public static final String RECHERCHER_AMIS = "SELECT u1.pseudo, u2.pseudo FROM utilisateur u1 JOIN utilisateur_amis a ON u1.id = a.id_utilisateur JOIN utilisateur u2 ON a.id_ami = u2.id WHERE u1.id = ?;";
//	public static final String CONNECTER_UTILISATEUR = "SELECT * FROM UTILISATEUR WHERE pseudo = ? and mot_de_passe = ?";
//	public static final String CREER_UTILISATEUR = "INSERT INTO UTILISATEUR  (id_role, pseudo, mot_de_passe, nom, prenom, avatar) VALUES (?, ?, ?, ?, ?, ?)";
//	public static final String MODIFIER_UTILISATEUR = "UPDATE UTILISATEUR SET id_role = ?, pseudo = ?, mot_de_passe = ?, nom = ?, prenom = ?, avatar = ? where id = ?";
//	public static final String SUPPRIMER_UTILISATEUR = "DELETE FROM UTILISATEUR WHERE id = ?";
//	public static final String ROLE_UTILISATEUR = "SELECT id_role FROM UTILISATEUR WHERE id = ?";
//
//	public int creer(Utilisateur utilisateur);
//
//	public void supprimer(int idUtilisateur);
//
//	public void modifier(Utilisateur utilisateur);
//
//	public Utilisateur rechercher(int id);
//	public Utilisateur rechercher(Utilisateur utilisateur) throws DAOException;
//
//	public int getRole(Utilisateur utilisateur) throws DAOException;
//
//}