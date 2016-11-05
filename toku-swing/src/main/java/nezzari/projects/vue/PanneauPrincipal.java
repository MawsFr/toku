package nezzari.projects.vue;

import java.awt.CardLayout;

import javax.swing.JPanel;

import nezzari.projects.vue.connexion.PanneauConnexion;
import nezzari.projects.vue.discussion.PanneauAccueil;

public class PanneauPrincipal extends JPanel {

	public static final String PANNEAU_CONNEXION = "Panneau de connexion";
	public static final String PANNEAU_DISCUSSION = "Panneau de discussion";
	
	private FenetrePrincipale fenetre;
	private CardLayout panneaux;
	
	private PanneauConnexion panneauConnexion;
	private PanneauAccueil panneauDiscussion;
	
	public PanneauPrincipal(FenetrePrincipale fenetre) {
		this.fenetre = fenetre;
		panneaux = new CardLayout();
		this.setLayout(panneaux);
		
		panneauConnexion = new PanneauConnexion(fenetre);
		panneauDiscussion = new PanneauAccueil(fenetre);
		
		this.add(panneauConnexion, PANNEAU_CONNEXION);
		this.add(panneauDiscussion, PANNEAU_DISCUSSION);
	}
	
	public PanneauConnexion getPanneauConnexion() {
		return panneauConnexion;
	}
	
	public PanneauAccueil getPanneauDiscussion() {
		return panneauDiscussion;
	}
	
	public void afficherEcran(String ecran) {
		this.panneaux.show(this, ecran);
	}
	
}
