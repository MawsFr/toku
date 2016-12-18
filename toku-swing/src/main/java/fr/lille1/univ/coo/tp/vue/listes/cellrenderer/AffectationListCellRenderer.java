package fr.lille1.univ.coo.tp.vue.listes.cellrenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;

public class AffectationListCellRenderer implements ObservableListRenderer<AffectationDiscussion> {
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
		IUtilisateur utilisateur = value.getUtilisateur();
		String nom = utilisateur.getPseudo();
		try {
			if(Service.getUtilisateurService().estAdministrateur(utilisateur)) {
				nom += " (Admin)";
			} 
			if(Service.getUtilisateurService().estModerateur(value.getDiscussion(), utilisateur)){
				nom += " (Modérateur)";
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		label.setText(nom);
		label.setFont(list.getFont());
		return label;
	}

}
