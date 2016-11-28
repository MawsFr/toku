package fr.lille1.univ.coo.tp.vue.accueil;

import javax.swing.JList;
import javax.swing.JPanel;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class OngletAmis extends JPanel {
	
	private JList<Utilisateur> listeAmis;
	private UtilisateurListModel model;
	private Utilisateur utilisateur;
	
	public OngletAmis() {
		listeAmis = new JList<>();
	}
	
	public void initialiser() {
		utilisateur = Application.getInstance().getSession().getUtilisateur();
		model = new UtilisateurListModel(utilisateur.getAmis());
		listeAmis.setModel(model);
	}

}
