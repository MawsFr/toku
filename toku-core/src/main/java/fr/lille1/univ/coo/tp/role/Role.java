package fr.lille1.univ.coo.tp.role;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.domain.ObjetDomaine;
import fr.lille1.univ.coo.tp.filtre.Visiteur;

@Table
public class Role extends ObjetDomaine<Integer> implements IRole {
	public static final int ROLE_UTILISATEUR = 1;
	public static final int ROLE_ADMINISTRATEUR = 2;
	
	
	@Id
	private Integer id;
	
	@Colonne
	private String nom;
	
	public Role() {
	}
	
	public Role(Integer id, String nom, Role parent) {
		this.id = id;
		this.nom = nom;
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#getNom()
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#setNom(java.lang.String)
	 */
	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}
	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see fr.lille1.univ.coo.tp.role.IRole#toString()
	 */
	@Override
	public String toString() {
		return nom;
	}

	@Override
	public void accept(Visiteur<?> visitor) throws DomainException {
		visitor.visit(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Role)) {
			return false;
		}
		Role other = (Role) obj;
		if (id == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!id.equals(other.getId())) {
			return false;
		}
		if (nom == null) {
			if (other.getNom() != null) {
				return false;
			}
		} else if (!nom.equals(other.getNom())) {
			return false;
		}
		return true;
	}
	
	
}
