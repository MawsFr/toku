package nezzari.projects.role;

public enum Role {

	UTILISATEUR(1), MODERATEUR(2), ADMINISTRATEUR(3);
	
	private int id;
	
	private Role(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
