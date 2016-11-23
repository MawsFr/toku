package nezzari.projects.vue.composants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;

import nezzari.projects.Application;
import nezzari.projects.controlleurs.composants.MontrerMDPAction;
import nezzari.projects.utils.Constantes;
import nezzari.projects.vue.composants.focusable.FocusablePasswordField;

public class JShowablePaswordTextFIeld extends JPanel {
	private static final long serialVersionUID = 1L;
	private FocusablePasswordField password;
	private JToggleButton montrer;
	
	public JShowablePaswordTextFIeld() {
		this.setLayout(new BorderLayout());
		password = new FocusablePasswordField();
		password.setPreferredSize(new Dimension(150, 20));
		password.setMinimumSize(password.getPreferredSize());
		this.add(password, BorderLayout.CENTER);
		
		URL img = Application.class.getResource(Constantes.CHEMIN_VOIR_MDP);
		ImageIcon icon = new ImageIcon(img);
		
		montrer = new JToggleButton(icon);
		montrer.setFocusable(false);
		montrer.addActionListener(new MontrerMDPAction(password, password.getEchoChar()));
		montrer.setPreferredSize(new Dimension(30, 15));
		montrer.setMinimumSize(new Dimension(30, 15));
		this.add(montrer, BorderLayout.EAST);
	}
	
	public void cacher() {
		montrer.setSelected(false);
		password.setEchoChar('●');
	}
	
	public void montrer() {
		montrer.setSelected(true);
		password.setEchoChar((char) 0); 
	}

	public JPasswordField getPassword() {
		return password;
	}
}
