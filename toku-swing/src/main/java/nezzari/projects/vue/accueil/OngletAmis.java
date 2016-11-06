package nezzari.projects.vue.accueil;

import javax.swing.JList;
import javax.swing.JPanel;

import nezzari.projects.Application;
import nezzari.projects.utilisateur.Utilisateur;

public class OngletAmis extends JPanel {
	
	private JList<Utilisateur> listeAmis;
	private AmisListModel model;
	private Utilisateur utilisateur;
	
	public OngletAmis() {
		listeAmis = new JList<>();
	}
	
	public void initialiser() {
		utilisateur = Application.getInstance().getSession().getUtilisateur();
		model = new AmisListModel(utilisateur);
		listeAmis.setModel(model);
	}

}
