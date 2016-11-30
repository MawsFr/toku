package fr.lille1.univ.coo.tp.vue.discussion;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.discussion.message.Message;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.gestion.utilisateurs.ObservableListRenderer;

public class MessageListCellRenderer extends JLabel implements ObservableListRenderer<Message> {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<? extends Message> list, Message value, int index,
			boolean isSelected, boolean cellHasFocus) {
		setOpaque(true);
		if (isSelected) {
			setBackground(Color.decode("#64B5F6"));
			setForeground(Color.WHITE);
		} else {
			if(index % 2 == 0) {
				setBackground(Color.WHITE);
			} else {
				setBackground(Color.LIGHT_GRAY);
			}
			setForeground(Color.BLACK);
		}

		String utilisateur = value.getTexte();
		setText(utilisateur);
		setFont(list.getFont());
		return this;
	}

}
