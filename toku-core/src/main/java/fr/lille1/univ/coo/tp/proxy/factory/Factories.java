package fr.lille1.univ.coo.tp.proxy.factory;

import java.util.HashMap;
import java.util.Map;

import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;

/**
 * Cette classe contient une map de toutes les {@link Factory} permettant de
 * créer des objet à récupérer de façon paresseuse.
 */
public class Factories {
	private static Map<Class<? extends IObjetDomaine<?>>, Map<String, Class<? extends Factory<?>>>> factories;
	static {
		factories = new HashMap<>();
		factories.put(Utilisateur.class, new HashMap<>());
		
		factories.put(Discussion.class, new HashMap<>());
	}

	/**
	 * Retourne la {@link Factory} pour une classe et un attribut données.
	 * 
	 * @param classe
	 *            La classe qui contient l'attribut à remonter
	 * @param champs
	 *            Le nom de l'attribut à remonter
	 * @return La {@link Factory}
	 */
	public static Class<? extends Factory<?>> getFactory(Class<?> classe, String champs) {
		return factories.get(classe).get(champs);
	}

}
