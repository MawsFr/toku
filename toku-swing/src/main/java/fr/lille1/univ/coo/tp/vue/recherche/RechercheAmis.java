package fr.lille1.univ.coo.tp.vue.recherche;

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

import fr.lille1.univ.coo.tp.controlleurs.FiltrerUtilisateurAction;
import fr.lille1.univ.coo.tp.controlleurs.composants.FermerAction;
import fr.lille1.univ.coo.tp.controlleurs.composants.ValiderAction;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.BarreMenuPrincipale;
import fr.lille1.univ.coo.tp.vue.FenetrePrincipale;
import fr.lille1.univ.coo.tp.vue.composants.fenetre.Fermable;
import fr.lille1.univ.coo.tp.vue.composants.fenetre.Validable;
import fr.lille1.univ.coo.tp.vue.listes.JTexteFiltre;
import fr.lille1.univ.coo.tp.vue.listes.JUtilisateurList;
import fr.lille1.univ.coo.tp.vue.listes.cellrenderer.RechercheAmiListCellRenderer;

public class RechercheAmis extends JDialog implements Validable, Fermable {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE_VIDE = "Aucun utilisateur n'est présent dans notre pauvre base";
	private static final String AIDE_FILTRE = "pseudo ou nom ou prenom";
	private Container c;
	private JUtilisateurList utilisateurs;
	private JTexteFiltre<Utilisateur> filtre;
	private JButton btnAjouterAmi;
	private JButton btnFermer;

	public RechercheAmis(IObservableList<Utilisateur> membres) {
		super(FenetrePrincipale.getInstance().getFenetre(), BarreMenuPrincipale.MENU_GERER_UTILISATEURS,
				ModalityType.APPLICATION_MODAL);

		c = getContentPane();
		c.setLayout(new BorderLayout());

		utilisateurs = new JUtilisateurList(membres);
		utilisateurs.setMessageVide(MESSAGE_VIDE);
		utilisateurs.setCellRenderer(new RechercheAmiListCellRenderer());
		utilisateurs.setSelectedIndex(0);
		utilisateurs.addMouseListener(new DemandeAmiMouseAdapter(this, utilisateurs));
		filtre = utilisateurs.getTexte();
		filtre.getDocument().addDocumentListener(new FiltrerUtilisateurAction(utilisateurs));
		filtre.setHint(AIDE_FILTRE);
		JScrollPane scroll = new JScrollPane(utilisateurs);
		scroll.setPreferredSize(new Dimension(300, 400));

		btnAjouterAmi = new JButton(new ValiderAction(this));
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
		setSize(400, 400);
		setMinimumSize(new Dimension(400, 400));
		setPreferredSize(getSize());
		// setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void ajouterAmi(Utilisateur element) {
		try {
			Service.getUtilisateurService().demanderEnAmi(element);
			JOptionPane.showMessageDialog(this, element.getPseudo() + " a bien reçu votre invitation !", "Ajout d'ami",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (ServiceException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void valider() {
		if (this.utilisateurs.getSelectedIndex() != -1) {
			ajouterAmi(this.utilisateurs.getSelectedValue());
		}
	}

	@Override
	public void fermer() {
		this.dispose();
	}

}
