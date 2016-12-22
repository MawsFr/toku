package fr.lille1.univ.coo.tp.vue.composants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.composants.MontrerMDPAction;
import fr.lille1.univ.coo.tp.utils.Constantes;

public class JShowablePaswordTextFIeld extends JPanel {
	private static final long serialVersionUID = 1L;
	private JPasswordField password;
	
	public JShowablePaswordTextFIeld() {
		this.setLayout(new BorderLayout());
		password = new JPasswordField();
		password.setPreferredSize(new Dimension(150, 20));
		password.setMinimumSize(password.getPreferredSize());
		this.add(password, BorderLayout.CENTER);
		
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(Application.class.getResourceAsStream(Constantes.CHEMIN_VOIR_MDP)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JToggleButton montrer = new JToggleButton(icon);
		montrer.setFocusable(false);
		montrer.addActionListener(new MontrerMDPAction(password, password.getEchoChar()));
		montrer.setPreferredSize(new Dimension(30, 15));
		montrer.setMinimumSize(new Dimension(30, 15));
		this.add(montrer, BorderLayout.EAST);
	}

	public JPasswordField getPassword() {
		return password;
	}
}
