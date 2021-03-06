package fr.lille1.univ.coo.tp.persistance;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;


/**
 * Converti les types d'une BDD en type JAVAL.
 */
public class SQLTypeMap {
	/**
	 * Traduit un type SQL en type JAVA.
	 * 
	 * @param type
	 *            Le numero du type depuis la classe {@link Types}
	 * @return Le type JAVA correspondant.
	 */
	public static Class<?> toClass(int type) {
		Class<?> result = Object.class;

		switch (type) {
		case Types.CHAR:
		case Types.VARCHAR:
		case Types.LONGVARCHAR:
			result = String.class;
			break;

		case Types.NUMERIC:
		case Types.DECIMAL:
			result = java.math.BigDecimal.class;
			break;

		case Types.BIT:
			result = Boolean.class;
			break;

		case Types.TINYINT:
			result = Byte.class;
			break;

		case Types.SMALLINT:
			result = Short.class;
			break;

		case Types.INTEGER:
			result = Integer.class;
			break;

		case Types.BIGINT:
			result = Long.class;
			break;

		case Types.REAL:
		case Types.FLOAT:
			result = Float.class;
			break;

		case Types.DOUBLE:
			result = Double.class;
			break;

		case Types.BINARY:
		case Types.VARBINARY:
		case Types.LONGVARBINARY:
			result = Byte[].class;
			break;

		case Types.DATE:
			result = Date.class;
			break;

		case Types.TIME:
			result = Time.class;
			break;

		case Types.TIMESTAMP:
			result = Timestamp.class;
			break;
		}

		return result;
	}
	
	public static Object getIdValue(ResultSet id, Class<?> type) throws SQLException {
		if(Integer.class.equals(type)) {
			return id.getInt(1);
		} else if(String.class.equals(type)) {
			return id.getString(1);
		} else {
			return id.getObject(1);
		}
	}
	
	public static Object getIdValue(ResultSet resultat, String colonne, Class<?> type) throws SQLException {
		if(Integer.class.equals(type)) {
			return resultat.getInt(colonne);
		} else if(String.class.equals(type)) {
			return resultat.getString(colonne);
		} else {
			return resultat.getObject(colonne);
		}
	}
}