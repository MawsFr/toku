//package fr.lille1.univ.coo.tp.utilisateur;
//
//import java.util.List;
//
//public class AmiUtilisateurList extends ObservableList<Utilisateur>{
//	
//	public AmiUtilisateurList(List<Utilisateur> liste, Utilisateur utilisateur) {
//		super(liste, utilisateur);
//	}
//	
//	@Override
//	public void ajouter(Utilisateur ami) {
//		this.liste.add(ami);
//		Amitie amitite = new Amitie();
//		amitite.setUtilisateur(parent);
//		amitite.setAmi(ami);
//		amitite.setEtat(Amitie.ETAT_EN_ATTENTE);
//		notifierCreation(amitite);
//	}
//
//}
