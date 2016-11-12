package nezzari.projects.groupe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nezzari.projects.connexions.mysql.MYSQLConnexion;
import nezzari.projects.factory.DAO;
import nezzari.projects.factory.DAOException;
import nezzari.projects.factory.DAOFactory;
import nezzari.projects.utils.Log;

/**
 * Cette classe permet de faire des requetes sur la table des groupes.
 * Elle est basee sur le pattern singleton
 * @author Mustapha NEZZARI
 *
 */
public class GroupeDAO extends DAO<Groupe> {
	public static final String RECHERCHER_GROUPE = "SELECT * FROM GROUPE WHERE id = ?";
	public static final String CREER_GROUPE = "INSERT INTO GROUPE  (id_createur, nom, id_moderateur) VALUES (?, ?, ?)";
	public static final String MODIFIER_GROUPE = "UPDATE GROUPE SET id_createur = ?, nom = ?, id_moderateur = ? where id = ?";
	public static final String SUPPRIMER_GROUPE = "DELETE FROM GROUPE WHERE id = ?";


	private static GroupeDAO instance;

	private GroupeDAO(Connection connexion) {
		super(connexion);
	}

	public static GroupeDAO getInstance(Connection connexion) {
		if(instance == null) {
			instance = new GroupeDAO(connexion);
		}
		return instance;
	}

	@Override
	public int creer(Groupe groupe) {
		PreparedStatement ps = null;
		ResultSet resultat = null;
		int id = -1;
		try {
			ps = connexion.prepareStatement(CREER_GROUPE, Statement.RETURN_GENERATED_KEYS);
			connexion.setAutoCommit(false);
			ps.setInt(1, groupe.getCreateur());
			ps.setString(2, groupe.getNom());
			ps.setInt(3, groupe.getModerateur());
			ps.executeUpdate();
			connexion.commit();
			resultat = ps.getGeneratedKeys();
			resultat.next();
			id = resultat.getInt(1);
			groupe.setId(id);
			Log.info("Groupe d'id  [" + id + "] créé");
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
	public void supprimer(int idGroupe) {
		PreparedStatement ps = null;
		try {
			ps = connexion.prepareStatement(SUPPRIMER_GROUPE);
			connexion.setAutoCommit(false);
			ps.setInt(1, idGroupe);
			ps.executeUpdate();
			connexion.commit();
			Log.info("Groupe d'id  [" + idGroupe + "] supprimé");
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
	public void modifier(Groupe groupe) {
		PreparedStatement ps = null;
		try {
			ps = connexion.prepareStatement(MODIFIER_GROUPE);
			connexion.setAutoCommit(false);
			ps.setInt(1, groupe.getCreateur());
			ps.setString(2, groupe.getNom());
			ps.setInt(3, groupe.getModerateur());
			ps.setInt(4, groupe.getId());
			ps.executeUpdate();
			connexion.commit();
			Log.info("Groupe d'id  [" + groupe.getId() + "] modifié");
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
	public Groupe rechercher(int id) {
		PreparedStatement ps = null;
		ResultSet resultat = null;
		boolean trouve = false;
		Groupe groupe = new Groupe();
		groupe.setId(id);
		try {
			ps = connexion.prepareStatement(RECHERCHER_GROUPE);
			ps.setInt(1, id);
			resultat = ps.executeQuery();
			trouve = resultat.next();
			if(trouve) {
				groupe.setCreateur(resultat.getInt(2));
				groupe.setNom(resultat.getString(3));
				groupe.setModerateur(resultat.getInt(4));
			}
			Log.info(trouve ? "Groupe d'id  [" + groupe.getId() + "] trouvé" : "Aucun groupe trouvé");
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
		return trouve ? groupe : null;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, DAOException {
		MYSQLConnexion c = MYSQLConnexion.getInstance();
		c.initier();
		DAOFactory.setConnexion(c.getBddConnexion());
		Groupe groupe = new Groupe(25, "Groupe 1", 25);
		DAOFactory.getGroupeDAO().creer(groupe);
		groupe.setNom("Groupe 2");
		DAOFactory.getGroupeDAO().modifier(groupe);
		Groupe trouve = DAOFactory.getGroupeDAO().rechercher(groupe.getId());
		Log.info("Id : " + trouve.getId());
		Log.info("Id createur: " + trouve.getCreateur());
		Log.info("Nom : " + trouve.getNom());
		Log.info("Moderateur: " + trouve.getModerateur());
		DAOFactory.getUtilisateurDAO().supprimer(groupe.getId());
		trouve = DAOFactory.getGroupeDAO().rechercher(groupe.getId());
		DAOFactory.fermerConnexion();
	}

	public boolean estVide(int idGroupe) {
		return false;
	}

}
