package fr.lille1.univ.coo.tp.discussion;

import java.util.List;

import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.message.Message;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.IUtilisateur;

@Table(nom="discussion")
public interface IDiscussion extends IObjetDomaine<Integer>{

	/**
	 * @return Le id
	 */
	Integer getId();

	/**
	 * @param id Le nouveau id
	 */
	void setId(Integer id);

	/**
	 * @return Le nom
	 */
	String getNom();

	/**
	 * @param nom Le nouveau nom
	 */
	void setNom(String nom);

	/**
	 * @return Le moderateur
	 */
	IUtilisateur getModerateur();

	/**
	 * @param moderateur Le nouveau moderateur
	 */
	void setModerateur(IUtilisateur moderateur);

	/**
	 * @return Le membres
	 */
	IObservableList<AffectationDiscussion> getAffectations();

	/**
	 * @param membres Le nouveau membres
	 */
	void setAffectations(IObservableList<AffectationDiscussion> membres);
	
	List<IUtilisateur> getMembres();

	Integer getLeType();

	void setLeType(Integer leType);

	IObservableList<Message> getMessages();

	void setMessages(IObservableList<Message> messages);
}