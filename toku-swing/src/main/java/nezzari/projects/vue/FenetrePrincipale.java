package nezzari.projects.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nezzari.projects.Application;
import nezzari.projects.OutilsSwing;

public class FenetrePrincipale {
	public static final int POURCENTAGE_LONGUEUR = 25;
	public static final int ESPACE_LARGEUR = 100;
	
	public static final int MIN_POURCENTAGE_LARGEUR = 50;
	
	public static final String TITRE = "Toku";
	
	private JFrame fenetre;
	private Application application;
	private PanneauPrincipal panneauPrincipal;
	private BarreMenuPrincipale menu;
	
	public FenetrePrincipale(Application application) {
		this.application = application;
		fenetre = new JFrame();
		menu = new BarreMenuPrincipale();
		panneauPrincipal = new PanneauPrincipal(this);
		
		fenetre.setTitle(TITRE);
		Container c = fenetre.getContentPane();
		c.setLayout(new BorderLayout());
		
		OutilsSwing.ajouterBarreMenu(fenetre, menu);
		c.add(panneauPrincipal, BorderLayout.CENTER);
		
		final Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		fenetre.setSize(tailleEcran.width * POURCENTAGE_LONGUEUR / 100, tailleEcran.height - ESPACE_LARGEUR);
		fenetre.setMinimumSize(new Dimension(fenetre.getWidth(), fenetre.getHeight() * MIN_POURCENTAGE_LARGEUR / 100));
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
	}

	public JFrame getFenetre() {
		return fenetre;
	}

	public void setFenetre(JFrame fenetre) {
		this.fenetre = fenetre;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}
	
	

}
