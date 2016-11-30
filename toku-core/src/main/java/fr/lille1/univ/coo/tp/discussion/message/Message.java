package fr.lille1.univ.coo.tp.discussion.message;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.discussion.IDiscussion;

@Table
public class Message {
	@Id
	private Integer id;
	
	@PlusieursAUn(sonType=Discussion.class, saCle="id_groupe", mappeePar="messages")
	private IDiscussion discussion;
	
	@Colonne
	private String texte;

	/**
	 * @return Le id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id Le nouveau id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return Le discussion
	 */
	public IDiscussion getDiscussion() {
		return discussion;
	}

	/**
	 * @param discussion Le nouveau discussion
	 */
	public void setDiscussion(IDiscussion discussion) {
		this.discussion = discussion;
	}

	/**
	 * @return Le texte
	 */
	public String getTexte() {
		return texte;
	}

	/**
	 * @param texte Le nouveau texte
	 */
	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	
	
}
