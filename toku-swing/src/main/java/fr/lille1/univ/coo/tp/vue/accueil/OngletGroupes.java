package fr.lille1.univ.coo.tp.vue.accueil;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.DiscussionListMouseAdapter;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JAffectationList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JDiscussionList;

public class OngletGroupes extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private JAffectationList listeDiscussions;
	private IUtilisateur utilisateur;
	
	public OngletGroupes() {
		this.setLayout(new BorderLayout());
	}
	
	public void initialiser() {
		removeAll();
		utilisateur = Application.getInstance().getSession().getUtilisateur();
		listeDiscussions = new JAffectationList(utilisateur.getAffectations());
		listeDiscussions.addMouseListener(new DiscussionListMouseAdapter(listeDiscussions));
		this.add(new JScrollPane(listeDiscussions), BorderLayout.CENTER);
	}


}
