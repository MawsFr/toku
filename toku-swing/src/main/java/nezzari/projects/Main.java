package nezzari.projects;

import javax.swing.SwingUtilities;

/**
 * Main class
 * 
 * @author Mustapha NEZZARI
 *
 */
public class Main {
	
	private Main() {}
	
	/**
	 * Main function
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FenetrePrincipale();
				
			}
		});
	}
	
}
