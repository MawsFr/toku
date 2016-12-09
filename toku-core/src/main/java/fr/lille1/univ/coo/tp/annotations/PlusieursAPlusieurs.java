/**
 * 
 */
package fr.lille1.univ.coo.tp.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
/**
 * Représente une relation n - n
 * 
 * @author Maws
 *
 */
public @interface PlusieursAPlusieurs {
	/**
	 * Nom de la table d'association
	 * 
	 * @return
	 */
	Class<?> table_assoc() default Object.class;

	/**
	 * Nom de la colonne représentant l'id des objets contenus
	 * d'association
	 * 
	 * @return
	 */
	String leurCle() default "";
	
	/**
	 * Nom de la colonne contenant l'id de l'objets contenant
	 * @return
	 */
	String nosCle() default "";
	
	/**
	 * Type des objets retournés
	 * @return
	 */
	Class<?> type() default Object.class;
}
