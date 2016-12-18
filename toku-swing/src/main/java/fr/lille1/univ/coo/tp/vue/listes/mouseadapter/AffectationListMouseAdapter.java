package fr.lille1.univ.coo.tp.vue.listes.mouseadapter;

import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.discussion.DesaffecterAction;
import fr.lille1.univ.coo.tp.controlleurs.discussion.PasserDroitModo;
import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;
import fr.lille1.univ.coo.tp.vue.listes.JObservableList;

public class AffectationListMouseAdapter extends JObservableListMouseAdapter<AffectationDiscussion> {

	private FenetreDiscussion fenetre;

	public AffectationListMouseAdapter(FenetreDiscussion fenetreDiscussion) {
		super(fenetreDiscussion.getListeMembres());
		this.fenetre = fenetreDiscussion;
	}

	@Override
	public void doubleClic(AffectationDiscussion element, MouseEvent e) {
	}

	@Override
	public void clic(AffectationDiscussion element, MouseEvent e) {

	}

	@Override
	public void clicDroit(AffectationDiscussion element, MouseEvent e) {
		if(element != null) {
			Utilisateur utilisateur = Application.getInstance().getSession().getUtilisateur();
			try {
				if(Service.getUtilisateurService().estAdministrateur(utilisateur) || Service.getUtilisateurService().estModerateur(element.getDiscussion(), utilisateur)){
					JPopupMenu menuAffectation = new JPopupMenu("Administration");
					JMenuItem menuPasserDroitModo = new JMenuItem(new PasserDroitModo(fenetre));
					JMenuItem menuSupprimerAffectation = new JMenuItem(new DesaffecterAction(fenetre));
					menuSupprimerAffectation.setText("Supprimer de la discussion");

					menuAffectation.add(menuPasserDroitModo);
					menuAffectation.add(menuSupprimerAffectation);
					menuAffectation.show(liste, e.getX(), e.getY());
				}
			} catch (ServiceException e1) {
				e1.printStackTrace();
			}
		}
	}

}
