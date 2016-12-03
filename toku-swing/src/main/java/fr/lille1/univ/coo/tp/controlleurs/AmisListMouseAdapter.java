package fr.lille1.univ.coo.tp.controlleurs;

import javax.swing.JOptionPane;

import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JObservableListMouseAdapter;

public class AmisListMouseAdapter extends JObservableListMouseAdapter<Utilisateur> {
	public AmisListMouseAdapter(JObservableList<Utilisateur> liste) {
		super(liste);
	}

	@Override
	public void doubleClic(Utilisateur element) {
		Discussion discussion = null;
		try {
			discussion = Service.getDiscussionService().creerDiscussion("Discussion", Discussion.TYPE_PRIVE);
			Service.getDiscussionService().ajouterUtilisateur(discussion, element);
		} catch (ServiceException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(FenetrePrincipale.getInstance().getFenetre(), "Erreur lors du cryptage du mot de passe !", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
        FenetreDiscussion fenetre = new FenetreDiscussion(discussion);
        fenetre.getLblTypeDiscussion().setText("Discussion privée : ");
        fenetre.getLblNomDiscussion().setText(element.getPseudo());
	}

	@Override
	public void clic(Utilisateur element) {
		
	}

	@Override
	public void clicDroit(Utilisateur element) {
		
	}
	
}
