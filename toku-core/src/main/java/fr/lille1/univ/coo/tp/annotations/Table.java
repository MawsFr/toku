package fr.lille1.univ.coo.tp.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Cette annotation est a placer au dessus de chaque classe qui doit etre mappée
 * avec une table dans la BDD
 */
@Documented
@Retention(RUNTIME)
@Target(TYPE)
public @interface Table {
	/**
	 * Nom de la table dans la BDD
	 * 
	 * @return Le nom de la table sinon une chaine vide (le nom de la classe
	 *         sera pris pour le nom de la table)
	 */
	String value() default "";

}
