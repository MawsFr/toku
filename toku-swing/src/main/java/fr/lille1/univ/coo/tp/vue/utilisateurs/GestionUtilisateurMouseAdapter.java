package fr.lille1.univ.coo.tp.vue.utilisateurs;

import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.utilisateurs.FenetreProfil.ModeEdition;

public class GestionUtilisateurMouseAdapter extends JObservableListMouseAdapter<Utilisateur> {
	private GestionUtilisateurs gestionUtilisateur;

	public GestionUtilisateurMouseAdapter(GestionUtilisateurs gestionUtilisateurs, JObservableList<Utilisateur> liste) {
		super(liste);
		this.gestionUtilisateur = gestionUtilisateurs;
	}

	@Override
	public void doubleClic(Utilisateur element) {
		new FenetreProfil(gestionUtilisateur, ModeEdition.MODIF, element);
	}

	@Override
	public void clic(Utilisateur element) {
		
	}

	@Override
	public void clicDroit(Utilisateur element) {
		
	}
	
}
