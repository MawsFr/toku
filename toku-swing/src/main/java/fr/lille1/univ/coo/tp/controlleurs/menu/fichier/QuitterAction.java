package fr.lille1.univ.coo.tp.controlleurs.menu.fichier;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.vue.BarreMenuPrincipale;

public class QuitterAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	
	public static QuitterAction instance;

	public static QuitterAction getInstance() {
		if(instance == null) {
			instance = new QuitterAction();
		}
		
		return instance;
	}
	
	private QuitterAction() {
		super(BarreMenuPrincipale.MENU_QUITTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}

}
