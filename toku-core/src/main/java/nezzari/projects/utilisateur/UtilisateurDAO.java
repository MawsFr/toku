	package nezzari.projects.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nezzari.projects.connexions.mysql.MYSQLConnexion;
import nezzari.projects.factory.DAO;
import nezzari.projects.factory.DAOFactory;
import nezzari.projects.utils.Log;

/**
 * Cette classe permet de faire des requetes sur la table des utilisateurs.
 * Elle est basee sur le pattern singleton
 * @author Mustapha NEZZARI
 *
 */
public class UtilisateurDAO extends DAO<Utilisateur> implements IUtilisateurDAO {
	private static IUtilisateurDAO instance;

	private UtilisateurDAO(Connection connexion) {
		super(connexion);
	}

	public static IUtilisateurDAO getInstance(Connection connexion) {
		if(instance == null) {
			instance = new UtilisateurDAO(connexion);
		}
		return instance;
	}

	/* (non-Javadoc)
	 * @see nezzari.projects.utilisateur.IUtilisateurDAO#creer(nezzari.projects.utilisateur.Utilisateur)
	 */
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

	/* (non-Javadoc)
	 * @see nezzari.projects.utilisateur.IUtilisateurDAO#supprimer(int)
	 */
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

	/* (non-Javadoc)
	 * @see nezzari.projects.utilisateur.IUtilisateurDAO#modifier(nezzari.projects.utilisateur.Utilisateur)
	 */
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

	/* (non-Javadoc)
	 * @see nezzari.projects.utilisateur.IUtilisateurDAO#rechercher(int)
	 */
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

	@Override
	public Utilisateur rechercher(Utilisateur utilisateur) throws DAOException {
		PreparedStatement ps = null;
		ResultSet resultat = null;
		boolean trouve = false;
		try {
			ps = connexion.prepareStatement(CONNECTER_UTILISATEUR);
			ps.setString(1, utilisateur.getPseudo());
			ps.setString(2, utilisateur.getMotDePasse());
			resultat = ps.executeQuery();
			trouve = resultat.next();
			if(trouve) {
				utilisateur.setId(resultat.getInt(1));
				utilisateur.setRole(resultat.getInt(2));
				utilisateur.setNom(resultat.getString(5));
				utilisateur.setPrenom(resultat.getString(6));
			} else {
				throw new DAOException("Aucun utilisateur trouvé avec ces informations");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
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
		return utilisateur;
	}
	
	@Override
	public int getRole(Utilisateur utilisateur) throws DAOException {
		PreparedStatement ps = null;
		ResultSet resultat = null;
		boolean trouve = false;
		int role = -1;
		try {
			ps = connexion.prepareStatement(ROLE_UTILISATEUR);
			ps.setInt(1, utilisateur.getId());
			resultat = ps.executeQuery();
			trouve = resultat.next();
			if(trouve) {
				role = resultat.getInt(1);
				utilisateur.setRole(role); //Peut etre a enlever
			} else {
				throw new DAOException("Aucun utilisateur trouvé avec ces informations");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
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
		return role;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MYSQLConnexion c = MYSQLConnexion.getInstance();
		c.initier();
		DAOFactory.setConnexion(c.getBddConnexion());
		Utilisateur utilisateur = new Utilisateur(3, "admin", "admin", "Administrateur","Root");
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
