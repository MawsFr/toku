package nezzari.projects.vue.accueil;

import javax.swing.DefaultListModel;

import nezzari.projects.utilisateur.ListeAmis;
import nezzari.projects.utilisateur.Utilisateur;

public class AmisListModel extends DefaultListModel<Utilisateur> {
	
	private ListeAmis amis;

	public AmisListModel(Utilisateur utilisateur) {
		for(Utilisateur ami : utilisateur.getAmis().getListe()) {
			addElement(ami);
		}
	}
}
