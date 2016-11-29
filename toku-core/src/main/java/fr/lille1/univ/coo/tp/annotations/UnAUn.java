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
 * Cette annotation permet de creer des proxy dans une relation 1 - 1
 */
public @interface UnAUn {

	/**
	 * Nom de la colonne contenant la clé pour aller chercher l'objet
	 * @return
	 */
	String cle() default "";
	
	/**
	 * La classe (et non pas l'interface) de l'objet à retourner
	 * @return
	 */
	Class<?> type();
	
}
