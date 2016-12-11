package fr.lille1.univ.coo.tp.vue.listes.cellrenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.vue.discussion.Avatar;

public class AmitieListCellRenderer implements ObservableListRenderer<Amitie>  {
	@Override
	public Component getListCellRendererComponent(JList<? extends Amitie> list, Amitie amitie, int index,
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

		Avatar avatar = new Avatar(); // TODO : Faire en sorte qu'on puisse redimensionner l'avatar
//		setSize(20, 20);
		IUtilisateur utilisateur = amitie.getAmi();
		avatar.setImage(utilisateur.getAvatar());
		String texte = utilisateur.getPseudo() + (utilisateur == Application.getInstance().getSession().getUtilisateur() ? " (Vous)" : "");
		label.setIcon(avatar);
		label.setText(texte);
		label.setFont(list.getFont());
		return label;
	}

}
