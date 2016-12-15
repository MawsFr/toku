package fr.lille1.univ.coo.tp.controlleurs.notifications;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.vue.notification.NotificationPanel;

public class SupprimerNotifAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	
	private NotificationPanel notification;
	public SupprimerNotifAction(NotificationPanel notification) {
		putValue(NAME, "x");
		this.notification = notification;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		notification.supprimer();
	}

}
