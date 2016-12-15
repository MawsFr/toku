package fr.lille1.univ.coo.tp.controlleurs.notifications;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.vue.accueil.PanneauAccueil;
import fr.lille1.univ.coo.tp.vue.notification.PopupNotification;

public class AfficherNotificationsAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private static PopupNotification notifs;
	
	
	public AfficherNotificationsAction() {
		putValue(NAME, PanneauAccueil.LBL_NOTIFICATIONS);	
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
		getNotifs();
		try {
			getNotifs().rafraichirAmitie();
			getNotifs().rafraichirAffectation();
			getNotifs().setVisible(true);
		} catch (DomainException e) {
			e.printStackTrace();
		}
	}

	public static PopupNotification getNotifs() {
		if(notifs == null) {
			notifs = new PopupNotification();
		}
		return notifs;
	}
}
