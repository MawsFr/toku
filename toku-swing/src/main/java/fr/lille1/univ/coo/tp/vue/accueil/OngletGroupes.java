package fr.lille1.univ.coo.tp.vue.accueil;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;
import fr.lille1.univ.coo.tp.vue.listes.JAffectationList;
import fr.lille1.univ.coo.tp.vue.listes.cellrenderer.DiscussionListCellRenderer;
import fr.lille1.univ.coo.tp.vue.listes.mouseadapter.DiscussionListMouseAdapter;

public class OngletGroupes extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public static final String MESSAGE_VIDE = "Vous n'avez aucune discussion, cliquez sur +Groupes pour en ajouter !";

	private JAffectationList listeDiscussions;
	private IUtilisateur utilisateur;
	
	public OngletGroupes() {
		this.setLayout(new BorderLayout());
	}
	
	public void initialiser() {
		removeAll();
		utilisateur = Application.getInstance().getSession().getUtilisateur();
		listeDiscussions = new JAffectationList(utilisateur.getAffectations());
		listeDiscussions.setMessageVide(MESSAGE_VIDE);
		listeDiscussions.setCellRenderer(new DiscussionListCellRenderer());
		listeDiscussions.addMouseListener(new DiscussionListMouseAdapter(listeDiscussions));
		this.add(new JScrollPane(listeDiscussions), BorderLayout.CENTER);
	}


}
