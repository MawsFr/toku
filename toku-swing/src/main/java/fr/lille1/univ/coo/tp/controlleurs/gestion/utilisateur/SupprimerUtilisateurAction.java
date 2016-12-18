package fr.lille1.univ.coo.tp.controlleurs.gestion.utilisateur;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.utilisateurs.GestionUtilisateurs;

public class SupprimerUtilisateurAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	private static SupprimerUtilisateurAction instance;
	private GestionUtilisateurs gestionUtilisateurs;
	
	public static SupprimerUtilisateurAction getInstance(GestionUtilisateurs gestionUtilisateurs) {
		if(instance == null) {
			instance = new SupprimerUtilisateurAction(gestionUtilisateurs);
		}
		
		return instance;
	}
	
	private SupprimerUtilisateurAction(GestionUtilisateurs gestionUtilisateurs) {
		super(GestionUtilisateurs.SUPPRIMER_UTILISATEUR);
		this.gestionUtilisateurs = gestionUtilisateurs;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Utilisateur utilisateur = gestionUtilisateurs.getUtilisateurs().getElementSelectionne();
		if(utilisateur.equals(Application.getInstance().getSession().getUtilisateur())) {
			JOptionPane.showMessageDialog(gestionUtilisateurs, "Vous ne pouvez pas supprimer votre propre compte, en étant loggé dessus", "Erreur", JOptionPane.ERROR_MESSAGE);
		} else {
			if(JOptionPane.showConfirmDialog(gestionUtilisateurs,
					"Êtes-vous sûr de vouloir supprimer l'utilisateur " + gestionUtilisateurs.getUtilisateurs().getElementSelectionne().getPseudo() + " ?",
					"Suppression utilisateur",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					Service.getUtilisateurService().supprimer(utilisateur, gestionUtilisateurs.getUtilisateurs().getListe());
					Service.getUtilisateurService().validerChangements();
					JOptionPane.showMessageDialog(gestionUtilisateurs, "Utilisateur supprimé !", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);
				} catch (ServiceException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(gestionUtilisateurs, "Erreur lors de la suppression : " + e.getCause(), "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
	}

}
