package fr.lille1.univ.coo.tp.vue.notification;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.lille1.univ.coo.tp.controlleurs.amitie.AccepterAmiAction;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;

public class NotificationPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private Amitie amitie;

	public NotificationPanel(Amitie amitie) {
		this.amitie = amitie;
		JButton btnAccepter = new JButton("Accepter");
		btnAccepter.addActionListener(new AccepterAmiAction(this));
		JButton btnRefuser = new JButton("Refuser");
		JButton btnSupprimer = new JButton("x");
		this.setLayout(new BorderLayout());

		JPanel barreAction = new JPanel();
		barreAction.setLayout(new FlowLayout(FlowLayout.RIGHT));
		barreAction.add(btnRefuser);
		barreAction.add(btnAccepter);

		JPanel barreSupprimer = new JPanel();
		barreSupprimer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		barreSupprimer.add(btnSupprimer);

		JLabel texte = new JLabel();
		texte.setText(amitie.getAmi().getPseudo() + " souhaite vous ajouter en ami");

		this.add(barreSupprimer, BorderLayout.NORTH);
		this.add(texte, BorderLayout.CENTER);
		this.add(barreAction, BorderLayout.SOUTH);

		this.setOpaque(true);
		
		this.setPreferredSize(new Dimension(200, 100));

	}

	/**
	 * @return Le amitie
	 */
	public Amitie getAmitie() {
		return amitie;
	}

	/**
	 * @param amitie Le nouveau amitie
	 */
	public void setAmitie(Amitie amitie) {
		this.amitie = amitie;
	}


}
