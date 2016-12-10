package fr.lille1.univ.coo.tp;

import java.io.Console;
import java.util.Scanner;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.connexions.Configuration;
import fr.lille1.univ.coo.tp.connexions.LocalMysqlConfiguration;
import fr.lille1.univ.coo.tp.persistance.DAOException;
import fr.lille1.univ.coo.tp.persistance.GestionnaireConnexion;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;

/**
 * Main class
 * 
 * @author Mustapha NEZZARI
 *
 */
public class Main {
	
	private static final String MDP = "root";

	private Main() {}

	/**
	 * Main function
	 * 
	 * @param args arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Console console = System.console();

		Configuration config = new Configuration();
		int choix = -1;
		do {
			System.out.println("Que voulez-vous faire ?");
			System.out.println("1. Se connecter à une nouvelle BDD (==> MYSQL <==)");
			System.out.println("2. Se connecter à la base de données WEBTP (necessite VPN)");
			System.out.println("3. Quitter le programme");
			choix = sc.nextInt();
			sc.nextLine();
		} while (choix < 1 || choix > 3);

		switch (choix) {
		case 1:
			System.out.println("Saisissez l'adresse de l'hote (ex : jdbc:mysql://webtp.fil.univ-lille1.fr)");
			config.setHote(sc.nextLine());
			System.out.println("Saisissez le nom de la bdd (ex : nezzari)");
			config.setBdd(sc.nextLine());
			System.out.println("Saisissez le pseudo (ex : root)");
			config.setPseudo(sc.nextLine());
			config.setNomDriver(Configuration.MYSQL_NOM_DRIVER);
			config.setParametres(Configuration.MYSQL_PARAMETRES);
			break;
		case 2:
//			config = new WebtpConfiguration();
			config = new LocalMysqlConfiguration();
			break;
		case 3:
			System.out.println("Au revoir !");
			System.exit(0);
			break;
		default:
			break;
		}
		System.out.println("Saisissez le mot de passe" + (choix == 2 ? " fourni " : " (ex : toor) ") + ":");

//		if (console == null) {
//			config.setMdp(new String(sc.nextLine()));
//		} else {
//			config.setMdp(new String(console.readPassword("")));
//		}
		config.setMdp(MDP);
		sc.close();

		try {
			GestionnaireConnexion.ouvrirConnexion(config);
		} catch (DAOException e) {
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
				
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				FenetrePrincipale.getInstance().setApplication(application);
			}
		});
	}

}
