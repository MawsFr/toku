package fr.lille1.univ.coo.tp.cryptage;

public class CryptageException extends Exception {

	private static final long serialVersionUID = 1L;

	public CryptageException() {
		super();
	}

	public CryptageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CryptageException(String message, Throwable cause) {
		super(message, cause);
	}

	public CryptageException(String message) {
		super(message);
	}

	public CryptageException(Throwable cause) {
		super(cause);
	}
	

}
