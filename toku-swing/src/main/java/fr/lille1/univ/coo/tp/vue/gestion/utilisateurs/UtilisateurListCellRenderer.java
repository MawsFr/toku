package fr.lille1.univ.coo.tp.vue.gestion.utilisateurs;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.discussion.Avatar;

public class UtilisateurListCellRenderer extends JLabel implements ListCellRenderer<Utilisateur> {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<? extends Utilisateur> list, Utilisateur value, int index,
			boolean isSelected, boolean cellHasFocus) {
		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			if(index % 2 == 0) {
				setBackground(list.getBackground());
			} else {
				setBackground(Color.LIGHT_GRAY);
			}
			setForeground(list.getForeground());
		}

		//Set the icon and text.  If icon was null, say so.
		Avatar avatar = new Avatar();
		avatar.setImage(value.getAvatar());
		String utilisateur = value.getPseudo() + (value == Application.getInstance().getSession().getUtilisateur() ? " <b>(Vous)</b>" : "");
		setIcon(avatar);
		setText(utilisateur);
		setFont(list.getFont());
		return this;
	}

}
