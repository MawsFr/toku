package fr.lille1.univ.coo.tp.vue.discussion;

import javax.swing.ListCellRenderer;

import fr.lille1.univ.coo.tp.discussion.message.Message;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableList;

public class JMessageList extends JObservableList<Message> {

	private static final long serialVersionUID = 1L;

	public JMessageList() {
		super();
	}

	public JMessageList(IObservableList<Message> iObservableList) {
		super(iObservableList);
	}

	@Override
	public ListCellRenderer<? super Message> getCellRenderer() {
		return new MessageListCellRenderer();
	}

	@Override
	public String getMessageVide() {
		// TODO Auto-generated method stub
		return "Aucun message dans cette discussion";
	}

}
