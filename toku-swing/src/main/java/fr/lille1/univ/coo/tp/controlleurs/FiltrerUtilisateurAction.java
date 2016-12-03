package fr.lille1.univ.coo.tp.controlleurs;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.DocumentEvent;

import fr.lille1.univ.coo.tp.controlleurs.composants.FiltrerAction;
import fr.lille1.univ.coo.tp.filtre.ALeNom;
import fr.lille1.univ.coo.tp.filtre.ALePrenom;
import fr.lille1.univ.coo.tp.filtre.ALePseudo;
import fr.lille1.univ.coo.tp.filtre.Filtre;
import fr.lille1.univ.coo.tp.filtre.OUFiltre;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JFiltrableList;

public class FiltrerUtilisateurAction extends FiltrerAction<Utilisateur> {
	public FiltrerUtilisateurAction(JFiltrableList<Utilisateur> liste) {
		super(liste);
	}

	@Override
	public void notifier(DocumentEvent e) {
		String texte = this.liste.getTexte().getText();
		if(texte.isEmpty()) {
			setFiltre(null);
		} else {
			List<Filtre<Utilisateur>> criteres = new ArrayList<>();
			ALePseudo aLePseudo = new ALePseudo(texte);
			ALeNom aLeNom = new ALeNom(texte);
			ALePrenom aLePrenom = new ALePrenom(texte);
			
			criteres.add(aLePseudo);
			criteres.add(aLeNom);
			criteres.add(aLePrenom);
			
			OUFiltre<Utilisateur> et = new OUFiltre<>(criteres);
			setFiltre(et);
		}
		filtrer();
		
	}
}
