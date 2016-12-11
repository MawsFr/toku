package fr.lille1.univ.coo.tp.controlleurs.amitie;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.vue.notification.NotificationPanel;

public class AccepterAmiAction extends AbstractAction {

	private NotificationPanel notification;
	
	public AccepterAmiAction(NotificationPanel notification) {
		this.notification = notification;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Service.getUtilisateurService().accepterDemandeAmi(notification.getAmitie());
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
	}
}