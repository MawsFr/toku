package fr.lille1.univ.coo.tp.vue.accueil;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.AmisListMouseAdapter;
import fr.lille1.univ.coo.tp.controlleurs.FiltrerAmiAction;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.utilisateurs.GestionUtilisateurs;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JAmisList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JTexteFiltre;

public class OngletAmis extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JAmisList listeAmis;
	private Utilisateur utilisateur;

	private JTexteFiltre<Amitie> filtre;
	
	public OngletAmis() {
		this.setLayout(new BorderLayout());
	}
	
	public void initialiser() {
		removeAll();
		utilisateur = Application.getInstance().getSession().getUtilisateur();
		listeAmis = new JAmisList(utilisateur.getAmities());
		listeAmis.addMouseListener(new AmisListMouseAdapter(listeAmis));
		this.add(new JScrollPane(listeAmis), BorderLayout.CENTER);
		
		JPanel recherche = new JPanel();
		recherche.setLayout(new BoxLayout(recherche, BoxLayout.X_AXIS));
		filtre = listeAmis.getTexte();
		filtre.getDocument().addDocumentListener(new FiltrerAmiAction(listeAmis));
		filtre.setHint(GestionUtilisateurs.AIDE_FILTRE);
		
		recherche.add(new JLabel("Filtre :"));
		recherche.add(filtre);
		this.add(recherche, BorderLayout.NORTH);
	}

}
