package nezzari.projects.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import nezzari.projects.factory.DAO;
import nezzari.projects.factory.DAOFactory;
import nezzari.projects.factory.connexions.mysql.MYSQLConnexion;
import nezzari.projects.utils.Log;

/**
 * Cette classe permet de faire des requetes sur la table des utilisateurs.
 * Elle est basee sur le pattern singleton
 * @author Mustapha NEZZARI
 *
 */
public class UtilisateurDAO extends DAO<Utilisateur> {
	public static final String CREER_UTILISATEUR = "INSERT INTO UTILISATEUR  (id_role, pseudo, mot_de_passe, nom, prenom) VALUES (?, ?, ?, ?, ?)";

	private static UtilisateurDAO instance;

	private UtilisateurDAO(Connection connexion) {
		super(connexion);
	}

	public static UtilisateurDAO getInstance(Connection connexion) {
		if(instance == null) {
			instance = new UtilisateurDAO(connexion);
		}
		return instance;
	}

	@Override
	public int creer(Utilisateur utilisateur) {
		PreparedStatement ps = null;
		try {
			ps = connexion.prepareStatement(CREER_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);
			connexion.setAutoCommit(false);
			ps.setInt(1, utilisateur.getRole());
			ps.setString(2, utilisateur.getNom());
			ps.setString(3, utilisateur.getPrenom());
			ps.setString(4, utilisateur.getPseudo());
			ps.setString(5, utilisateur.getMotDePasse());
			int id = ps.executeUpdate();
			utilisateur.setId(id);
			Log.info("Utilisateur d'id  [" + id + "] créé");
		} catch (SQLException e) {
			try {
				connexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				connexion.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public void supprimer(int idUtilisateur) {

	}

	@Override
	public void modifier(Utilisateur utilisateur) {

	}

	@Override
	public Utilisateur rechercher(int i) {
		return null;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MYSQLConnexion c = MYSQLConnexion.getInstance();
		c.initier();
		DAOFactory.setConnexion(c.getBddConnexion());
		DAOFactory.getUtilisateurDAO().creer(new Utilisateur(1, "maws", "Nezzari","Mustapha", "songoku"));
		DAOFactory.fermerConnexion();
	}

}
