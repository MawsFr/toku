package fr.lille1.univ.coo.tp.controlleurs.accueil;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.accueil.PanneauAccueil;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;

public class CreerGroupeAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private PanneauAccueil panneauAccueil;

	public CreerGroupeAction(PanneauAccueil panneauAccueil) {
		this.panneauAccueil = panneauAccueil;
		putValue(NAME, PanneauAccueil.LBL_AJOUTER_GROUPES);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nom = JOptionPane.showInputDialog(panneauAccueil, "Entrez le nom du groupe");
		if(nom == null || nom.isEmpty()) {
			JOptionPane.showMessageDialog(panneauAccueil, "Vous devez entrer un nom !", "Erreur", JOptionPane.ERROR_MESSAGE);
		} else {
			Utilisateur utilisateur = Application.getInstance().getSession().getUtilisateur();
			try {
				Discussion discussion = Service.getDiscussionService().creerDiscussion(nom, Discussion.TYPE_GROUPE);
				Service.getDiscussionService().validerDiscussions();
				Service.getDiscussionService().ajouterUtilisateur(discussion, utilisateur, AffectationDiscussion.ETAT_OUVERTE);
				Service.getDiscussionService().validerAffectations();
				new FenetreDiscussion(discussion);
			} catch (ServiceException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(panneauAccueil, "Ce nom de groupe est déjà pris !", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}

	
}
