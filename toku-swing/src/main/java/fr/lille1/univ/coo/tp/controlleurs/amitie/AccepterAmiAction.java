package fr.lille1.univ.coo.tp.controlleurs.amitie;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.vue.notification.AmitieNotificationPanel;

public class AccepterAmiAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private AmitieNotificationPanel notification;
	
	public AccepterAmiAction(AmitieNotificationPanel notification) {
		this.notification = notification;
		putValue(NAME, "Accepter");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Service.getUtilisateurService().accepterDemandeAmi(notification.getAmitie());
			notification.actualiser();
//			FenetrePrincipale.getInstance().getPanneauPrincipal().getPanneauAccueil().getOngletAmis().getListeAmis().getLeModel().filtrer(null);
		} catch (ServiceException  e1) {
			e1.printStackTrace();
		}
	}
}