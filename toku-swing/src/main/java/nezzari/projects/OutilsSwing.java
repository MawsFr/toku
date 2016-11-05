package nezzari.projects;

import java.awt.Dimension;

import javax.swing.AbstractAction;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.junit.runners.ParentRunner;

import nezzari.projects.controlleurs.connexion.DeconnexionAction;

public class OutilsSwing {
	/*
	 * Menu
	 */
	
	public static JMenu creerMenu(String nom, JMenuBar barreMenu) {
		return barreMenu.add(new JMenu(nom));
	}
	
	public static JMenu creerMenuCache(String nom, JMenuBar barreMenu) {
		JMenu menu = new JMenu(nom);
		barreMenu.add(menu);
		menu.setVisible(false);
		return menu;
	}
	
	public static JMenu creerMenu(AbstractAction action, JMenuBar barreMenu) {
		return barreMenu.add(new JMenu(action));
	}
	
	public static JMenuItem creerSousMenu(JMenu parent, AbstractAction action) {
		return parent.add(new JMenuItem(action));
	}
	
	public static JMenuItem creerSousMenuDesactive(JMenu parent, AbstractAction action) {
		JMenuItem menu = new JMenuItem(action);
		parent.add(menu);
		menu.setEnabled(false);
		return menu;
	}
	
	public static JCheckBoxMenuItem creerSousMenuCochable(JMenu parent, AbstractAction action) {
		JCheckBoxMenuItem cbmenu = new JCheckBoxMenuItem(action);
		parent.add(cbmenu);
		return cbmenu;
	}
	
	public static void ajouterBarreMenu(JFrame fenetre, JMenuBar barreMenu) {
		fenetre.setJMenuBar(barreMenu);
	}
	
	// Tailles
	public static void setTaille(int width, int height, JComponent... components) {
		for(JComponent component : components) {
			component.setPreferredSize(new Dimension(width, height));
			component.setMinimumSize(component.getPreferredSize());
		}
	}


}
