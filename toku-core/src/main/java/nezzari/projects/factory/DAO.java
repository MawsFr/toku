package nezzari.projects.factory;

import java.sql.Connection;
import java.sql.SQLException;


public abstract class DAO <T> {
	
	protected Connection connexion;
	
	protected DAO(Connection connexion) {
		this.connexion = connexion;
	}
	
	public abstract int creer(final T utilisateur) throws SQLException;
	public abstract void supprimer(final int idUtilisateur);
	public abstract void modifier(final T utilisateur);
	public abstract T rechercher(final int i);
	

}
