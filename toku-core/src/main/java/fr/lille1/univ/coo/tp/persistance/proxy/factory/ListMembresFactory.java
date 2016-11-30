package fr.lille1.univ.coo.tp.persistance.proxy.factory;

import java.util.ArrayList;
import java.util.List;

import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.ObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class ListMembresFactory implements Factory<IObservableList<Utilisateur>> {

	@Override
	public IObservableList<Utilisateur> creer() {
		IObservableList<Utilisateur> listeMembres = new ObservableList<Utilisateur>();
		List<Utilisateur> membres= new ArrayList<>();
		membres.add(new Utilisateur(new Role(1, "Utilisateur", null), "mmoiroux", "mdp", "Moiroux", "Maxime", null));
		membres.add(new Utilisateur(new Role(1, "Utilisateur", null), "jcatrix", "mdp", "Catrix", "Julien", null));
		membres.add(new Utilisateur(new Role(1, "Utilisateur", null), "cdelrue", "mdp", "Delrue", "Cédric", null));
		membres.add(new Utilisateur(new Role(1, "Utilisateur", null), "knew", "mdp", "Nezzari", "Khalil", null));
		membres.add(new Utilisateur(new Role(1, "Utilisateur", null), "aypub", "mdp", "Nez", "Ayoub", null));

		listeMembres.setListe(membres);
		return listeMembres;
	}

}
