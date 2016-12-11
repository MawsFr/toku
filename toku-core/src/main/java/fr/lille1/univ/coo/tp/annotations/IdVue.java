package fr.lille1.univ.coo.tp.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Cette annotation est a placer au dessus de chaque attribut qui correspond a
 * un id dans la base de données pour la table associée à la classe contenant le
 * champs
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface IdVue {
	/**
	 * @return Le nom de la colonne qui représente l'id de la table dans la BDD
	 *         sinon une chaîne vide (le nom de l'attribut représentant l'id
	 *         sera donc pris lors des traîtements)
	 */
	String value() default "";
}
