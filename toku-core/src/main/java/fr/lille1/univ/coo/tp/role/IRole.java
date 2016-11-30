package fr.lille1.univ.coo.tp.role;

import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.utilisateur.IHumeur;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.visiteur.Visiteur;

public interface IRole {

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getId()
	 */
	Integer getId();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setId(int)
	 */
	void setId(Integer id);

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getAvatar()
	 */
	String getAvatar();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setAvatar(java.lang.String)
	 */
	void setAvatar(String avatar);

	Role getRole();

	void setRole(Role role);

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getPseudo()
	 */
	String getPseudo();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setPseudo(java.lang.String)
	 */
	void setPseudo(String pseudo);

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getNom()
	 */
	String getNom();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setNom(java.lang.String)
	 */
	void setNom(String nom);

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getPrenom()
	 */
	String getPrenom();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setPrenom(java.lang.String)
	 */
	void setPrenom(String prenom);

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getMotDePasse()
	 */
	String getMotDePasse();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setMotDePasse(java.lang.String)
	 */
	void setMotDePasse(String motDePasse);

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#getHumeur()
	 */
	IHumeur getHumeur();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setHumeur(fr.lille1.univ.coo.tp.utilisateur.IHumeur)
	 */
	void setHumeur(IHumeur humeur);

	IObservableList<Utilisateur> getAmis();

	void setAmis(IObservableList<Utilisateur> amis);

	/**
	 * @return Le discussions
	 */
	IObservableList<Discussion> getDiscussions();

	/**
	 * @param discussions Le nouveau discussions
	 */
	void setDiscussions(IObservableList<Discussion> discussions);

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#accept(fr.lille1.univ.coo.tp.visiteur.Visiteur)
	 */
	void accept(Visiteur visitor) throws DomainException;

}