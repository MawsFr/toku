package nezzari.projects.factory;

import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.IdentityHashMap;

public abstract class DAO<T> {

	protected Connection connexion;
	protected IdentityHashMap<Integer, WeakReference<T>> references;

	protected DAO(Connection connexion) {
		this.connexion = connexion;
	}

	public abstract int creer(final T utilisateur) throws SQLException;

	public abstract void supprimer(final int idUtilisateur);

	public abstract void modifier(final T utilisateur);

	public abstract T rechercher(final int i);

	public static PreparedStatement creerRequetePreparee(Connection connexion, String sql, boolean returnGeneratedKeys,
			Object... objets) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(sql,
				returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		for (int i = 0; i < objets.length; i++) {
			ps.setObject(i + 1, objets[i]);
		}
		return ps;
	}

}
