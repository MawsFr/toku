package fr.lille1.univ.coo.tp.vue.accueil;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.OuvrirFenetreDiscussion;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.vue.gestion.utilisateurs.JListUtilisateur;

public class OngletAmis extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JListUtilisateur listeAmis;
	private IUtilisateur utilisateur;
	
	public OngletAmis() {
		this.setLayout(new BorderLayout());
	}
	
	public void initialiser() {
		removeAll();
		utilisateur = Application.getInstance().getSession().getUtilisateur();
		listeAmis = new JListUtilisateur(utilisateur.getAmis());
		listeAmis.addMouseListener(new OuvrirFenetreDiscussion(listeAmis));
		this.add(new JScrollPane(listeAmis), BorderLayout.CENTER);
	}

}
