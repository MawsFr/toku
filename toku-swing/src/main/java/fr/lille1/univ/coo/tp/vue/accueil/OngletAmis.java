package fr.lille1.univ.coo.tp.vue.accueil;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.gestion.utilisateurs.JListUtilisateur;

public class OngletAmis extends JPanel {
	
	private JListUtilisateur listeAmis;
	private Utilisateur utilisateur;
	
	public OngletAmis() {
		this.setLayout(new BorderLayout());
	}
	
	public void initialiser() {
		removeAll();
		utilisateur = Application.getInstance().getSession().getUtilisateur();
		listeAmis = new JListUtilisateur(utilisateur.getAmis());
		this.add(listeAmis, BorderLayout.CENTER);
	}

}
