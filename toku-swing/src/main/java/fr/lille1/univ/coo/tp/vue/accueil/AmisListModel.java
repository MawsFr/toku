package fr.lille1.univ.coo.tp.vue.accueil;

import javax.swing.DefaultListModel;

import fr.lille1.univ.coo.tp.utilisateur.ListeUtilisateur;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class AmisListModel extends DefaultListModel<Utilisateur> {
	
	private static final long serialVersionUID = 1L;
	private ListeUtilisateur amis;

	public AmisListModel(Utilisateur utilisateur) {
		this.amis = utilisateur.getAmis();
		for(Utilisateur ami : amis.getUtilisateurs()) {
			addElement(ami);
		}
	}
}
