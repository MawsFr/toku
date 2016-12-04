package fr.lille1.univ.coo.tp.vue.utilisateurs;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.IDiscussion;

public class AffectationListCellRenderer extends JLabel implements ObservableListRenderer<AffectationDiscussion> {

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
		IDiscussion discussion = value.getDiscussion();
		String nom = discussion.getNom() + " (" + discussion.getAffectations().getListe().size() + " membre(s))";
		setText(nom);
		setFont(list.getFont());
		return this;
	}

}
