package nezzari.projects.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public static final String RECHERCHER_UTILISATEUR = "SELECT * FROM UTILISATEUR WHERE id = ?";
	public static final String CREER_UTILISATEUR = "INSERT INTO UTILISATEUR  (id_role, pseudo, mot_de_passe, nom, prenom) VALUES (?, ?, ?, ?, ?)";
	public static final String MODIFIER_UTILISATEUR = "UPDATE UTILISATEUR SET id_role = ?, pseudo = ?, mot_de_passe = ?, nom = ?, prenom = ? where id = ?";
	public static final String SUPPRIMER_UTILISATEUR = "DELETE FROM UTILISATEUR WHERE id = ?";


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
		ResultSet resultat = null;
		int id = -1;
		try {
			ps = connexion.prepareStatement(CREER_UTILISATEUR, Statement.RETURN_GENERATED_KEYS);
			connexion.setAutoCommit(false);
			ps.setInt(1, utilisateur.getRole());
			ps.setString(2, utilisateur.getPseudo());
			ps.setString(3, utilisateur.getMotDePasse());
			ps.setString(4, utilisateur.getNom());
			ps.setString(5, utilisateur.getPrenom());
			ps.executeUpdate();
			connexion.commit();
			resultat = ps.getGeneratedKeys();
			resultat.next();
			id = resultat.getInt(1);
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
		return id;
	}

	@Override
	public void supprimer(int idUtilisateur) {
		PreparedStatement ps = null;
		try {
			ps = connexion.prepareStatement(SUPPRIMER_UTILISATEUR);
			connexion.setAutoCommit(false);
			ps.setInt(1, idUtilisateur);
			ps.executeUpdate();
			connexion.commit();
			Log.info("Utilisateur d'id  [" + idUtilisateur + "] supprimé");
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
	}

	@Override
	public void modifier(Utilisateur utilisateur) {
		PreparedStatement ps = null;
		try {
			ps = connexion.prepareStatement(MODIFIER_UTILISATEUR);
			connexion.setAutoCommit(false);
			ps.setInt(1, utilisateur.getRole());
			ps.setString(2, utilisateur.getPseudo());
			ps.setString(3, utilisateur.getMotDePasse());
			ps.setString(4, utilisateur.getNom());
			ps.setString(5, utilisateur.getPrenom());
			ps.setInt(6, utilisateur.getId());
			ps.executeUpdate();
			connexion.commit();
			Log.info("Utilisateur d'id  [" + utilisateur.getId() + "] modifié");
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
	}

	@Override
	public Utilisateur rechercher(int id) {
		PreparedStatement ps = null;
		ResultSet resultat = null;
		boolean trouve = false;
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(id);
		try {
			ps = connexion.prepareStatement(RECHERCHER_UTILISATEUR);
			ps.setInt(1, id);
			resultat = ps.executeQuery();
			trouve = resultat.next();
			if(trouve) {
				utilisateur.setRole(resultat.getInt(2));
				utilisateur.setPseudo(resultat.getString(3));
				utilisateur.setMotDePasse(resultat.getString(4));
				utilisateur.setNom(resultat.getString(5));
				utilisateur.setPrenom(resultat.getString(6));
			}
			Log.info(trouve ? "Utilisateur d'id  [" + utilisateur.getId() + "] trouvé" : "Aucun utilisateur trouvé");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultat != null) {
					resultat.close();
				}
				if(ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return trouve ? utilisateur : null;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MYSQLConnexion c = MYSQLConnexion.getInstance();
		c.initier();
		DAOFactory.setConnexion(c.getBddConnexion());
		Utilisateur utilisateur = new Utilisateur(1, "admin", "admin", "Administrateur","Root");
		DAOFactory.getUtilisateurDAO().creer(utilisateur);
		utilisateur.setPseudo("Maouss");
		DAOFactory.getUtilisateurDAO().modifier(utilisateur);
		Utilisateur trouve = DAOFactory.getUtilisateurDAO().rechercher(utilisateur.getId());
		Log.info("Id : " + trouve.getId());
		Log.info("Role : " + trouve.getRole());
		Log.info("Pseudo : " + trouve.getPseudo());
		Log.info("Mdp : " + trouve.getMotDePasse());
		Log.info("Nom : " + trouve.getNom());
		Log.info("Prenom : " + trouve.getPrenom());
		DAOFactory.getUtilisateurDAO().supprimer(utilisateur.getId());
		trouve = DAOFactory.getUtilisateurDAO().rechercher(utilisateur.getId());
		DAOFactory.fermerConnexion();
	}

}