package fr.lille1.univ.coo.tp.vue.listes.mouseadapter;

import java.awt.event.MouseEvent;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;
import fr.lille1.univ.coo.tp.vue.listes.JAffectationList;

public class DiscussionListMouseAdapter extends JObservableListMouseAdapter<AffectationDiscussion> {
	public DiscussionListMouseAdapter(JAffectationList listeDiscussions) {
		super(listeDiscussions);
	}

	@Override
	public void doubleClic(AffectationDiscussion element, MouseEvent e) {
		if(element == null) {
			return;
		}
		Utilisateur utilisateur = Application.getInstance().getSession().getUtilisateur();
		FenetreDiscussion fenetre = new FenetreDiscussion(element.getDiscussion());
		if(element.getDiscussion().getLeType().equals(Discussion.TYPE_PRIVE)) {
			fenetre.getPanneauPrincipal().setRightComponent(null);
		} else {
			try {
				if(!Service.getUtilisateurService().estAdministrateur(utilisateur) && !Service.getUtilisateurService().estModerateur(element.getDiscussion(), utilisateur)) {
					fenetre.getPanneauBoutonMembres().setVisible(false);
				}
			} catch (ServiceException e1) {
				e1.printStackTrace();
				fenetre.dispose();
			}
		}
		try {
			element.setEtat(AffectationDiscussion.ETAT_LU);
			Service.getDiscussionService().validerAffectations();
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void clic(AffectationDiscussion element, MouseEvent e) {}

	@Override
	public void clicDroit(AffectationDiscussion element, MouseEvent e) {}

}
