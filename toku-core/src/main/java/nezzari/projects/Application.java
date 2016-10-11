package nezzari.projects;

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
	
	public Session getSession() {
		return session;
	}
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	
}
