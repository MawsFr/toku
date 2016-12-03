package fr.lille1.univ.coo.tp.controlleurs.menu.admin;

import java.awt.event.ActionEvent;
import java.lang.ref.WeakReference;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.BarreMenuPrincipale;
import fr.lille1.univ.coo.tp.vue.utilisateurs.GestionUtilisateurs;

public class GestionUtilisateursAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private static GestionUtilisateursAction instance;

	public static GestionUtilisateursAction getInstance() {
		if(instance == null) {
			instance = new GestionUtilisateursAction();
		}
		
		return instance;
	}
	
	private GestionUtilisateursAction() {
		super(BarreMenuPrincipale.MENU_GERER_UTILISATEURS);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		IObservableList<Utilisateur> utilisateurs;
		try {
			utilisateurs = Service.getUtilisateurService().rechercherTout();
			new GestionUtilisateurs((IObservableList<Utilisateur>) new WeakReference<IObservableList<Utilisateur>>(utilisateurs).get());
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
	}

}
