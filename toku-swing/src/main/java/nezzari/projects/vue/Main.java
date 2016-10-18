package nezzari.projects.vue;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

import nezzari.projects.Application;
import nezzari.projects.connexions.mysql.MYSQLConnexion;
import nezzari.projects.factory.DAOFactory;

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
		MYSQLConnexion c;
		try {
			c = MYSQLConnexion.getInstance();
			c.initier();
			DAOFactory.setConnexion(c.getBddConnexion());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
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

				FenetrePrincipale.getInstance().setApplication(application);
			}
		});
	}

}
