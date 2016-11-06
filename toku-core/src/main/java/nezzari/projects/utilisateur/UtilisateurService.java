package nezzari.projects.utilisateur;

import nezzari.projects.Application;
import nezzari.projects.Session;
import nezzari.projects.cryptage.CryptageException;
import nezzari.projects.cryptage.CrypteurMD5;
import nezzari.projects.factory.DAOException;
import nezzari.projects.factory.DAOFactory;
import nezzari.projects.role.Role;
import nezzari.projects.service.Service;
import nezzari.projects.service.ServiceException;
import nezzari.projects.validateur.ValidationException;
import nezzari.projects.validateur.Valideur;

public class UtilisateurService extends Service<Utilisateur> implements IUtilisateurService {
	private static IUtilisateurService instance;
	private IUtilisateurDAO dao;
	
	protected UtilisateurService() {
		this.dao = DAOFactory.getUtilisateurDAO();
	}
	
	public static IUtilisateurService getInstance() {
		if(instance == null) {
			instance = new UtilisateurService();
		}
		
		return instance;
	}

	@Override
	public Utilisateur connecter(String pseudo, String motDePasse) throws ServiceException, ValidationException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setPseudo(pseudo);
		try {
			utilisateur.setMotDePasse(new CrypteurMD5().crypter(motDePasse));
			Valideur.getUtilisateurValideur().valider(utilisateur);
			utilisateur = dao.rechercher(utilisateur);
			Session session = new Session();
			session.setUtilisateur(utilisateur);
			Application.getInstance().setSession(session);
		} catch (ValidationException | DAOException | CryptageException e) {
			throw new ServiceException(e);
		}
		return utilisateur;
	}
	
	@Override
	public void deconnecter() {
		Application.getInstance().setSession(null);
	}
	
	@Override
	public boolean estAdministrateur(Utilisateur utilisateur) throws ServiceException {
		Role role;
		try {
			role = Role.values()[dao.getRole(utilisateur) - 1];
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return role == Role.ADMINISTRATEUR;
	}

	@Override
	public void modifierMotDePasse(int idUtilisateur, String nouveauMdp) {

	}

	@Override
	public void modifierNom(int idUtilisateur, String nouveauNom) {
		
	}

	@Override
	public void modifierPrenom(int idUtilisateur, String nouveauPrenom) {
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
