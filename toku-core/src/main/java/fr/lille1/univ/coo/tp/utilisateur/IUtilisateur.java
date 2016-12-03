package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.role.IRole;

@Table("utilisateur")
public interface IUtilisateur {

	Integer getId();

	void setId(Integer id);

	String getAvatar();

	void setAvatar(String avatar);

	IRole getRole();

	void setRole(IRole role);

	String getPseudo();

	void setPseudo(String pseudo);

	String getNom();

	void setNom(String nom);

	String getPrenom();

	void setPrenom(String prenom);

	String getMotDePasse();

	void setMotDePasse(String motDePasse);

	IObservableList<Utilisateur> getAmis();

	void setAmis(IObservableList<Utilisateur> amis);

	IObservableList<Discussion> getDiscussions();

	void setDiscussions(IObservableList<Discussion> discussions);

}