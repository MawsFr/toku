package fr.lille1.univ.coo.tp.vue.discussion;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.FiltrerAmiAction;
import fr.lille1.univ.coo.tp.controlleurs.composants.FermerAction;
import fr.lille1.univ.coo.tp.controlleurs.composants.ValiderAction;
import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.IDiscussion;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.BarreMenuPrincipale;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;
import fr.lille1.univ.coo.tp.vue.composants.fenetre.Fermable;
import fr.lille1.univ.coo.tp.vue.composants.fenetre.Validable;
import fr.lille1.univ.coo.tp.vue.listes.JAmisList;
import fr.lille1.univ.coo.tp.vue.listes.JTexteFiltre;
import fr.lille1.univ.coo.tp.vue.listes.cellrenderer.AmitieListCellRenderer;
import fr.lille1.univ.coo.tp.vue.listes.mouseadapter.NouvelleAffectationListMouseAdapter;

public class FenetreAffectation extends JDialog implements Validable, Fermable {

	private static final String BTN_AJOUTER_À_LA_DISCUSSION = "Ajouter à la discussion";
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE_VIDE = "Vous n'avez aucun amis ... parlez tout seul !";
	private static final String AIDE_FILTRE = "pseudo ou nom ou prenom";
	private Container c;
	private JAmisList amis;
	private JTexteFiltre<Amitie> filtre;
	private JButton btnAjouterAmi;
	private JButton btnFermer;
	private IDiscussion discussion;

	public FenetreAffectation(FenetreDiscussion fenetre) {
		super(fenetre, BarreMenuPrincipale.MENU_GERER_UTILISATEURS,
				ModalityType.APPLICATION_MODAL);
		this.discussion = fenetre.getDiscussion();
		c = getContentPane();
		c.setLayout(new BorderLayout());
		Utilisateur utilisateur = Application.getInstance().getSession().getUtilisateur();

		amis = new JAmisList(utilisateur.getAmitie());
		amis.setMessageVide(MESSAGE_VIDE);
		amis.setCellRenderer(new AmitieListCellRenderer());
		amis.setSelectedIndex(0);
		amis.addMouseListener(new NouvelleAffectationListMouseAdapter(this, amis));
		filtre = amis.getTexte();
		filtre.getDocument().addDocumentListener(new FiltrerAmiAction(amis));
		filtre.setHint(AIDE_FILTRE);
		JScrollPane scroll = new JScrollPane(amis);
		scroll.setPreferredSize(new Dimension(300, 400));

		btnAjouterAmi = new JButton(new ValiderAction(this, BTN_AJOUTER_À_LA_DISCUSSION));
		btnFermer = new JButton(new FermerAction(this));

		// GBC gbc = new GBC(c);
		JPanel haut = new JPanel();
		haut.setLayout(new BoxLayout(haut, BoxLayout.X_AXIS));
		haut.add(new JLabel("Filtre :"));
		haut.add(filtre);

		JPanel bas = new JPanel();
		bas.setLayout(new FlowLayout(FlowLayout.RIGHT));

		bas.add(btnAjouterAmi);
		bas.add(btnFermer);

		c.add(haut, BorderLayout.NORTH);
		c.add(scroll, BorderLayout.CENTER);
		c.add(bas, BorderLayout.SOUTH);

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(300, 300);
		setMinimumSize(new Dimension(300, 300));
		setPreferredSize(getSize());
		// setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void ajouterAmi(Amitie element) {
		if(element == null) {
			return;
		}
		if(element.getEtat().equals(Amitie.ETAT_EN_ATTENTE)) {
			JOptionPane.showMessageDialog(this, "Cet utilisateur n'a pas encore répondu à votre demande d'ami !", "Erreur", JOptionPane.WARNING_MESSAGE);
			return;
		}

		if(element.getEtat().equals(Amitie.ETAT_REFUSEE)) {
			JOptionPane.showMessageDialog(this, "Cet utilisateur a refusé votre demande d'ami ! Harcelez le en lui re-demandant !", "Erreur", JOptionPane.WARNING_MESSAGE);
			return;
		}
		try {
			if(discussion != null) {
				Service.getDiscussionService().ajouterUtilisateur(discussion, element.getAmi(), AffectationDiscussion.ETAT_EN_ATTENTE);
				Service.getDiscussionService().validerAffectations();
				JOptionPane.showMessageDialog(this, element.getUtilisateur().getPseudo() + " a bien reçu votre invitation à la discussion!", "Affectation d'ami",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void valider() {
		if (this.amis.getSelectedIndex() != -1) {
			ajouterAmi(this.amis.getSelectedValue());
		}
	}

	@Override
	public void fermer() {
		this.dispose();
	}
}