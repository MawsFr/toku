package fr.lille1.univ.coo.tp.message;

public class PrioritaireDecorator extends Message {
	protected Message message;
	
	public PrioritaireDecorator(Message message) {
		this.message = message;
		message.setPrioritaire(true);
	}
	
	@Override
	public Boolean getPrioritaire() {
		return message.getPrioritaire();
	}
	
}
