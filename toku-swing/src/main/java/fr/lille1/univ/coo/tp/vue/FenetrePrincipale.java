package fr.lille1.univ.coo.tp.vue;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.GestionnaireConnexion;
import fr.lille1.univ.coo.tp.utils.Constantes;
import fr.lille1.univ.coo.tp.utils.OutilsSwing;

public class FenetrePrincipale {
	private static FenetrePrincipale instance;
	
	public static FenetrePrincipale getInstance() {
		if(instance == null) {
			instance = new FenetrePrincipale();
		}
		
		return instance;
	}
	
	public static final int POURCENTAGE_LONGUEUR = 25;
	public static final int ESPACE_LARGEUR = 100;
	
	public static final int MIN_POURCENTAGE_LARGEUR = 50;
	
	public static final String TITRE = "Toku";
	
	private JFrame fenetre;
	private Application application;
	private PanneauPrincipal panneauPrincipal;
	private BarreMenuPrincipale menu;
	private BarreEtat barreEtat;
	
	private FenetrePrincipale() {
		fenetre = new JFrame();
		menu = new BarreMenuPrincipale();
		panneauPrincipal = new PanneauPrincipal(this);
		barreEtat = new BarreEtat(this);
		
		fenetre.setTitle(TITRE);
		Container c = fenetre.getContentPane();
		c.setLayout(new BorderLayout());
		
		OutilsSwing.ajouterBarreMenu(fenetre, menu);
		c.add(panneauPrincipal, BorderLayout.CENTER);
		c.add(barreEtat, BorderLayout.SOUTH);
		
		fenetre.setIconImage(new ImageIcon(Application.class.getResource(Constantes.CHEMIN_APP_ICONE)).getImage());
		
		final Dimension tailleEcran = Toolkit.getDefaultToolkit().getScreenSize();
		fenetre.setSize(tailleEcran.width * POURCENTAGE_LONGUEUR / 100, tailleEcran.height - ESPACE_LARGEUR);
//		fenetre.setMinimumSize(new Dimension(fenetre.getWidth(), fenetre.getHeight() * MIN_POURCENTAGE_LARGEUR / 100));
		fenetre.setMinimumSize(fenetre.getSize());
//		fenetre.setPreferredSize(fenetre.getMinimumSize());
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fenetre.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				try {
					GestionnaireConnexion.fermerConnexion();
					System.out.println("Connexion fermée !");
				} catch (DAOException e1) {
					e1.printStackTrace();
				}
			}
		});
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
	
	public PanneauPrincipal getPanneauPrincipal() {
		return panneauPrincipal;
	}
	
	public BarreMenuPrincipale getMenu() {
		return menu;
	}
	
	public BarreEtat getBarreEtat() {
		return barreEtat;
	}
	

}
