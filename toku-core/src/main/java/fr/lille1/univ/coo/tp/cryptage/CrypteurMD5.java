package fr.lille1.univ.coo.tp.cryptage;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Cette classe crypte en MD5
 * @author Maws
 *
 */
public class CrypteurMD5 implements Crypteur {
	private MessageDigest md;

	public String crypter(String motDePasse) throws CryptageException {
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = motDePasse.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toString((digested[i] & 0xff) + 0x100, 16).substring(1));
			}
			System.out.println(sb.toString());
			return sb.toString();
		} catch (NoSuchAlgorithmException ex) {
			throw new CryptageException("Erreur lors du cryptage du mot de passe", ex);
		}

	}
}