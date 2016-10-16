package nezzari.projects.utilisateur;

public interface IUtilisateurDAO {

	public static final String RECHERCHER_UTILISATEUR = "SELECT * FROM UTILISATEUR WHERE id = ?";
	public static final String CONNECTER_UTILISATEUR = "SELECT * FROM UTILISATEUR WHERE pseudo = ? and mot_de_passe = ?";
	public static final String CREER_UTILISATEUR = "INSERT INTO UTILISATEUR  (id_role, pseudo, mot_de_passe, nom, prenom) VALUES (?, ?, ?, ?, ?)";
	public static final String MODIFIER_UTILISATEUR = "UPDATE UTILISATEUR SET id_role = ?, pseudo = ?, mot_de_passe = ?, nom = ?, prenom = ? where id = ?";
	public static final String SUPPRIMER_UTILISATEUR = "DELETE FROM UTILISATEUR WHERE id = ?";

	public int creer(Utilisateur utilisateur);

	public void supprimer(int idUtilisateur);

	public void modifier(Utilisateur utilisateur);

	public Utilisateur rechercher(int id);
	public Utilisateur rechercher(Utilisateur utilisateur) throws DAOException;

}