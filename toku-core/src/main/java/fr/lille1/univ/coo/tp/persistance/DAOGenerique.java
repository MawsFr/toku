package fr.lille1.univ.coo.tp.persistance;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.lille1.univ.coo.tp.annotations.Colonne;
import fr.lille1.univ.coo.tp.annotations.Id;
import fr.lille1.univ.coo.tp.annotations.PlusieursAPlusieurs;
import fr.lille1.univ.coo.tp.annotations.PlusieursAUn;
import fr.lille1.univ.coo.tp.annotations.Transient;
import fr.lille1.univ.coo.tp.annotations.UnAPlusieurs;
import fr.lille1.univ.coo.tp.annotations.UnAUn;
import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
import fr.lille1.univ.coo.tp.persistance.proxy.VirtualProxyBuilder;
import fr.lille1.univ.coo.tp.persistance.proxy.factory.Factories;
import fr.lille1.univ.coo.tp.persistance.proxy.factory.Factory;
import fr.lille1.univ.coo.tp.persistance.proxy.factory.PlusieursAPlusieursFactory;
import fr.lille1.univ.coo.tp.persistance.proxy.factory.PlusieursAUnFactory;
import fr.lille1.univ.coo.tp.persistance.proxy.factory.UnAPlusieursFactory;
import fr.lille1.univ.coo.tp.persistance.proxy.factory.UnAUnFactory;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utils.Log;
import fr.lille1.univ.coo.tp.utils.ReflectionUtils;

/**
 * Cette classe permet de rendre persistant des objets dans la BDD
 * 
 * @param <T>
 *            Le type d'objet à rendre persistant
 */
public class DAOGenerique<T extends IObjetDomaine> {
	public static final String TABLE_PREFIXE = "projet_";

	private Connection connexion;

	private Class<?> classe;
	private RequeteBuilder rb;
	private static References references;

	/**
	 * Constructeur prenant en parametre la classe de l'objet
	 * 
	 * @param classe
	 *            La classe
	 */
	public DAOGenerique(final Class<?> classe) {
		this.classe = classe;
		this.connexion = GestionnaireConnexion.getConnexion();
		this.rb = new RequeteBuilder(classe);
		references = References.getInstance();
	}

	/**
	 * Crée un objet dans la bdd
	 * 
	 * @param objet
	 *            l'objet a creer
	 * @return L'objet créé avec l'id genere
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws DAOException
	 */
	public T creer(final T objet) throws DAOException {
		PreparedStatement ps = null;
		try {
			boolean accessible = false;

			List<String> champsListe = new ArrayList<>();
			Map<String, Object> valeurs = new HashMap<>();
			for (Field field : classe.getDeclaredFields()) {
				String champ = ReflectionUtils.getNomColonne(field);
				Class<?> type = null;
				accessible = field.isAccessible();
				field.setAccessible(true);
				if (field.isAnnotationPresent(Colonne.class) || field.isAnnotationPresent(Id.class)) {
					valeurs.put(champ, field.get(objet));
					champsListe.add(champ);
				} else if (field.isAnnotationPresent(UnAUn.class) || field.isAnnotationPresent(PlusieursAUn.class)) {
					if (field.isAnnotationPresent(UnAUn.class)) {
						type = field.get(objet).getClass();
					} else if (field.isAnnotationPresent(PlusieursAUn.class)) {
						type = field.getAnnotation(PlusieursAUn.class).sonType();

					}
					Field idField = ReflectionUtils.trouverChampsId(type);
					idField.setAccessible(true);
					Object o = idField.get(field.get(objet));
					if (o != null) {
						valeurs.put(champ, o);
					}
					champsListe.add(champ);
				} else if (field.isAnnotationPresent(UnAPlusieurs.class)) {
					UnAPlusieurs unAPlusieurs = field.getAnnotation(UnAPlusieurs.class);
					Class<?> leurType = unAPlusieurs.leurType();
					String maCle = unAPlusieurs.maCle();

					Factory<IObservableList<T>> unAPlusieursFactory = new UnAPlusieursFactory<T>(leurType,
							maCle, objet.getId());
					creerProxyList(objet, field, unAPlusieursFactory);
				} else if (field.isAnnotationPresent(PlusieursAPlusieurs.class)) {
					PlusieursAPlusieurs plusieursAPlusieurs = field
							.getAnnotation(PlusieursAPlusieurs.class);

					Class<?> tableAssociation = plusieursAPlusieurs.table_assoc();
					String leurColonne = plusieursAPlusieurs.leurCle();
					Class<?> leurType = plusieursAPlusieurs.type();
					String leurId = ReflectionUtils.trouverId(leurType);

					String notreColonne = plusieursAPlusieurs.notreCle();

					Factory<IObservableList<T>> plusieursAPlusieursFactory = new PlusieursAPlusieursFactory<T>(tableAssociation, leurColonne, notreColonne, leurType,
							leurId, objet.getId());
					creerProxyList(objet, field, plusieursAPlusieursFactory);
				}
				field.setAccessible(accessible);
			}
			ps = creerRequetePreparee(connexion, rb.insertion(champsListe), true, champsListe, valeurs, null, null);
			System.out.println(ps);
			connexion.setAutoCommit(false);
			ps.executeUpdate();
			ResultSet resultat = null;
			resultat = ps.getGeneratedKeys();
			resultat.next();
			Integer id = resultat.getInt(1);
			Field idField = ReflectionUtils.trouverChampsId(classe);
			accessible = idField.isAccessible();
			idField.setAccessible(true);
			idField.set(objet, id);
			idField.setAccessible(accessible);
			connexion.commit();
			references.enregistrer(classe, id, objet);
		} catch (SQLException e) {
			try {
				connexion.rollback();
			} catch (SQLException e1) {
				throw new DAOException(e1);
			}
			throw new DAOException(e);
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				connexion.setAutoCommit(true);
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return objet;
	}

	/**
	 * Supprime l"objet d'id donné
	 * 
	 * @param id
	 *            l'id de l'objet a supprimer dans la BDD
	 * @throws DAOException
	 */
	public void supprimer(final Integer id) throws DAOException {
		PreparedStatement ps = null;
		try {
			String idChamp = ReflectionUtils.trouverId(classe);
			List<String> champsListe = new ArrayList<>();
			champsListe.add(idChamp);
			Map<String, Object> valeurs = new HashMap<>();
			valeurs.put(idChamp, id);
			ps = creerRequetePreparee(connexion, rb.suppression(champsListe), false, null, null, champsListe, valeurs);
			connexion.setAutoCommit(false);
			ps.executeUpdate();
			connexion.commit();
			references.supprimer(classe, id);
		} catch (SQLException e) {
			try {
				connexion.rollback();
			} catch (SQLException e1) {
				throw new DAOException(e1);
			}
			throw new DAOException(e);
		} catch (SecurityException | IllegalArgumentException e) {
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				connexion.setAutoCommit(true);
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
	}

	/**
	 * Met a jour un objet en base
	 * 
	 * @param objet
	 *            L'objet
	 * @throws DAOException
	 */
	public void modifier(final T objet) throws DAOException {
		modifier(objet, ReflectionUtils.getChampsNoms(classe));
	}

	/**
	 * Met a jour les champs d'un objet
	 * 
	 * @param objet
	 *            L'objet
	 * @param champs
	 *            Les champs a mettre a jour
	 * @throws DAOException
	 */
	public void modifier(final T objet, Set<String> champs) throws DAOException {
		try {
			Map<String, Object> clauseSet = new HashMap<>();
			Map<String, Object> clauseWhere = new HashMap<>();

			for (String champ : champs) {
				Field field = classe.getDeclaredField(champ);
				boolean accessible = field.isAccessible();
				field.setAccessible(true);
				if (field.isAnnotationPresent(Colonne.class)) {
					clauseSet.put(ReflectionUtils.getNomColonne(field), field.get(objet));
				}
				field.setAccessible(accessible);
			}

			Field idChamps = ReflectionUtils.trouverChampsId(classe);
			boolean accessible = idChamps.isAccessible();
			idChamps.setAccessible(true);
			clauseWhere.put(idChamps.getName(), idChamps.get(objet));
			idChamps.setAccessible(accessible);

			modifier(clauseSet, clauseWhere);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
			throw new DAOException(e);
		} catch (DAOException e) {
			throw e;
		}
	}

	/**
	 * Modifie un objet par rapport a une clause set et une clause where
	 * 
	 * @param clauseSet
	 *            Les champs a modifier (champs | nouvelle valeur)
	 * @param clauseWhere
	 *            Les conditions de la clause where
	 * @throws DAOException
	 */
	private void modifier(final Map<String, Object> clauseSet, final Map<String, Object> clauseWhere)
			throws DAOException {
		PreparedStatement ps = null;
		try {
			final List<String> proprietes = new ArrayList<>(clauseSet.keySet());
			final List<String> where = new ArrayList<>(clauseWhere.keySet());
			ps = creerRequetePreparee(connexion, rb.modification(proprietes, where), false, proprietes, clauseSet,
					where, clauseWhere);
			connexion.setAutoCommit(false);
			ps.executeUpdate();
			connexion.commit();
		} catch (SQLException e) {
			try {
				connexion.rollback();
			} catch (SQLException e1) {
				e.printStackTrace();
				throw new DAOException(e1);
			}
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				connexion.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException(e);
			}
		}
	}

	/**
	 * Recherche un objet par son id
	 * 
	 * @param id
	 *            L'id de l'objet
	 * @return
	 * @throws DAOException
	 */
	public T rechercher(final Integer id) throws DAOException {
		Map<String, Object> propVal = new HashMap<>();
		propVal.put(ReflectionUtils.trouverId(classe), id);

		T element = rechercherUnSeulParProprietes(propVal);

		return element;
	}

	/**
	 * Recherche tout les objet de la table
	 * 
	 * @return un eliste de tout les objet de la table
	 * @throws DAOException
	 */
	public List<T> rechercherTout() throws DAOException {
		return rechercherParProprietes(new HashMap<>());
	}

	/**
	 * Recherche plusieurs objets par rapport à une propriete
	 * 
	 * @param propriete
	 *            La propriete
	 * @param valeur
	 *            La valeur de la propriete
	 * @return L'objet correspondant à propriete = valeur
	 * @throws DAOException
	 */
	public List<T> rechercherParPropriete(final String propriete, final Object valeur) throws DAOException {
		Map<String, Object> propVal = new HashMap<>();
		propVal.put(propriete, valeur);
		return rechercherParProprietes(propVal);
	}

	/**
	 * Recherche un objet par rapport a plusieurs conditions
	 * 
	 * @param clauseWhere
	 *            Les conditions que l'objet doit respecter (Map<champs,
	 *            valeur>)
	 * @return L'objet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<T> rechercherParProprietes(final Map<String, Object> clauseWhere) throws DAOException {
		PreparedStatement ps = null;
		ResultSet resultat = null;
		final List<T> elements = new ArrayList<>();
		final List<String> proprietes = new ArrayList<>(clauseWhere.keySet());
		try {
			ps = creerRequetePreparee(connexion, rb.rechercherParPropriete(proprietes), false, null, null, proprietes,
					clauseWhere);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				int id = resultat.getInt(1);
				T recherche = (T) references.rechercher(classe, id);
				if (recherche == null) {
					elements.add((T) construire(id, resultat).get());
				} else {
					elements.add(recherche);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (resultat != null) {
					resultat.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return elements;
	}

	public Object rechercherUneProprieteUnSeul(String nomPropriete, final Map<String, Object> clauseWhere) throws DAOException {
		List<String> props = new ArrayList<>();
		props.add(nomPropriete);
		return rechercherDesProprietesUnSeul(props, clauseWhere).get(nomPropriete);
	}

	/**
	 * Va rechercher les propriete d'un seul objet dans la base
	 * @param nomPropriete Les propriété à récupérer
	 * @param clauseWhere La condition que l'objet doit respecter
	 * @return Une map nom de la propriete -> la valeur
	 * @throws DAOException
	 */
	public Map<String, Object> rechercherDesProprietesUnSeul(final List<String> nomProprietes, final Map<String, Object> clauseWhere) throws DAOException {
		PreparedStatement ps = null;
		ResultSet resultat = null;
		final List<String> proprietes = new ArrayList<>(clauseWhere.keySet());
		final Map<String, Object> elements = new HashMap<>();
		try {
			ps = creerRequetePreparee(connexion, rb.rechercherDesProprietes(nomProprietes, proprietes), false, null, null, proprietes,
					clauseWhere);
			resultat = ps.executeQuery();
			if(resultat.next()) {
				for(String nomPropriete : nomProprietes) {
					elements.put(nomPropriete, resultat.getObject(nomPropriete));
				}
			} else {
				throw new DAOException("Aucun résultat correspondant au conditions !");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			try {
				if (resultat != null) {
					resultat.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return elements;
	}

	// TODO : A factoriser
	@SuppressWarnings("unchecked")
	public T rechercherUnSeulParProprietes(final Map<String, Object> clauseWhere) throws DAOException {
		PreparedStatement ps = null;
		ResultSet resultat = null;
		T element = null;
		final List<String> proprietes = new ArrayList<>(clauseWhere.keySet());
		try {
			ps = creerRequetePreparee(connexion, rb.rechercherParPropriete(proprietes, 1), false, null, null,
					proprietes, clauseWhere);
			resultat = ps.executeQuery();
			if (resultat.next()) {
				String colonneId = ReflectionUtils.trouverId(classe);
				Integer id = resultat.getInt(colonneId);
				element = (T) references.rechercher(classe, id);

				if (element == null) {
					element = (T) construire(id, resultat).get();
				}
			} else {
				throw new DAOException("Aucun résultat trouvé avec ces informations");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (DAOException e) {
			throw e;
		} finally {
			try {
				if (resultat != null) {
					resultat.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return element;
	}

	@SuppressWarnings("unchecked")
	public List<T> rechercherParJointure(List<Jointure> jointure, final Map<String, Object> clauseWhere)
			throws DAOException {
		PreparedStatement ps = null;
		ResultSet resultat = null;
		final List<T> elements = new ArrayList<>();
		final List<String> proprietes = new ArrayList<>(clauseWhere.keySet());
		try {
			ps = creerRequetePreparee(connexion, rb.rechercherParJointure(jointure, proprietes), false, null, null,
					proprietes, clauseWhere);
			resultat = ps.executeQuery();
			while (resultat.next()) {
				int id = resultat.getInt(1);
				T recherche = (T) references.rechercher(classe, id);
				if (recherche == null) {
					elements.add((T) construire(id, resultat).get());
				} else {
					elements.add(recherche);
				}
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (resultat != null) {
					resultat.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}
		return elements;
	}

	/**
	 * Initialise la requete preparee basee sur la connexion passee en argument,
	 * avec la requete SQL et les objets donnes.
	 * 
	 * @param connexion
	 *            La connexion a la BDD
	 * @param sql
	 *            La requete a executer
	 * @param returnGeneratedKeys
	 *            True si la requete doit retourner les id generer lors d'un
	 *            insert.
	 * @param clesSet
	 *            Les champs de la clause set (Une liste ordonnées)
	 * 
	 * @param valeursSet
	 *            La map clé | valeur de la clause set (peut etre null si la
	 *            requete n'est pas un update)
	 * 
	 * @param clesWhere
	 *            Les champs de la clause where (Une liste ordonnées) (peut etre
	 *            null si la requete n'est pas un update)
	 * 
	 * @param valeursWhere
	 *            La map clé | valeur de la clause where
	 * 
	 * @return La requete preparee grace au parametre passes.
	 */
	public PreparedStatement creerRequetePreparee(final Connection connexion, final String sql,
			final boolean returnGeneratedKeys, final List<String> clesSet, Map<String, Object> valeursSet,
			final List<String> clesWhere, Map<String, Object> valeursWhere) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(sql,
				returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		int i = 0;
		if (clesSet != null && valeursSet != null) {
			for (i = 0; i < clesSet.size(); ++i) {
				ps.setObject(i + 1, valeursSet.get(clesSet.get(i)));
			}
		}
		if (clesWhere != null && valeursWhere != null) {
			for (int j = 0; j < clesWhere.size(); ++j) {
				ps.setObject(j + i + 1, valeursWhere.get(clesWhere.get(j)));
			}
		}
		Log.info(ps.toString());
		return ps;
	}

	public WeakReference<? extends IObjetDomaine> construire(final Integer id, final ResultSet resultat) throws DAOException, SQLException {
		// Colonnes : id | nom | prenom | pere | evaluation
		try {
			@SuppressWarnings("unchecked")
			T objet = (T) classe.newInstance();
			/*
			 * Pour chaque champ: Si c'est une colonne ou un id Soit on récupère
			 * sa valeur directement dans le resultset Soit on créé un proxy qui
			 * le récupèrera plus tard Si c'est un membre d'une relation 1 - n
			 * Soit on récupère sa valeur immédiatement grâce à la factory qui
			 * va effectuer une nouvelle requête pour récupérer la liste Soit on
			 * créé un proxy qui récupèrera sa valeur plus tard
			 */
			for (Field champ : classe.getDeclaredFields()) {
				if (champ.getAnnotations().length > 0) {
					boolean accessible = champ.isAccessible();
					champ.setAccessible(true);
					if (!champ.isAnnotationPresent(Transient.class)) {
						String colonne = ReflectionUtils.getNomColonne(champ);
						if (champ.isAnnotationPresent(Colonne.class) || champ.isAnnotationPresent(Id.class)) {
							Object valeur = resultat.getObject(colonne);
							if (valeur != null) {
								if (champ.getType().equals(resultat.getObject(colonne).getClass())) {
									champ.set(objet, resultat.getObject(colonne));
								} else {
									// Si l'objet ne fait partie d'aucune
									// relation et n'est pas un type primitif
									// Java, on utilise une factory pour le
									// créer
									creerAvecFactory(id, objet, champ, colonne);
								}
							}
						} else {
							if (champ.isAnnotationPresent(UnAUn.class)) {
								UnAUn unAUn = champ.getAnnotation(UnAUn.class);
								Object valeur = resultat.getObject(colonne);
								Class<?> type = unAUn.sonType();
								colonne = ReflectionUtils.trouverId(type);

								Factory<T> unAUnFactory = new UnAUnFactory<T>(colonne, valeur, type);
								creerProxy(objet, champ, unAUnFactory);
							} else if (champ.isAnnotationPresent(PlusieursAPlusieurs.class)) {
								PlusieursAPlusieurs plusieursAPlusieurs = champ
										.getAnnotation(PlusieursAPlusieurs.class);

								Class<?> tableAssociation = plusieursAPlusieurs.table_assoc();
								String leurColonne = plusieursAPlusieurs.leurCle();
								Class<?> leurType = plusieursAPlusieurs.type();
								String leurId = ReflectionUtils.trouverId(leurType);

								String notreColonne = plusieursAPlusieurs.notreCle();

								Factory<IObservableList<T>> plusieursAPlusieursFactory = new PlusieursAPlusieursFactory<T>(tableAssociation, leurColonne, notreColonne, leurType,
										leurId, id);
								creerProxyList(objet, champ, plusieursAPlusieursFactory);
							} else if (champ.isAnnotationPresent(PlusieursAUn.class)) {
								PlusieursAUn plusieursAUn = champ.getAnnotation(PlusieursAUn.class);
								String saCle = plusieursAUn.saCle();
								Class<?> sonType = plusieursAUn.sonType();
								colonne = ReflectionUtils.trouverId(sonType);
								Object valeur = resultat.getObject(saCle);

								Factory<T> plusieursAUnFactory = new PlusieursAUnFactory<T>(sonType, colonne,
										valeur);
								creerProxy(objet, champ, plusieursAUnFactory);
							} else if (champ.isAnnotationPresent(UnAPlusieurs.class)) {
								UnAPlusieurs unAPlusieurs = champ.getAnnotation(UnAPlusieurs.class);
								Class<?> leurType = unAPlusieurs.leurType();
								String maCle = unAPlusieurs.maCle();
								Object valeur = resultat.getObject(maCle);

								Factory<IObservableList<T>> unAPlusieursFactory = new UnAPlusieursFactory<T>(leurType,
										maCle, valeur);
								creerProxyList(objet, champ, unAPlusieursFactory);
							}

						}
					}
					champ.setAccessible(accessible);
				}
			}

			return references.enregistrer(classe, id, objet);
		} catch (IllegalArgumentException | IllegalAccessException | InstantiationException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new DAOException("Erreur lors de la creation de l'objet de type " + classe.getName() + " d'id " + id);
		}
	}

	/**
	 * @param objet
	 * @param champ
	 * @param factory
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void creerProxyList(T objet, Field champ, Factory<IObservableList<T>> factory)
			throws IllegalArgumentException, IllegalAccessException {
		VirtualProxyBuilder<IObservableList<T>> vp = new VirtualProxyBuilder<IObservableList<T>>(factory,
				IObservableList.class);
		champ.set(objet, vp.creerProxy());
	}

	/**
	 * @param objet
	 * @param champ
	 * @param factory
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void creerProxy(T objet, Field champ, Factory<T> factory)
			throws IllegalArgumentException, IllegalAccessException {
		VirtualProxyBuilder<T> vp = new VirtualProxyBuilder<T>(factory, champ.getType());
		champ.set(objet, vp.creerProxy());
	}

	/**
	 * Rempli le champs de l'objet immédiatement grace à une factory
	 * 
	 * @param id
	 *            L'id de l'objet à créer
	 * @param objet
	 *            L'objet à remplir
	 * @param champ
	 *            Le champs à remplir
	 * @param colonne
	 *            Le nom de la colonne contenant l'id de l'objet à créer
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws DAOException
	 */
	public void creerAvecFactory(final Integer id, T objet, Field champ, String colonne)
			throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException,
			NoSuchMethodException, SecurityException, DAOException {
		System.out.println("Chargement non proxifié de " + champ.getName());
		champ.set(objet, Factories.getFactory(classe, colonne).getConstructor(Integer.class).newInstance(id).creer());
	}

	/**
	 * Crée un proxy d'un champ d'un objet.
	 * 
	 * @param objet
	 *            L'objet
	 * @param champ
	 *            Le champ de l'objet
	 * @param colonne
	 *            La colonne contenant l'id de l'objet à créer
	 * @param valeur
	 *            En général l'id qui va permettre de trouver l'objet ou la
	 *            liste d'objet à créer.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public void creerProxy(T objet, Field champ, String colonne, Object valeur)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		@SuppressWarnings("unchecked")
		VirtualProxyBuilder<T> vp = new VirtualProxyBuilder<T>((Factory<T>) Factories.getFactory(classe, colonne)
				.getConstructor(valeur.getClass()).newInstance(valeur), champ.getType());
		champ.set(objet, vp.creerProxy());
	}

	/**
	 * Retourne la connexion à la BDD.
	 * 
	 * @return La connexion a la BDD.
	 */
	public Connection getConnexion() {
		return connexion;
	}

	/**
	 * Met à jour la connexion à la BDD.
	 * 
	 * @param connexion
	 *            La nouvelle connexion.
	 */
	public void setConnexion(final Connection connexion) {
		this.connexion = connexion;
	}

}
