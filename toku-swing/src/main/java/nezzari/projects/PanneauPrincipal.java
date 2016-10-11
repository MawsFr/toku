package nezzari.projects;

import java.awt.CardLayout;

import javax.swing.JPanel;

import nezzari.projects.connexion.PanneauConnexion;
import nezzari.projects.discussion.PanneauDiscussion;

public class PanneauPrincipal extends JPanel {

	public static final String PANNEAU_CONNEXION = "Panneau de connexion";
	public static final String PANNEAU_DISCUSSION = "Panneau de discussion";
	
	private FenetrePrincipale fenetre;
	private CardLayout panneaux;
	
	private PanneauConnexion panneauConnexion;
	private PanneauDiscussion panneauDiscussion;
	
	public PanneauPrincipal(FenetrePrincipale fenetre) {
		this.fenetre = fenetre;
		panneaux = new CardLayout();
		this.setLayout(panneaux);
		
		panneauConnexion = new PanneauConnexion(fenetre);
		panneauDiscussion = new PanneauDiscussion(fenetre);
		
		this.add(panneauConnexion, PANNEAU_CONNEXION);
		this.add(panneauDiscussion, PANNEAU_DISCUSSION);
		
		
	}
	
}
