package fr.lille1.univ.coo.tp.vue.notification;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.amitie.AccepterAmiAction;
import fr.lille1.univ.coo.tp.controlleurs.amitie.RefuserAmiAction;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class NotificationPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private Amitie amitie;

	private JLabel texte;

	private JButton btnSupprimer;

	private JButton btnRefuser;

	private JButton btnAccepter;

	public NotificationPanel(Amitie amitie) {
		this.amitie = amitie;
		btnAccepter = new JButton(new AccepterAmiAction(this));
		btnRefuser = new JButton(new RefuserAmiAction(this));
		btnSupprimer = new JButton("x");
		this.setLayout(new BorderLayout());

		JPanel barreAction = new JPanel();
		barreAction.setLayout(new FlowLayout(FlowLayout.RIGHT));
		barreAction.add(btnRefuser);
		barreAction.add(btnAccepter);

		JPanel barreSupprimer = new JPanel();
		barreSupprimer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		barreSupprimer.add(btnSupprimer);

		texte = new JLabel();

		this.add(barreSupprimer, BorderLayout.NORTH);
		this.add(texte, BorderLayout.CENTER);
		this.add(barreAction, BorderLayout.SOUTH);

		this.setOpaque(true);

		this.setPreferredSize(new Dimension(200, 100));
		actualiser();

	}

	public void actualiser() {
 		boolean estDemandeur = amitie.getDemandeur().equals(Application.getInstance().getSession().getUtilisateur());
		if(estDemandeur) {
			cacherActions();
			if(amitie.getEtat().equals(Amitie.ETAT_EN_ATTENTE)) {
				texte.setText(amitie.getAmi().getPseudo() + " a bien reçu votre demande d'ajout en ami. ");
			} else {
				if(amitie.getEtat().equals(Amitie.ETAT_REFUSEE)) {
					texte.setText(amitie.getAmi().getPseudo() + " a refusé votre demande d'ajout en ami");
				} else if(amitie.getEtat().equals(Amitie.ETAT_VALIDEE)) {
					texte.setText(amitie.getAmi().getPseudo() + " est maintenant votre ami");
				}
			}
		} else {
			if(amitie.getEtat().equals(Amitie.ETAT_EN_ATTENTE)) {
				texte.setText(amitie.getAmi().getPseudo() + " souhaite vous ajouter en ami. ");
			} else {
				cacherActions();
				if(amitie.getEtat().equals(Amitie.ETAT_REFUSEE)) {
					texte.setText(amitie.getAmi().getPseudo() + " a été notifié de votre refus");
				} else if(amitie.getEtat().equals(Amitie.ETAT_VALIDEE)) {
					texte.setText(amitie.getAmi().getPseudo() + " a été notifié de votre acceptation");
				}
			}
		}
	}
	
	public void cacherActions() {
		this.btnAccepter.setVisible(false);
		this.btnRefuser.setVisible(false);
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
