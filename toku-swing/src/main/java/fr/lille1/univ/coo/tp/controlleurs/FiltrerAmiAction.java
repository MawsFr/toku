package fr.lille1.univ.coo.tp.controlleurs;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;

import fr.lille1.univ.coo.tp.controlleurs.composants.FiltrerAction;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.filtre.ALeNom;
import fr.lille1.univ.coo.tp.filtre.ALePrenom;
import fr.lille1.univ.coo.tp.filtre.ALePseudo;
import fr.lille1.univ.coo.tp.filtre.Filtre;
import fr.lille1.univ.coo.tp.filtre.OUFiltre;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;
import fr.lille1.univ.coo.tp.vue.listes.JFiltrableList;

public class FiltrerAmiAction extends FiltrerAction<Amitie> {
	public FiltrerAmiAction(JFiltrableList<Amitie> liste) {
		super(liste);
	}

	@Override
	public void notifier(DocumentEvent e) {
		String texte = this.liste.getTexte().getText();
		if(texte.isEmpty()) {
			setFiltre(null);
			if(liste.getLeModel().getFiltreDeBase() != null) {
				setFiltre(liste.getLeModel().getFiltreDeBase());
			}
		} else {
			List<Filtre> criteres = new ArrayList<>();
			ALePseudo aLePseudo = new ALePseudo(texte);
			ALeNom aLeNom = new ALeNom(texte);
			ALePrenom aLePrenom = new ALePrenom(texte);
			
			criteres.add(aLePseudo);
			criteres.add(aLeNom);
			criteres.add(aLePrenom);
			
			OUFiltre et = new OUFiltre(criteres);
			setFiltre(et);
		}
		try {
			filtrer();
		} catch (DomainException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(FenetrePrincipale.getInstance().getFenetre(), "Erreur lors du filtrage : " + e1.getMessage(), "Erreur", JOptionPane.ERROR);
		}
		
	}
}
