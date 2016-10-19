package nezzari.projects.controlleurs.composants;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import nezzari.projects.vue.composants.fenetre.Validable;

public class ValiderAction extends AbstractAction {
	
	public static final String NOM_PAR_DEFAUT = "Ok";
	
	private Validable fenetre;
	
	public ValiderAction(Validable fenetre) {
		this(fenetre, NOM_PAR_DEFAUT);
	}
	
	public ValiderAction(Validable fenetre, String nomBouton) {
		super(nomBouton);
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		fenetre.valider();
	}

}
