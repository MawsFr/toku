package fr.lille1.univ.coo.tp.utils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.Table;

/**
 * Cette classe rassemble des fonction utile à la manipulation des classe par la reflexion
 */
public class ReflectionUtils {
	/**
	 * Retourne le nom de l'attribut qui représente l'{@link Id} d'une classe
	 * 
	 * @param classe
	 *            La classe dont on veut l'{@link Id}
	 * @return Le champs qui correspond a l'{@link Id} de la classe sinon null
	 */
	public static String trouverId(Class<?> classe) {
		Field field = trouverChampsId(classe);
		if(field != null) {
			return field.getAnnotation(Id.class).value().isEmpty() ? field.getName() : field.getAnnotation(Id.class).value();
			
		}
		return null;
	}
	
	public static Field trouverChampsId(Class<?> classe) {
		for (Field field : classe.getDeclaredFields()) {
			if (field.isAnnotationPresent(Id.class))
				return field;
		}
		
		return null;
	}
	
	public static String nomTable(Class<?> classe) {
		String nom = classe.getAnnotation(Table.class).value().toLowerCase();
		if(nom.isEmpty()) {
			nom = classe.getSimpleName().toLowerCase();
		}

		return nom;
	}
	
	/**
	 * Retourne une liste des noms des attributs d'une classe.
	 * @param classe La classe
	 * @return Une liste des noms des champs déclarés dans la classe.
	 */
	public static Set<String> getChampsNoms(Class<?> classe) {
		Set<String> champs = new HashSet<>();
		for(Field champ : classe.getDeclaredFields()) {
			champs.add(champ.getName());
		}
		
		return champs;
	}

}
