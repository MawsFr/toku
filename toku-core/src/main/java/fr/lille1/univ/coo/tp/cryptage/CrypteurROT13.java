package fr.lille1.univ.coo.tp.cryptage;

/**
 * Cette classe crypte en rot 13
 * @author Maws
 *
 */
public class CrypteurROT13 implements Crypteur {

	@Override
	public String crypter(String texte) throws CryptageException {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < texte.length(); i++) {
			char c = texte.charAt(i);
			if       (c >= 'a' && c <= 'm') c += 13;
			else if  (c >= 'A' && c <= 'M') c += 13;
			else if  (c >= 'n' && c <= 'z') c -= 13;
			else if  (c >= 'N' && c <= 'Z') c -= 13;
			sb.append(c);
		}
		return sb.toString();
	}

}
