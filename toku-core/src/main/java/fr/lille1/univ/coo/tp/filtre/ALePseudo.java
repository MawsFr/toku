package fr.lille1.univ.coo.tp.filtre;

import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class ALePseudo implements Filtre<Utilisateur> {
	
	private String pseudo;
	
	public ALePseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	@Override
	public boolean accepte(Utilisateur utilisateur) {
		return utilisateur.getPseudo().contains(pseudo);
	}

}
