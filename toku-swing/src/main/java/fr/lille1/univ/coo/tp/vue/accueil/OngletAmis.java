package fr.lille1.univ.coo.tp.vue.accueil;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.AmisListMouseAdapter;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JAmisList;

public class OngletAmis extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JAmisList listeAmis;
	private Utilisateur utilisateur;
	
	public OngletAmis() {
		this.setLayout(new BorderLayout());
	}
	
	public void initialiser() {
		removeAll();
		utilisateur = Application.getInstance().getSession().getUtilisateur();
		listeAmis = new JAmisList(utilisateur);
		listeAmis.addMouseListener(new AmisListMouseAdapter(listeAmis));
		this.add(new JScrollPane(listeAmis), BorderLayout.CENTER);
	}

}
