package nezzari.projects;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FenetrePrincipale {
	public static final int ESPACE_LONGUEUR = 200;
	public static final int ESPACE_LARGEUR = 100;
	
	public static final String TITRE = "Toku";
	
	private JFrame fenetre;
	
	public FenetrePrincipale() {
		fenetre = new JFrame();
		fenetre.setTitle(TITRE);
		fenetre.setContentPane(new PanneauPrincipal(this));
		
		final Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(tailleEcran.width - ESPACE_LONGUEUR, tailleEcran.height - ESPACE_LARGEUR);
		fenetre.setResizable(false);
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
	}

}
