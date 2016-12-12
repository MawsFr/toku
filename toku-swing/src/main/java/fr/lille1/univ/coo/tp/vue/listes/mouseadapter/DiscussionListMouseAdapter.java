package fr.lille1.univ.coo.tp.vue.listes.mouseadapter;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
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
	public void doubleClic(AffectationDiscussion element) {
		if(element == null) {
			return;
		}
		Utilisateur utilisateur = Application.getInstance().getSession().getUtilisateur();
        FenetreDiscussion fenetre = new FenetreDiscussion(element.getDiscussion());
        try {
			if(!Service.getUtilisateurService().estAdministrateur(utilisateur) && !Service.getUtilisateurService().estModerateur(element.getDiscussion(), utilisateur)) {
				fenetre.getPanneauBoutonMembres().setVisible(false);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			fenetre.dispose();
		}
	}

	@Override
	public void clic(AffectationDiscussion element) {}

	@Override
	public void clicDroit(AffectationDiscussion element) {}
	
}
