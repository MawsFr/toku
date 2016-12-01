package fr.lille1.univ.coo.tp.utilisateur.administrateur;

import fr.lille1.univ.coo.tp.service.ServiceException;

public interface IAdministrateurService {
	public void modifierPseudo(int idUtilisateur, String nouveauPseudo);
	public void modifierMotDePasse(int idUtilisateur, String nouveauMdp);
	public void modifierNom(int idUtilisateur, String nouveauNom);
	public void modifierPrenom(int idUtilisateur, String nouveauPrenom);
	public void validerCreationUtilisateur() throws ServiceException;
	public void validerSuppressionUtilisateur() throws ServiceException;


}
