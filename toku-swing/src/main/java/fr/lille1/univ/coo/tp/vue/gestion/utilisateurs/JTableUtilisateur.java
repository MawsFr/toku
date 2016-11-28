//package fr.lille1.univ.coo.tp.vue.gestion.utilisateurs;
//
//import fr.lille1.univ.coo.tp.filtre.Filtre;
//import fr.lille1.univ.coo.tp.utilisateur.ObservableList;
//import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
//
//public class JTableUtilisateur {
//	private static final long serialVersionUID = 1L;
//	// TODO : RENDRE GENERIQUE LA CLASSE
//	private ObservableList<Utilisateur> utilisateurs;
//	private UtilisateurListModel model;
//	
//	public JTableUtilisateur(ObservableList<Utilisateur> utilisateurs) {
//		this.utilisateurs = utilisateurs;
//		model = new UtilisateurListModel(utilisateurs);
//		this.setModel(model);
//	}
//
//	/**
//	 * @return Le utilisateurs
//	 */
//	public ObservableList<Utilisateur> getUtilisateurs() {
//		return utilisateurs;
//	}
//
//	/**
//	 * @param utilisateurs Le nouveau utilisateurs
//	 */
//	public void setUtilisateurs(ObservableList<Utilisateur> utilisateurs) {
//		this.utilisateurs = utilisateurs;
//	}
//
//	/**
//	 * @return Le model
//	 */
//	public UtilisateurListModel getModel() {
//		return model;
//	}
//
//	/**
//	 * @param model Le nouveau model
//	 */
//	public void setModel(UtilisateurListModel model) {
//		this.model = model;
//	}
//
//	@Override
//	public void filtrer(Filtre filtre) {
//		// TODO : Implémenter
//		
//	}
//}
