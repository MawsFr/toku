package fr.lille1.univ.coo.tp.controlleurs.amitie;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.vue.notification.NotificationPanel;

public class RefuserAmiAction extends AbstractAction {

	private NotificationPanel notification;
	
	public RefuserAmiAction(NotificationPanel notification) {
		this.notification = notification;
		putValue(NAME, "Refuser");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Service.getUtilisateurService().refuserDemandeAmi(notification.getAmitie());
			notification.actualiser();
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
	}
}