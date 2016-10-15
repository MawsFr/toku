package nezzari.projects;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import nezzari.projects.utils.Log;

public class FenetrePrincipale {
	public static final int ESPACE_LONGUEUR = 200;
	public static final int ESPACE_LARGEUR = 100;
	
	public static final String TITRE = "Toku";
	
	private JFrame fenetre;
	private Application application;
	
	public FenetrePrincipale(Application application) {
		this.application = application;
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
