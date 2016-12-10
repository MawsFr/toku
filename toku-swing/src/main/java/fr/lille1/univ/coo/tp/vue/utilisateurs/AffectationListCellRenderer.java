package fr.lille1.univ.coo.tp.vue.utilisateurs;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;

public class AffectationListCellRenderer extends DiscussionListCellRenderer {
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
		IUtilisateur utilisateur = value.getUtilisateur();
		String nom = utilisateur.getPseudo() + (utilisateur == Application.getInstance().getSession().getUtilisateur() ? " (Vous)" : "");
		setText(nom);
		setFont(list.getFont());
		return this;
	}

}
