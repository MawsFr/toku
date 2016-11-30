package fr.lille1.univ.coo.tp.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Cette annotation est a placer au dessus d'un attribut qui représente une
 * liaison 1 - n. Cette annotation se place dans la classe qui représente le n.
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface PlusieursAUn {
	/**
	 * @return Le nom de la colonne qui represente l'id de la partie 1 dans la
	 *         relation 1 - n
	 */
	Class<?> sonType();

	String saCle();
	
	String mappeePar() default "";

}
