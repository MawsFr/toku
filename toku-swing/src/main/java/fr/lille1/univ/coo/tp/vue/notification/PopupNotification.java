package fr.lille1.univ.coo.tp.vue.notification;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import fr.lille1.univ.coo.tp.vue.listes.JAffectationList;
import fr.lille1.univ.coo.tp.vue.listes.JAmisList;

public class PopupNotification extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Container c;
	private JTabbedPane onglets;
	private JAmisList notifAmi;
	private JAffectationList notifDiscussion;
	
	
	public PopupNotification() {
		this.c = getContentPane();
		
		
		setSize(100, 100);
	}
}
