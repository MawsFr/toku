package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.role.IRole;

@Table("utilisateur")
public interface IUtilisateur {

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#getId()
	 */
	Integer getId();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#setId(int)
	 */
	void setId(Integer id);
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#getAvatar()
	 */
	String getAvatar();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#setAvatar(java.lang.String)
	 */
	void setAvatar(String avatar);

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#getRole()
	 */
	IRole getRole();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#setRole(fr.lille1.univ.coo.tp.role.Role)
	 */
	void setRole(IRole role);

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#getPseudo()
	 */
	String getPseudo();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#setPseudo(java.lang.String)
	 */
	void setPseudo(String pseudo);
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#getNom()
	 */
	String getNom();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#setNom(java.lang.String)
	 */
	void setNom(String nom);

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#getPrenom()
	 */
	String getPrenom();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#setPrenom(java.lang.String)
	 */
	void setPrenom(String prenom);

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#getMotDePasse()
	 */
	String getMotDePasse();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IUtilisateur#setMotDePasse(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#setMotDePasse(java.lang.String)
	 */
	void setMotDePasse(String motDePasse);

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#getAmis()
	 */
	IObservableList<Utilisateur> getAmis();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#setAmis(fr.lille1.univ.coo.tp.utilisateur.IObservableList)
	 */
	void setAmis(IObservableList<Utilisateur> amis);

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#getDiscussions()
	 */
	IObservableList<Discussion> getDiscussions();

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IRole#setDiscussions(fr.lille1.univ.coo.tp.utilisateur.IObservableList)
	 */
	void setDiscussions(IObservableList<Discussion> discussions);


}