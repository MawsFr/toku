package nezzari.projects.controlleurs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JCheckBoxMenuItem;

import nezzari.projects.vue.BarreMenuPrincipale;
import nezzari.projects.vue.FenetrePrincipale;

public class ToujoursVisibleAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	public static ToujoursVisibleAction instance;

	public static ToujoursVisibleAction getInstance() {
		if(instance == null) {
			instance = new ToujoursVisibleAction();
		}
		
		return instance;
	}
	
	private ToujoursVisibleAction() {
		super(BarreMenuPrincipale.MENU_TOUJOURS_VISIBLE);
	}

	@Override
	public void actionPerformed(final ActionEvent arg0) {
		JCheckBoxMenuItem cbmenu = (JCheckBoxMenuItem) arg0.getSource();
		FenetrePrincipale.getInstance().getFenetre().setAlwaysOnTop(cbmenu.isSelected());
		
	}

}
