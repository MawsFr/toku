package fr.lille1.univ.coo.tp.vue.discussion;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.discussion.message.Message;
import fr.lille1.univ.coo.tp.vue.utilisateurs.ObservableListRenderer;

public class MessageListCellRenderer implements ObservableListRenderer<Message> {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<? extends Message> list, Message value, int index,
			boolean isSelected, boolean cellHasFocus) {
		JPanel messagePanel = new JPanel();
		messagePanel.setOpaque(true);
		if (isSelected) {
			messagePanel.setBackground(Color.decode("#64B5F6"));
			messagePanel.setForeground(Color.WHITE);
		} else {
			if(index % 2 == 0) {
				messagePanel.setBackground(Color.WHITE);
			} else {
				messagePanel.setBackground(Color.LIGHT_GRAY);
			}
			messagePanel.setForeground(Color.BLACK);
		}

		String message = value.getTexte();
		messagePanel.add(new JLabel(message));
		if(Application.getInstance().getSession().getUtilisateur().equals(value.getUtilisateur())) {
			messagePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		} else {
			messagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		}
		messagePanel.setFont(list.getFont());
		return messagePanel;
	}

}
