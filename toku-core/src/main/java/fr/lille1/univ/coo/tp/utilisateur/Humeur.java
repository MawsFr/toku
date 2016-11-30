package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.annotations.UnAUn;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.visiteur.Visiteur;

@Table
public class Humeur extends ObjetDomaine implements IHumeur {
	
	@Id
	private Integer id;

	@UnAUn(sonType=Utilisateur.class)
	private IUtilisateur utilisateur;
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.utilisateur.IHumeur#accept(fr.lille1.univ.coo.tp.visiteur.Visiteur)
	 */
	@Override
	public void accept(Visiteur visitor) throws DomainException {
		visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.utilisateur.getNom();
	}

}
