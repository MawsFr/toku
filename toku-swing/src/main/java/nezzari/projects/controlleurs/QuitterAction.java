package nezzari.projects.controlleurs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import nezzari.projects.vue.BarreMenuPrincipale;

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
