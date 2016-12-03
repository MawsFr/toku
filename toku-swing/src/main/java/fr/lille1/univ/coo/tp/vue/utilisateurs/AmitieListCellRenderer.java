package fr.lille1.univ.coo.tp.vue.utilisateurs;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.discussion.Avatar;

public class AmitieListCellRenderer extends UtilisateurListCellRenderer  {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<? extends Utilisateur> list, Utilisateur value, int index,
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

		Avatar avatar = new Avatar(); // TODO : Faire en sorte qu'on puisse redimensionner l'avatar
//		setSize(20, 20);
		avatar.setImage(value.getAvatar());
		String texte = value.getPseudo() + (value == Application.getInstance().getSession().getUtilisateur() ? " (Vous)" : "");
		setIcon(avatar);
		setText(texte);
		setFont(list.getFont());
		return this;
	}

}
