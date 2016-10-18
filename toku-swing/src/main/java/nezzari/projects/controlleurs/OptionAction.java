package nezzari.projects.controlleurs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import nezzari.projects.vue.BarreMenuPrincipale;

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
