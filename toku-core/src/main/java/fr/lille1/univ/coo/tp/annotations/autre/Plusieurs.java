/**
 * 
 */
package fr.lille1.univ.coo.tp.annotations.autre;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
/**
 * @author Maws
 *
 */
public @interface Plusieurs {
	/**
	 * Nom de la table d'association
	 * 
	 * @return
	 */
	String table_assoc();

	/**
	 * Nom de la colonne représentant l'id des objets contenus
	 * d'association
	 * 
	 * @return
	 */
	String leurCle();
	
	/**
	 * Nom de la colonne contenant l'id de l'objets contenant
	 * @return
	 */
	String notreCle() default "";
	
	/**
	 * Type des objets retournés
	 * @return
	 */
	Class<?> type();
}
