package fr.lille1.univ.coo.tp.notification;

import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public class GestionnaireNotification {
	private IObservableList<InvitationAmiNotification> amitie;
	private IObservableList<Notification> discussions;
	
	/**
	 * @return Le amitie
	 */
	public IObservableList<InvitationAmiNotification> getAmitie() {
		return amitie;
	}
	/**
	 * @param amitie Le nouveau amitie
	 */
	public void setAmitie(IObservableList<InvitationAmiNotification> amitie) {
		this.amitie = amitie;
	}
	/**
	 * @return Le discussions
	 */
	public IObservableList<Notification> getDiscussions() {
		return discussions;
	}
	/**
	 * @param discussions Le nouveau discussions
	 */
	public void setDiscussions(IObservableList<Notification> discussions) {
		this.discussions = discussions;
	}
	
}
