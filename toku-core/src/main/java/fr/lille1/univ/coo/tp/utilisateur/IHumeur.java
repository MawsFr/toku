package fr.lille1.univ.coo.tp.utilisateur;

import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.visiteur.Visiteur;

@Table("humeur")
public interface IHumeur {

	void accept(Visiteur visitor) throws DomainException;

}