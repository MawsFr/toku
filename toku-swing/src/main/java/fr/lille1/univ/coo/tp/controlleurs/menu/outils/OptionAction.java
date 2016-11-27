package fr.lille1.univ.coo.tp.controlleurs.menu.outils;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.lille1.univ.coo.tp.vue.BarreMenuPrincipale;

public class OptionAction extends AbstractAction {
	
	public static OptionAction instance;
	
	private OptionAction() {
		super(BarreMenuPrincipale.MENU_OPTIONS);
	}

	public static OptionAction getInstance() {
		if(instance == null) {
			instance = new OptionAction();
		}
		
		return instance;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
}
