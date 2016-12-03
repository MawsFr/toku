package fr.lille1.univ.coo.tp.utilisateur.administrateur;

import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

public interface IAdministrateurService {
	public void modifierPseudo(int idUtilisateur, String nouveauPseudo);
	public void modifierMotDePasse(int idUtilisateur, String nouveauMdp);
	public void modifierNom(int idUtilisateur, String nouveauNom);
	public void modifierPrenom(int idUtilisateur, String nouveauPrenom);
	public Utilisateur creerUtilisateur(String pseudo, String nom, String prenom, Role role, String motDePasse) throws ServiceException;
	public void validerChangements() throws ServiceException;


}
