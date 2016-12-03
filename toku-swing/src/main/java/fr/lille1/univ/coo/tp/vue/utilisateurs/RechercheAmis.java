package fr.lille1.univ.coo.tp.vue.utilisateurs;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public class RechercheAmis extends JFrame {

	private JPanel contentPane;
	private List<Utilisateur> utilisateurs;

	/**
	 * Create the frame.
	 */
	public RechercheAmis(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
