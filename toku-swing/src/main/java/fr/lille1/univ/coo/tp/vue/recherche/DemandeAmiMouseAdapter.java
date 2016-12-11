package fr.lille1.univ.coo.tp.vue.recherche;

import javax.swing.JOptionPane;

import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.listes.JObservableList;
import fr.lille1.univ.coo.tp.vue.listes.mouseadapter.JObservableListMouseAdapter;

public class DemandeAmiMouseAdapter extends JObservableListMouseAdapter<Utilisateur> {

	private RechercheAmis rechercheAmi;

	public DemandeAmiMouseAdapter(RechercheAmis rechercheAmi, JObservableList<Utilisateur> liste) {
		super(liste);
		this.rechercheAmi = rechercheAmi;
	}

	@Override
	public void doubleClic(Utilisateur element) {
		rechercheAmi.ajouterAmi(element);
	}

	@Override
	public void clic(Utilisateur element) {
		
	}

	@Override
	public void clicDroit(Utilisateur element) {
		
	}
}
