package fr.lille1.univ.coo.tp.vue.utilisateurs;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class FenetreRechercheAmis extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreRechercheAmis frame = new FenetreRechercheAmis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreRechercheAmis() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
