package fr.lille1.univ.coo.tp.persistance;

import java.sql.PreparedStatement;
import java.util.List;

import fr.lille1.univ.coo.tp.utils.ReflectionUtils;

/**
 * Cette classe permet de créer les requête SQL pour les
 * {@link PreparedStatement} du DAO générique.
 */
public class RequeteBuilder {
	private Class<?> classe;
	private StringBuilder sb;
	private String table;

	/**
	 * Constructeur prenant en paramètre la classe associé à la table sur
	 * laquelle on va faire les requêtes.
	 * 
	 * @param classe
	 *            la classe associé à la table sur laquelle on va faire les
	 *            requêtes.
	 */
	public RequeteBuilder(Class<?> classe) {
		this.classe = classe;
		this.table = ReflectionUtils.nomTable(classe);
	}

	/**
	 * Crée une requête d'insertion dans la table
	 * 
	 * @param values
	 *            Les champs de la clause VALUES
	 * @return La requete INSERT
	 */
	public String insertion(List<String> values) {
		sb = new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(table);
		sb.append(" ( ");
		for (int i = 0; i < values.size(); ++i) {
			sb.append(values.get(i));
			if (i < values.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append(" ) VALUES ( ");
		for (int i = 0; i < values.size(); ++i) {
			sb.append("?");
			if (i < values.size() - 1) {
				sb.append(", ");
			}
		}

		sb.append(" )");

		return sb.toString();
	}

	/**
	 * Crée une requête d'update dans la table
	 * 
	 * @param proprietes
	 *            Les champs de la clause set
	 * @param where
	 *            Les champs de la clauses where
	 * @return La requete UPDATE correspondant au paramaetre.
	 */
	public String modification(List<String> proprietes, List<String> where) {
		sb = new StringBuilder();
		sb.append("UPDATE ");
		sb.append(table);
		sb.append(" SET ");
		for (int i = 0; i < proprietes.size(); ++i) {
			sb.append(proprietes.get(i)).append(" = ?");
			if (i < proprietes.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append(clauseWhere(where));

		return sb.toString();
	}

	/**
	 * Crée une requete de suppression dans la table.
	 * 
	 * @param where
	 *            Les champs de la clause where.
	 * @return La requete DELETE
	 */
	public String suppression(List<String> where) {
		sb = new StringBuilder();
		sb.append("DELETE FROM ").append(table).append(clauseWhere(where));

		return sb.toString();
	}

	/**
	 * Retourne la requete select correspondant au paramètre de la clause where.
	 * 
	 * @param where
	 *            Les champs de la clause where.
	 * @return La requete DELETE
	 */
	public String rechercherParPropriete(List<String> where) {
		sb = new StringBuilder();
		sb.append("SELECT * FROM ").append(table).append(clauseWhere(where));
		return sb.toString();
	}

	/**
	 * Retourne la requete select correspondant au paramètre de la clause where.
	 * 
	 * @param where
	 *            Les champs de la clause where.
	 * @param limit
	 *            La limite de ligne à afficher
	 * @return La requete DELETE
	 */
	public String rechercherParPropriete(List<String> where, Integer limit) {
		String select = rechercherParPropriete(where);
		sb = new StringBuilder();
		sb.append(select);
		if (limit > 0) {
			sb.append(clauseLimit(limit));
		}
		return sb.toString();
	}

	/**
	 * Créer la clause where d'une requetes à partir des champs donnés en
	 * parametres
	 * 
	 * @param where
	 *            Les champs de la requete clause.
	 * @return La clause WHARE d'une requete SQL
	 */
	public String clauseWhere(List<String> where) {
		if(where == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(" WHERE ");
		for (int i = 0; i < where.size(); ++i) {
			sb.append(where.get(i)).append(" = ?");
			if (i < where.size() - 1) {
				sb.append(" AND ");
			}
		}
		return sb.toString();
	}

	/**
	 * Créé une clause LIMIT
	 * 
	 * @param i
	 *            Le nombre de résultat à afficher
	 * @return La clause LIMIT
	 */
	public String clauseLimit(Integer i) {
		return new StringBuilder().append(" LIMIT ").append(String.valueOf(i)).toString();
	}

	/**
	 * Retourne la classe.
	 * 
	 * @return La classe associée à la table sur laquelle on veut faire les
	 *         requetes.
	 */
	public Class<?> getClasse() {
		return classe;
	}

	/**
	 * Met à jour la classe.
	 * 
	 * @param classe
	 *            La nouvelle classe.
	 */
	public void setClasse(Class<?> classe) {
		this.classe = classe;
	}

	/**
	 * Retourne le nom de la table sur laquelle on fait les requetes.
	 * 
	 * @return Le nom de la table sur laquelle on fait les requetes.
	 */
	public String getTable() {
		return table;
	}

	/**
	 * Met à jour le nom de la table sur laquelle on fait les requetes.
	 * 
	 * @param table
	 *            Le nouveau nom de la table sur laquelle on fait les requetes.
	 */
	public void setTable(String table) {
		this.table = table;
	}

}
