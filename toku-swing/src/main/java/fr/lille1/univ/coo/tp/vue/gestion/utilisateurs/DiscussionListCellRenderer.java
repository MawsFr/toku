package fr.lille1.univ.coo.tp.vue.gestion.utilisateurs;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.vue.discussion.Avatar;

public class DiscussionListCellRenderer extends JLabel implements ObservableListRenderer<Discussion> {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<? extends Discussion> list, Discussion value, int index,
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

		String discussion = value.getNom() + " (" + value.getMembres().getListe().size() + " membre(s))";
		setText(discussion);
		setFont(list.getFont());
		return this;
	}

}
