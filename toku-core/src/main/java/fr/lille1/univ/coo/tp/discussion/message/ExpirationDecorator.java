package fr.lille1.univ.coo.tp.discussion.message;

public class ExpirationDecorator extends Message {
	protected Message message;
	
	public ExpirationDecorator(Message message, int expiration) {
		this.message = message;
		message.setExpiration(expiration);
	}
	
	@Override
	public Integer getExpiration() {
		return message.getExpiration();
	}
	
}
