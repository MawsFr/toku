package fr.lille1.univ.coo.tp.vue.listes.cellrenderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import fr.lille1.univ.coo.tp.utilisateur.Amitie;

public class DemandeAmisListCellRenderer implements ObservableListRenderer<Amitie>  {
	@Override
	public Component getListCellRendererComponent(JList<? extends Amitie> list, Amitie amitie, int index,
			boolean isSelected, boolean cellHasFocus) {
		JPanel notification = new JPanel();
		JButton btnAccepter = new JButton("Accepter");
		btnAccepter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("HELLO");
			}
		});
		JButton btnRefuser = new JButton("Refuser");
		JButton btnSupprimer = new JButton("x");
		notification.setLayout(new BorderLayout());
		
		JPanel barreAction = new JPanel();
		barreAction.setLayout(new FlowLayout(FlowLayout.RIGHT));
		barreAction.add(btnRefuser);
		barreAction.add(btnAccepter);
		
		JPanel barreSupprimer = new JPanel();
		barreSupprimer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		barreSupprimer.add(btnSupprimer);
		
		JLabel texte = new JLabel();
		texte.setFont(list.getFont());
		texte.setText(amitie.getAmi().getPseudo() + " souhaite vous ajouter en ami");
		
		notification.add(barreSupprimer, BorderLayout.NORTH);
		notification.add(texte, BorderLayout.CENTER);
		notification.add(barreAction, BorderLayout.SOUTH);
		
		notification.setOpaque(true);
		if (isSelected) {
			notification.setBackground(Color.decode("#64B5F6"));
			notification.setForeground(Color.WHITE);
		} else {
			if(index % 2 == 0) {
				notification.setBackground(Color.WHITE);
			} else {
				notification.setBackground(Color.LIGHT_GRAY);
			}
			notification.setForeground(Color.BLACK);
		}
		
		return notification;
	}

}
