package fr.lille1.univ.coo.tp.utils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Table;
import fr.lille1.univ.coo.tp.annotations.UnAPlusieurs;
import fr.lille1.univ.coo.tp.annotations.UnAUn;

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
		String nom = classe.getAnnotation(Table.class).value();
		if(nom.isEmpty()) {
			nom = classe.getSimpleName();
		}

		return nom.toLowerCase();
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
	
	public static Field getChampParColonne(Class<?> classe, String nomColonne) {
		for(Field field : classe.getDeclaredFields()) {
			if(getNomColonne(field).equals(nomColonne)) {
				return field;
			}
		}
		return null;
	}
	
	/**
	 * Renvoie les nom des colonnes de la table
	 * @param classe La classe mappee a la table
	 * @return La liste des colonnes
	 */
	public static Set<String> getNomsColonnes(Class<?> classe) {
		Set<String> champs = new HashSet<>();
		for(Field champ : classe.getDeclaredFields()) {
			if(champ.isAnnotationPresent(PlusieursAUn.class)) {
				continue;
			}
			champs.add(getNomColonne(champ));
		}
		return champs;
	}
	
	/**
	 * Renvoir le nom de la colonne correspondant a l'attribut
	 * @param champ L'attribut
	 * @return Le nom de la colonne
	 */
	public static String getNomColonne(Field champ) {
		if(champ.isAnnotationPresent(Id.class)) {
			if(!champ.getAnnotation(Id.class).value().isEmpty()) {
				return champ.getAnnotation(Id.class).value();
			}
		} else if(champ.isAnnotationPresent(Colonne.class)) {
			if(!champ.getAnnotation(Colonne.class).value().isEmpty()) {
				return champ.getAnnotation(Colonne.class).value();
			}
		} else if(champ.isAnnotationPresent(UnAUn.class)) {
			if(!champ.getAnnotation(UnAUn.class).saCle().isEmpty()) {
				return champ.getAnnotation(UnAUn.class).saCle();
			}
		} else if(champ.isAnnotationPresent(PlusieursAUn.class)) {
			if(!champ.getAnnotation(PlusieursAUn.class).saCle().isEmpty()) {
				return champ.getAnnotation(PlusieursAUn.class).saCle();
			}
		} else if(champ.isAnnotationPresent(UnAPlusieurs.class)) {
			if(!champ.getAnnotation(UnAPlusieurs.class).maCle().isEmpty()) {
				return champ.getAnnotation(UnAPlusieurs.class).maCle();
			}
		} 
		return champ.getName();
	}


}
