package fr.lille1.univ.coo.tp.persistance;

/**
 * Cette exception peut etre levee lorsqu'il y a une erreur au niveau de la
 * couche persistance.
 * 
 * @author Mustapha Nezzari
 *
 */
public class DAOException extends Exception {
	private static final long serialVersionUID = 2891857646208654343L;

	public DAOException() {
		super();
	}

	public DAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

}
