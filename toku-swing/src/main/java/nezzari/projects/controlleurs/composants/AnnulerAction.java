package nezzari.projects.controlleurs.composants;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import nezzari.projects.vue.composants.fenetre.Annulable;
import nezzari.projects.vue.composants.fenetre.Validable;

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
