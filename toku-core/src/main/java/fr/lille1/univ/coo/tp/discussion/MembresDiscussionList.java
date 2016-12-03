//package fr.lille1.univ.coo.tp.discussion;
//
//import java.util.List;
//
//import fr.lille1.univ.coo.tp.domain.IObjetDomaine;
//import fr.lille1.univ.coo.tp.utilisateur.ObservableList;
//import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
//
//public class MembresDiscussionList extends ObservableList<Utilisateur> {
//	public MembresDiscussionList(List<? extends IObjetDomaine> membres, Discussion discussion) {
//		super(membres, discussion);
//	}
//	
//	
//	@Override
//	public void ajouter(Utilisateur utilisateur) {
//		this.liste.add(utilisateur);
//		AffectationDiscussion affectationDiscussion = new AffectationDiscussion();
//		affectationDiscussion.setUtilisateur(utilisateur);
//		affectationDiscussion.setDiscussion(discussion);
//		affectationDiscussion.setEtat(Discussion.ETAT_EN_ATTENTE);
//		notifierCreation(affectationDiscussion);
//	}
//
//}
