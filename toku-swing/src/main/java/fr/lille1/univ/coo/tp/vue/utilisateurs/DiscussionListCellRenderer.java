package fr.lille1.univ.coo.tp.vue.utilisateurs;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;

public class DiscussionListCellRenderer extends JLabel implements ObservableListRenderer<AffectationDiscussion> {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<? extends AffectationDiscussion> list, AffectationDiscussion value, int index,
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

		String discussion = value.getDiscussion().getNom() + " (" + value.getDiscussion().getAffectations().getListe().size() + " membre(s))";
		setText(discussion);
		setFont(list.getFont());
		return this;
	}

}
