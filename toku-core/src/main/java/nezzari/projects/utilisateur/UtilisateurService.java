package nezzari.projects.utilisateur;

import nezzari.projects.Application;
import nezzari.projects.factory.DAOFactory;
import nezzari.projects.service.Service;
import nezzari.projects.validateur.ValidationException;
import nezzari.projects.validateur.Valideur;

public class UtilisateurService extends Service<Utilisateur> implements IUtilisateurService {
	private static IUtilisateurService instance;
	
	protected UtilisateurService() {}
	
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
		utilisateur.setMotDePasse(motDePasse);
		try {
			Valideur.getUtilisateurValideur().valider(utilisateur);
			utilisateur = DAOFactory.getUtilisateurDAO().rechercher(utilisateur);
		} catch (ValidationException | DAOException e) {
			throw new ServiceException(e);
		}
		return utilisateur;
	}
	
	@Override
	public void deconnecter() {
		Application.getInstance().getSession().setUtilisateur(null);
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
