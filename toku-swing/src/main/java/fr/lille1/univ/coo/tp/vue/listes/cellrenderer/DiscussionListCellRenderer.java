package fr.lille1.univ.coo.tp.vue.listes.cellrenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;

public class DiscussionListCellRenderer implements ObservableListRenderer<AffectationDiscussion> {

	@Override
	public Component getListCellRendererComponent(JList<? extends AffectationDiscussion> list, AffectationDiscussion value, int index,
			boolean isSelected, boolean cellHasFocus) {
		JLabel label = new JLabel();
		label.setOpaque(true);
		if (isSelected) {
			label.setBackground(Color.decode("#64B5F6"));
			label.setForeground(Color.WHITE);
		} else {
			if(index % 2 == 0) {
				label.setBackground(Color.WHITE);
			} else {
				label.setBackground(Color.LIGHT_GRAY);
			}
			label.setForeground(Color.BLACK);
		}

		String discussion = value.getDiscussion().getNom() + " (" + value.getDiscussion().getAffectations().getListe().size() + " membre(s))";
		label.setText(discussion);
		label.setFont(list.getFont());
		return label;
	}

}
