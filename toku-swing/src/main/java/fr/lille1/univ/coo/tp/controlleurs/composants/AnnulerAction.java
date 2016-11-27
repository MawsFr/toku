package fr.lille1.univ.coo.tp.controlleurs.composants;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.vue.composants.fenetre.Annulable;
import fr.lille1.univ.coo.tp.vue.composants.fenetre.Validable;

public class AnnulerAction extends AbstractAction {
	
	public static final String NOM_PAR_DEFAUT = "Annuler";
	
	private Annulable fenetre;
	
	public AnnulerAction(Annulable fenetre) {
		this(fenetre, NOM_PAR_DEFAUT);
	}
	
	public AnnulerAction(Annulable fenetre, String nomBouton) {
		super(nomBouton);
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		fenetre.annuler();
	}

}
