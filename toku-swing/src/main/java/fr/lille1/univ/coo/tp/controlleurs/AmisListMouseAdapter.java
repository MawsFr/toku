package fr.lille1.univ.coo.tp.controlleurs;

import javax.swing.JOptionPane;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableListMouseAdapter;

public class AmisListMouseAdapter extends JObservableListMouseAdapter<Amitie> {
	public AmisListMouseAdapter(JObservableList<Amitie> liste) {
		super(liste);
	}

	@Override
	public void doubleClic(Amitie element) {
		Discussion discussion = null;
		try {
			discussion = Service.getDiscussionService().creerDiscussion("Discussion privée entre : " + element.getUtilisateur().getPseudo() + " et " + element.getAmi().getPseudo(), Discussion.TYPE_PRIVE);
			Service.getDiscussionService().validerDiscussions();
			Service.getDiscussionService().ajouterUtilisateur(discussion, element.getUtilisateur(), AffectationDiscussion.ETAT_LU);
			Service.getDiscussionService().ajouterUtilisateur(discussion, element.getAmi(), AffectationDiscussion.ETAT_EN_ATTENTE);
			Service.getDiscussionService().validerAffectations();
			FenetreDiscussion fenetre = new FenetreDiscussion(discussion);
//        fenetre.getLblTypeDiscussion().setText("Discussion privée : ");
			fenetre.getLblNomDiscussion().setText(element.getAmi().getPseudo());
		} catch (ServiceException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(FenetrePrincipale.getInstance().getFenetre(), "Erreur lors du cryptage du mot de passe !", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	@Override
	public void clic(Amitie element) {
		
	}

	@Override
	public void clicDroit(Amitie element) {
		
	}
	
}
