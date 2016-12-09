package fr.lille1.univ.coo.tp.discussion.message;

public class AccuseReceptionDecorator extends Message {
	protected Message message;
	
	public AccuseReceptionDecorator(Message message) {
		this.message = message;
	}
	
	@Override
	public Boolean getAccuse_reception() {
		return true;
	}
	
}
