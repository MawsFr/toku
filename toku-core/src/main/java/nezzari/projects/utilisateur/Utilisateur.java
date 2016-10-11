package nezzari.projects.utilisateur;

import nezzari.projects.Application;

/**
 * Cette classe represente un utilisateur
 * @author Mustapha NEZZARI
 *
 */
public class Utilisateur implements RoleUtilisateur {
	private int id;
	private int role;
	private String pseudo;
	private String nom;
	private String prenom;
	private String motDePasse;
	
	public Utilisateur() {}
	
	public Utilisateur(int role, String pseudo, String motDePasse, String nom, String prenom) {
		this.role = role;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRole() {
		return role;
	}
	
	public void setRole(int role) {
		this.role = role;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	// Deplacer toutes ces fonctions dans le service des utilisateurs
	
	@Override
	public void seConnecter() {
		Application.getInstance().getSession().setUtilisateur(this);
	}

	@Override
	public void seDeconnecter() {
		Application.getInstance().getSession().setUtilisateur(null);
	}

	@Override
	public void modifierMotDePasse(String nouveauMdp) {
			
	}

	@Override
	public void modifierNom(String nouveauNom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierPrenom(String nouveauPrenom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demanderEnAmi(int idDestinataire) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accepterDemandeAmi(int idDemande) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refuserDemandeAmi(int idDemande) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerAmi(int idAmi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creerDiscussion(String nom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creerDiscussionPrive(int idAmi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void envoyerMessage(int idGroupe, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void envoyerMessagePrive(int idGroupe, int idDestinataire, String message, boolean accuseReception,
			int expiration, boolean prioritaire, boolean chiffre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quitterGroupe(int idGroupe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lireMessage(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lireMessagePrive(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recevoirNotification(String texte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerNotification(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterCentreInteret(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void creerCentreInteret(String nom) {
		// TODO Auto-generated method stub
		
	}



	
	
}
