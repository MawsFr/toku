package fr.lille1.univ.coo.tp.controlleurs.composants;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;

public class MontrerMDPAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	private JPasswordField motDePasse;
	private char echoChar;
	
	public MontrerMDPAction(JPasswordField motDePasse, char echoChar) {
		this.motDePasse = motDePasse;
		this.echoChar = echoChar;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JToggleButton bouton = (JToggleButton) arg0.getSource();
		motDePasse.setEchoChar(bouton.isSelected() ? (char) 0 : echoChar);
	}

}
