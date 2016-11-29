package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.role.Role;
import fr.lille1.univ.coo.tp.visiteur.Visiteur;

public interface IUtilisateur {

	int getId();

	void setId(int id);

	String getAvatar();

	void setAvatar(String avatar);

	String getPseudo();

	void setPseudo(String pseudo);

	String getNom();

	void setNom(String nom);

	String getPrenom();

	void setPrenom(String prenom);

	String getMotDePasse();

	void setMotDePasse(String motDePasse);

	IHumeur getHumeur();

	void setHumeur(IHumeur humeur);
	
	public Role getRole();

	void accept(Visiteur visitor) throws DomainException;

	IObservableList<Utilisateur> getAmis();

}