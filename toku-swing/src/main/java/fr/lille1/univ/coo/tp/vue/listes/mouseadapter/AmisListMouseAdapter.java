package fr.lille1.univ.coo.tp.vue.listes.mouseadapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.discussion.IDiscussion;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;
import fr.lille1.univ.coo.tp.vue.discussion.FenetreDiscussion;
import fr.lille1.univ.coo.tp.vue.listes.JObservableList;

public class AmisListMouseAdapter extends JObservableListMouseAdapter<Amitie> {
	public AmisListMouseAdapter(JObservableList<Amitie> liste) {
		super(liste);
	}

	@Override
	public void doubleClic(Amitie element, MouseEvent e) {
		if(element == null) {
			return;
		}
		if(element.getEtat().equals(Amitie.ETAT_EN_ATTENTE)) {
			JOptionPane.showMessageDialog(FenetrePrincipale.getInstance().getFenetre(), "Cet utilisateur n'a pas encore répondu à votre demande d'ami !", "Erreur", JOptionPane.WARNING_MESSAGE);
			return;
		}

		if(element.getEtat().equals(Amitie.ETAT_REFUSEE)) {
			JOptionPane.showMessageDialog(FenetrePrincipale.getInstance().getFenetre(), "Cet utilisateur a refusé votre demande d'ami ! Harcelez le en lui re-demandant !", "Erreur", JOptionPane.WARNING_MESSAGE);
			return;
		}
		IDiscussion discussion = Service.getDiscussionService().rechercherDiscussionPriveeAvec(element.getAmi());

		try {
			if(discussion == null) {
				discussion = Service.getDiscussionService().creerDiscussion("Discussion privée entre : " + element.getUtilisateur().getPseudo() + " et " + element.getAmi().getPseudo(), Discussion.TYPE_PRIVE);
				Service.getDiscussionService().validerDiscussions();
				Service.getDiscussionService().ajouterUtilisateur(discussion, element.getUtilisateur(), AffectationDiscussion.ETAT_OUVERTE);
				Service.getDiscussionService().ajouterUtilisateur(discussion, element.getAmi(), AffectationDiscussion.ETAT_NOUVELLE_DISCUSSION);
				Service.getDiscussionService().validerAffectations();
			}
			FenetreDiscussion fenetre = new FenetreDiscussion(discussion);
			fenetre.getPanneauPrincipal().setRightComponent(null);
			fenetre.getLblNomDiscussion().setText(discussion.getNom());
		} catch (ServiceException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(FenetrePrincipale.getInstance().getFenetre(), "Erreur lors du cryptage du mot de passe !", "Erreur", JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void clic(Amitie element, MouseEvent e) {

	}

	@Override
	public void clicDroit(Amitie element, MouseEvent e) {
		if(element != null) {
			JPopupMenu menuAffectation = new JPopupMenu("Gestion amis");
			JMenuItem menuSupprimerAmi = new JMenuItem("Supprimer l'ami");
			menuSupprimerAmi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						Service.getUtilisateurService().supprimerAmi(element);
						Service.getUtilisateurService().validerAmi();
					} catch (ServiceException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(FenetrePrincipale.getInstance().getFenetre(), e1.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			menuAffectation.add(menuSupprimerAmi);
			menuAffectation.show(liste, e.getX(), e.getY());
		}
	}

}
