package nezzari.projects.vue;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import nezzari.projects.Application;

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
		Application application = Application.getInstance();
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
//				try {
//					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//						if ("Nimbus".equals(info.getName())) {
//							UIManager.setLookAndFeel(info.getClassName());
//							break;
//						}
//					}
//				} catch (Exception e) {}

				new FenetrePrincipale(application);
			}
		});
	}

}
