package fr.lille1.univ.coo.tp.vue.accueil;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.FiltrerAmiAction;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.listes.JAmisList;
import fr.lille1.univ.coo.tp.vue.listes.JTexteFiltre;
import fr.lille1.univ.coo.tp.vue.listes.cellrenderer.AmitieListCellRenderer;
import fr.lille1.univ.coo.tp.vue.listes.mouseadapter.AmisListMouseAdapter;
import fr.lille1.univ.coo.tp.vue.utilisateurs.GestionUtilisateurs;

public class OngletAmis extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public static final String MESSAGE_VIDE = "Vous n'avez aucun amis, cliquez sur +Amis pour en ajouter !";
	
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
		listeAmis.setMessageVide(MESSAGE_VIDE);
		listeAmis.setCellRenderer(new AmitieListCellRenderer());
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
