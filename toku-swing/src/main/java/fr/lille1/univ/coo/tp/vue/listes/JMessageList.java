package fr.lille1.univ.coo.tp.vue.listes;

import fr.lille1.univ.coo.tp.message.Message;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;

public class JMessageList extends JFiltrableList<Message> {

	private static final long serialVersionUID = 1L;

	public JMessageList(IObservableList<Message> iObservableList) {
		super(iObservableList);
//		try {
//			this.getLeModel().filtrer(new AExpire());
//		} catch (DomainException e) {
//			e.printStackTrace();
//		}
	}

}
