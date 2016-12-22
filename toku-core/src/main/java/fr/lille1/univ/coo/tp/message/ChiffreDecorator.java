package fr.lille1.univ.coo.tp.message;

import fr.lille1.univ.coo.tp.cryptage.CryptageException;
import fr.lille1.univ.coo.tp.cryptage.CrypteurROT13;

public class ChiffreDecorator extends Message {
	protected Message message;
	
	public ChiffreDecorator(Message message) throws CryptageException {
		this.message = message;
		message.setChiffre(true);
		message.setTexte(new CrypteurROT13().crypter(message.getTexte()));
	}
	
	@Override
	public Boolean getChiffre() {
		return message.getChiffre();
	}
	
	@Override
	public String getTexte() {
		return message.getTexte();
	}
	
}
