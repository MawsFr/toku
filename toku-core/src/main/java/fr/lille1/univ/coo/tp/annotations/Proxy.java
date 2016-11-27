package fr.lille1.univ.coo.tp.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import fr.lille1.univ.coo.tp.persistance.proxy.factory.Factories;
import fr.lille1.univ.coo.tp.persistance.proxy.factory.Factory;

/**
 * Cette annotation est a placer au dessus de chaque attribut qui correspond a
 * une colonne ou une liste d'objet à récupérer grâce à la remontée paresseuse.
 * Un proxy sera alors créé pour le champs.
 * 
 * @see Factories
 * @see Factory 
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface Proxy {
	/**
	 * @return La clé de l'attribut à proxifier qui sera utilisé pour récupérer
	 *         la {@link Factory} dans {@link Factories}
	 */
	String value() default "";
}
