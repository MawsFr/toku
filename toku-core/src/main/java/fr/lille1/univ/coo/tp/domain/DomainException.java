package fr.lille1.univ.coo.tp.domain;

/**
 * Cette classe représente une exception levée dans la couche domaine.
 */
public class DomainException extends Exception {

	private static final long serialVersionUID = 1L;

	public DomainException() {
	}

	public DomainException(String message) {
		super(message);
	}

	public DomainException(Throwable cause) {
		super(cause);
	}

	public DomainException(String message, Throwable cause) {
		super(message, cause);
	}

	public DomainException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
