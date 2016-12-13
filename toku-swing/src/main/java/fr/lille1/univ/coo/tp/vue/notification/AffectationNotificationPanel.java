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
import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;

public class AffectationNotificationPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private AffectationDiscussion affectation;

	private JLabel texte;

	private JButton btnSupprimer;

	public AffectationNotificationPanel(AffectationDiscussion affectationDiscussion) {
		this.affectation = affectationDiscussion;
		btnSupprimer = new JButton("x");
		this.setLayout(new BorderLayout());

		JPanel barreSupprimer = new JPanel();
		barreSupprimer.setLayout(new FlowLayout(FlowLayout.RIGHT));
		barreSupprimer.add(btnSupprimer);

		texte = new JLabel();

		this.add(barreSupprimer, BorderLayout.NORTH);
		this.add(texte, BorderLayout.CENTER);

		this.setOpaque(true);

		this.setPreferredSize(new Dimension(200, 100));
		actualiser();

	}

	public void actualiser() {
		if(affectation.getEtat().equals(AffectationDiscussion.ETAT_EN_ATTENTE)) {
			texte.setText("Vous avez été ajouté à la discussion " + affectation.getDiscussion().getNom());
		} else if(affectation.getEtat().equals(AffectationDiscussion.ETAT_VU)) {
			texte.setText("Vous avez de nouveaux messages dans la discussion " + affectation.getDiscussion().getNom());
		}
	}

	/**
	 * @return Le affectation
	 */
	public AffectationDiscussion getAffectation() {
		return affectation;
	}

	/**
	 * @param affectation Le nouveau affectation
	 */
	public void setAffectation(AffectationDiscussion affectation) {
		this.affectation = affectation;
	}


}
