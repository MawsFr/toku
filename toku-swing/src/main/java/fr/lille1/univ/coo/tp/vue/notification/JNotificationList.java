package fr.lille1.univ.coo.tp.vue.notification;

import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JFiltrableList;

public abstract class JNotificationList extends JFiltrableList<Amitie> {

	private static final long serialVersionUID = 1L;

	public JNotificationList() {
		super();
	}

	public JNotificationList(IObservableList<Amitie> amities ) {
		super(amities);
	}

	@Override
	public String getMessageVide() {
		return "Vous n'avez aucun amis, cliquez sur +Amis pour en ajouter !";
	}

}
