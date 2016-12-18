package fr.lille1.univ.coo.tp.controlleurs.composants;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.vue.composants.fenetre.Fermable;

public class FermerAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	
	public static final String NOM_PAR_DEFAUT = "Fermer";
	
	private Fermable fenetre;
	
	public FermerAction(Fermable fenetre) {
		this(fenetre, NOM_PAR_DEFAUT);
	}
	
	public FermerAction(Fermable fenetre, String nomBouton) {
		super(nomBouton);
		this.fenetre = fenetre;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		fenetre.fermer();
	}

}
