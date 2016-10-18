package nezzari.projects.role;

public enum Role {

	UTILISATEUR(1, "Utilisateur"), MODERATEUR(2, "Modérateur"), ADMINISTRATEUR(3, "Administrateur");
	
	private int id;
	private String description;
	
	private Role(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return description;
	}
}
