package fr.lille1.univ.coo.tp.vue.listes.cellrenderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.cryptage.CryptageException;
import fr.lille1.univ.coo.tp.cryptage.CrypteurROT13;
import fr.lille1.univ.coo.tp.message.Message;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class MessageListCellRenderer implements ObservableListRenderer<Message> {

	@Override
	public Component getListCellRendererComponent(JList<? extends Message> list, Message value, int index,
			boolean isSelected, boolean cellHasFocus) {
		JPanel messagePanel = new JPanel();
		Utilisateur utilisateur = Application.getInstance().getSession().getUtilisateur();
		messagePanel.setOpaque(true);
		if (isSelected) {
			messagePanel.setBackground(Color.decode("#64B5F6"));
			messagePanel.setForeground(Color.WHITE);
		} else {
			if(utilisateur.equals(value.getUtilisateur())) {
				messagePanel.setBackground(Color.LIGHT_GRAY);
			} else {
				messagePanel.setBackground(Color.WHITE);
			}
			if (value.getPrioritaire()) {
				messagePanel.setBackground(Color.decode("#fcb8b8"));
			}
			if(value.getAccuse_reception() && !value.getLu() && !utilisateur.equals(value.getUtilisateur())) {
				try {
					Service.getDiscussionService().lireMessage(value);
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
			if(utilisateur.equals(value.getUtilisateur()) && value.getAccuse_reception() && value.getLu()) {
				messagePanel.setBorder(BorderFactory.createTitledBorder("Lu"));
			}
			messagePanel.setForeground(Color.BLACK);

		}

		String message = value.getUtilisateur().getPseudo() + " : " + value.getTexte();
		messagePanel.add(new JLabel(message));
		if(utilisateur.equals(value.getUtilisateur())) {
			messagePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		} else {
			messagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		}
		messagePanel.setFont(list.getFont());
		return messagePanel;
	}

}
