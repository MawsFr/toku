package fr.lille1.univ.coo.tp.utilisateur;

import java.util.List;

import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.IDiscussion;
import fr.lille1.univ.coo.tp.role.IRole;

@Table("utilisateur")
public interface IUtilisateur {
	public static final String ID = "id";
	public static final String PSEUDO = "id";
	public static final String NOM = "id";
	public static final String PRENOM = "id";
	public static final String MOT_DE_PASSE = "id";
	public static final String ROLE = "";
	public static final String AVATAR = "avatar";

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

	IObservableList<Amitie> getAmities();

	void setAmities(IObservableList<Amitie> amis);

	IObservableList<AffectationDiscussion> getAffectations();

	void setAffectations(IObservableList<AffectationDiscussion> discussions);
	
	List<IDiscussion> getDiscussion();
	

}