package fr.lille1.univ.coo.tp.controlleurs.accueil;

import java.awt.event.ActionEvent;
import java.lang.ref.WeakReference;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.accueil.PanneauAccueil;
import fr.lille1.univ.coo.tp.vue.recherche.RechercheAmis;
import fr.lille1.univ.coo.tp.vue.utilisateurs.GestionUtilisateurs;

public class RechercherAmisAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private PanneauAccueil panneauAccueil;

	public RechercherAmisAction(PanneauAccueil panneauAccueil) {
		putValue(NAME, PanneauAccueil.LBL_RECHERCHER_AMIS);
		this.panneauAccueil = panneauAccueil;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IObservableList<Utilisateur> utilisateurs;
		try {
			utilisateurs = Service.getUtilisateurService().rechercherTout();
			new RechercheAmis((IObservableList<Utilisateur>) new WeakReference<IObservableList<Utilisateur>>(utilisateurs).get());
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
	}
}
