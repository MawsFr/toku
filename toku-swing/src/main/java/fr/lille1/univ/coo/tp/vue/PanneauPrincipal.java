package fr.lille1.univ.coo.tp.vue;

import java.awt.CardLayout;

import javax.swing.JPanel;

import fr.lille1.univ.coo.tp.vue.accueil.PanneauAccueil;
import fr.lille1.univ.coo.tp.vue.connexion.PanneauConnexion;

public class PanneauPrincipal extends JPanel {

	public static final String PANNEAU_CONNEXION = "Panneau de connexion";
	public static final String PANNEAU_ACCUEIL = "Panneau d'accueil";
	
	private FenetrePrincipale fenetre;
	private CardLayout panneaux;
	
	private PanneauConnexion panneauConnexion;
	private PanneauAccueil panneauAccueil;
	
	public PanneauPrincipal(FenetrePrincipale fenetre) {
		this.fenetre = fenetre;
		panneaux = new CardLayout();
		this.setLayout(panneaux);
		
		panneauConnexion = new PanneauConnexion(fenetre);
		panneauAccueil = new PanneauAccueil(fenetre);
		
		this.add(panneauConnexion, PANNEAU_CONNEXION);
		this.add(panneauAccueil, PANNEAU_ACCUEIL);
	}
	
	public PanneauConnexion getPanneauConnexion() {
		return panneauConnexion;
	}
	
	public PanneauAccueil getPanneauAccueil() {
		return panneauAccueil;
	}
	
	public void afficherEcran(String ecran) {
		this.panneaux.show(this, ecran);
	}
	
}
