package fr.lille1.univ.coo.tp.vue;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class BarreEtat extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private FenetrePrincipale fenetre;
	private JLabel texte;
	private JProgressBar progression;
	
	public BarreEtat(FenetrePrincipale fenetre) {
		this.fenetre = fenetre;
		this.texte = new JLabel("Bienvenue");
		this.progression = new JProgressBar();
		this.progression.setVisible(false);
		
		this.setPreferredSize(new Dimension(fenetre.getFenetre().getWidth(), 20));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(texte);
		this.add(Box.createHorizontalGlue());
		this.add(progression);
//		this.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		this.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
	}
	
	public void setTexte(String texte) {
		this.texte.setText(texte);
	}
	
	public void setEnCours() {
		this.progression.setVisible(true);
		this.progression.setIndeterminate(true);
	}
	
	public void setFini() {
		this.progression.setVisible(false);
		this.progression.setIndeterminate(false);
	}
}
