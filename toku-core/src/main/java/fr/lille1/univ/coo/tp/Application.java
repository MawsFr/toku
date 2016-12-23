package fr.lille1.univ.coo.tp;

/**
 * Cette classe stock la session de l'utilisateur
 * @author Maws
 *
 */
public class Application {
	private static Application instance;
	private Session session;
	
	private Application() {}
	
	public static Application getInstance() {
		if(instance == null) {
			instance = new Application();
		}
		return instance;
	}
	
	public void initier() {
		
	}
	
	public void deconnecter() {
		setSession(null);
	}
	
	public Session getSession() {
		return session;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	
}
