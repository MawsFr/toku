package fr.lille1.univ.coo.tp.vue.discussion;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.discussion.AffecterAction;
import fr.lille1.univ.coo.tp.controlleurs.discussion.DesaffecterAction;
import fr.lille1.univ.coo.tp.controlleurs.discussion.EnvoyerMessageAction;
import fr.lille1.univ.coo.tp.controlleurs.discussion.QuitterGroupeAction;
import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.discussion.IDiscussion;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utils.Log;
import fr.lille1.univ.coo.tp.vue.composants.fenetre.Fermable;
import fr.lille1.univ.coo.tp.vue.listes.JAffectationList;
import fr.lille1.univ.coo.tp.vue.listes.JMessageList;
import fr.lille1.univ.coo.tp.vue.listes.cellrenderer.AffectationListCellRenderer;
import fr.lille1.univ.coo.tp.vue.listes.cellrenderer.MessageListCellRenderer;
import fr.lille1.univ.coo.tp.vue.listes.mouseadapter.AffectationListMouseAdapter;

public class FenetreDiscussion extends JFrame implements Fermable {

	public static final String MESSAGE_VIDE_AFFECTATION = "Aucun utilisateur sur cette dicussion !";
	private static final String MESSAGE_VIDE_MESSAGES = "Aucun message dans cette discussion";

	private static final long serialVersionUID = 1L;

	public static final Object BTN_ENVOYER = "Envoyer";
	public static final Object BTN_PLUS = "+";
	public static final Object BTN_MOINS = "-";
	public static final Object BTN_QUITTER = "Quitter la discussion";
	public static final Object LBL_PASSER_DROIT_MODO = "Passer les droits modo";
	
	private Container c;
	private JLabel lblTypeDiscussion;
	private JLabel lblNomDiscussion;
	private JMessageList listeMessages;
	private JButton btnEnvoyer;
	private JToggleButton btnPrioritaire;
	private JEditorPane txtMessage;
	private JToggleButton btnAccuseReception;
	private JToggleButton btnChiffre;
	private JToggleButton btnExpire;
	private JAffectationList listeMembres;
	private JMenuBar barreMenu;
	private JMenu menuFichier;
	private JMenuItem menuFermer;
	
	private IDiscussion discussion;

	private EnvoyerMessageAction envoyerAction;

	private JCheckBox chckbxValiderAvecEntre;
	private JPanel panneauDroite;
	private JSplitPane panneauPrincipal;
	private JPanel panneauBoutonMembres;
	private JButton btnQuitterLeGroupe;
	
	public FenetreDiscussion(IDiscussion iDiscussion) {
		this.discussion = iDiscussion;
		
		c = getContentPane();
		c.setLayout(new BorderLayout(0, 0));
		
		envoyerAction = new EnvoyerMessageAction(this);
		
		lblTypeDiscussion = new JLabel(iDiscussion.getLeType().equals(Discussion.TYPE_GROUPE) ? "Groupe : " : "");
		lblNomDiscussion = new JLabel(iDiscussion.getNom());
		txtMessage = new JEditorPane();
		txtMessage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					if(chckbxValiderAvecEntre.isSelected()) {
						envoyer();
					}
			    }
			}
		});
		listeMessages = new JMessageList(iDiscussion.getMessages());
		listeMessages.setMessageVide(MESSAGE_VIDE_MESSAGES);
		listeMessages.setCellRenderer(new MessageListCellRenderer());
		btnEnvoyer = new JButton(envoyerAction);
		btnPrioritaire = new JToggleButton("Prioritaire");
		btnAccuseReception = new JToggleButton("Accusé");
		btnChiffre = new JToggleButton("Chiffré");
		btnExpire = new JToggleButton("Expire");
		listeMembres = new JAffectationList(iDiscussion.getAffectations());
		listeMembres.setCellRenderer(new AffectationListCellRenderer());
		listeMembres.addMouseListener(new AffectationListMouseAdapter(this));
		listeMembres.setMessageVide(MESSAGE_VIDE_AFFECTATION);
		barreMenu = new JMenuBar();
		menuFichier = new JMenu("Fichier");
		menuFermer = new JMenuItem("Fermer");
		
		panneauPrincipal = new JSplitPane();
		JPanel panneauGauche = new JPanel();
		JSplitPane splitGauche = new JSplitPane();
		JPanel panneauHaut = new JPanel();
		JPanel panneauTitre = new JPanel();
		JPanel panneauMessages = new JPanel();
		JScrollPane scrollMessages = new JScrollPane();
		JPanel panneauBas = new JPanel();
		JPanel panneauBas2 = new JPanel();
		JPanel panneauEnvoi = new JPanel();
		chckbxValiderAvecEntre = new JCheckBox("Valider avec entrée");
		JToolBar barreOutils = new JToolBar();
		JScrollPane scrollMessage = new JScrollPane();
		panneauDroite = new JPanel();
		JPanel panneauDroite2 = new JPanel();
		JScrollPane scrollMembres = new JScrollPane();
		JPanel panneauMembres = new JPanel();
		panneauBoutonMembres = new JPanel();
		JButton btnAjouterMembre = new JButton(new AffecterAction(this));
		JButton btnSupprimerMembre = new JButton(new DesaffecterAction(this));

		panneauPrincipal.setResizeWeight(1.0);
		panneauPrincipal.setOneTouchExpandable(true);
		c.add(panneauPrincipal);
		
		panneauGauche.setMinimumSize(new Dimension(400, 10));
		panneauPrincipal.setLeftComponent(panneauGauche);
		panneauGauche.setLayout(new BorderLayout(0, 0));
		
		splitGauche.setResizeWeight(0.6);
		splitGauche.setOneTouchExpandable(true);
		splitGauche.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panneauGauche.add(splitGauche);
		
		panneauHaut.setMinimumSize(new Dimension(200, 100));
		splitGauche.setLeftComponent(panneauHaut);
		panneauHaut.setLayout(new BorderLayout(0, 0));
		
		panneauTitre.setBorder(new TitledBorder(null, "Nom de la discussion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panneauHaut.add(panneauTitre, BorderLayout.NORTH);
		panneauTitre.setLayout(new BoxLayout(panneauTitre, BoxLayout.X_AXIS));
		
		panneauTitre.add(lblTypeDiscussion);
		panneauTitre.add(lblNomDiscussion);
		
		panneauMessages.setBorder(new TitledBorder(null, "Messages", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panneauHaut.add(panneauMessages, BorderLayout.CENTER);
		panneauMessages.setLayout(new BorderLayout(0, 0));
		panneauMessages.add(scrollMessages);
		
		listeMessages.setMinimumSize(new Dimension(0, 100));
		scrollMessages.setViewportView(listeMessages);
		
		splitGauche.setRightComponent(panneauBas);
		panneauBas.setLayout(new BorderLayout(0, 0));
		
		panneauBas2.setBorder(new TitledBorder(null, "Envoyer un message", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panneauBas.add(panneauBas2, BorderLayout.CENTER);
		panneauBas2.setLayout(new BorderLayout(0, 0));
		
		FlowLayout fl_panneauEnvoi = (FlowLayout) panneauEnvoi.getLayout();
		fl_panneauEnvoi.setAlignment(FlowLayout.TRAILING);
		panneauBas2.add(panneauEnvoi, BorderLayout.SOUTH);
		
		panneauEnvoi.add(chckbxValiderAvecEntre);
		panneauEnvoi.add(btnEnvoyer);
		
		barreOutils.setRollover(true);
		barreOutils.setFloatable(false);
		panneauBas2.add(barreOutils, BorderLayout.NORTH);
		
		barreOutils.add(btnPrioritaire);
		barreOutils.add(btnAccuseReception);
		barreOutils.add(btnChiffre);
		barreOutils.add(btnExpire);
		
		scrollMessage.setViewportView(txtMessage);
		panneauBas2.add(scrollMessage, BorderLayout.CENTER);
		
		panneauPrincipal.setRightComponent(panneauDroite);
		panneauDroite.setLayout(new BorderLayout(0, 0));
		
		panneauDroite.add(panneauDroite2, BorderLayout.CENTER);
		panneauDroite2.setLayout(new BorderLayout(0, 0));
		
		listeMembres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollMembres.setViewportView(listeMembres);
		
		panneauMembres.setBorder(new TitledBorder(null, "Liste des membres", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panneauMembres.setLayout(new BorderLayout(0, 0));
		panneauMembres.add(scrollMembres, BorderLayout.CENTER);
		
		panneauDroite2.add(panneauMembres, BorderLayout.CENTER);
		
		btnQuitterLeGroupe = new JButton(new QuitterGroupeAction(this));
		panneauMembres.add(btnQuitterLeGroupe, BorderLayout.SOUTH);
		panneauBoutonMembres.setBorder(new TitledBorder(null, "Modération", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panneauDroite2.add(panneauBoutonMembres, BorderLayout.SOUTH);
		panneauBoutonMembres.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		btnAjouterMembre.setPreferredSize(new Dimension(29, 29));
		panneauBoutonMembres.add(btnAjouterMembre);
		btnSupprimerMembre.setPreferredSize(new Dimension(29, 29));
		panneauBoutonMembres.add(btnSupprimerMembre);
		
		setJMenuBar(barreMenu);
		barreMenu.add(menuFichier);
		menuFichier.add(menuFermer);
		
		setSize(800, 600);
		setPreferredSize(getSize());
		setMinimumSize(new Dimension(500, 400));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void envoyer() {
		String texte = txtMessage.getText();
		if(!texte.isEmpty() && texte.trim().length() > 0) {
			Boolean accuse = btnAccuseReception.isSelected();
			Boolean prioritaire = btnPrioritaire.isSelected();
			Boolean chiffre = btnChiffre.isSelected();
			Integer expire = 2;
			try {
				Service.getDiscussionService().envoyerMessage(discussion, texte, accuse, prioritaire, chiffre, expire); //TODO : Design pattern decorator
				for(AffectationDiscussion affectationDiscussion : discussion.getAffectations().getListe()) {
					if(!affectationDiscussion.getUtilisateur().equals(Application.getInstance().getSession().getUtilisateur())) {
						affectationDiscussion.setEtat(AffectationDiscussion.ETAT_VU);
					}
				}
				Service.getDiscussionService().validerAffectations();
				Log.info("Message envoye");
				txtMessage.setText("");
				txtMessage.setCaretPosition(0);
			} catch (ServiceException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(this, "Erreur lors de l'envoi du message", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void desaffecter(AffectationDiscussion affectation) {
		if(affectation == null) {
			affectation = listeMembres.getElementSelectionne();
		}
		try {
			Service.getDiscussionService().supprimerUtilisateur(affectation, discussion, false);
//			JOptionPane.showMessageDialog(this, "Utilisateur supprimé", "Erreur", JOptionPane.INFORMATION_MESSAGE);
			if(discussion.getAffectations().getListe().size() == 0 || affectation.getUtilisateur().equals(Application.getInstance().getSession().getUtilisateur())) {
				this.dispose();
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	

	public void passerDroitModo() {
		AffectationDiscussion affectation = listeMembres.getElementSelectionne();
		try {
			Service.getDiscussionService().passerDroitModo(discussion, affectation.getUtilisateur());
		} catch (ServiceException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void quitterLaDiscussion() {
		AffectationDiscussion affectationDiscussion = null;
		for(AffectationDiscussion affectation : discussion.getAffectations().getListe()) {
			if(affectation.getUtilisateur().equals(Application.getInstance().getSession().getUtilisateur())) {
				affectationDiscussion = affectation;
				break;
			}
		}
		if(affectationDiscussion != null) {
			desaffecter(affectationDiscussion);
		}
	}
	
	
	@Override
	public void fermer() {
		this.dispose();
	}

	/**
	 * @return Le c
	 */
	public Container getC() {
		return c;
	}

	/**
	 * @param c Le nouveau c
	 */
	public void setC(Container c) {
		this.c = c;
	}

	/**
	 * @return Le lblTypeDiscussion
	 */
	public JLabel getLblTypeDiscussion() {
		return lblTypeDiscussion;
	}

	/**
	 * @param lblTypeDiscussion Le nouveau lblTypeDiscussion
	 */
	public void setLblTypeDiscussion(JLabel lblTypeDiscussion) {
		this.lblTypeDiscussion = lblTypeDiscussion;
	}

	/**
	 * @return Le lblNomDiscussion
	 */
	public JLabel getLblNomDiscussion() {
		return lblNomDiscussion;
	}

	/**
	 * @param lblNomDiscussion Le nouveau lblNomDiscussion
	 */
	public void setLblNomDiscussion(JLabel lblNomDiscussion) {
		this.lblNomDiscussion = lblNomDiscussion;
	}

	/**
	 * @return Le listeMessages
	 */
	public JMessageList getListeMessages() {
		return listeMessages;
	}

	/**
	 * @param listeMessages Le nouveau listeMessages
	 */
	public void setListeMessages(JMessageList listeMessages) {
		this.listeMessages = listeMessages;
	}

	/**
	 * @return Le btnEnvoyer
	 */
	public JButton getBtnEnvoyer() {
		return btnEnvoyer;
	}

	/**
	 * @param btnEnvoyer Le nouveau btnEnvoyer
	 */
	public void setBtnEnvoyer(JButton btnEnvoyer) {
		this.btnEnvoyer = btnEnvoyer;
	}

	/**
	 * @return Le btnPrioritaire
	 */
	public JToggleButton getBtnPrioritaire() {
		return btnPrioritaire;
	}

	/**
	 * @param btnPrioritaire Le nouveau btnPrioritaire
	 */
	public void setBtnPrioritaire(JToggleButton btnPrioritaire) {
		this.btnPrioritaire = btnPrioritaire;
	}

	/**
	 * @return Le txtMessage
	 */
	public JEditorPane getTxtMessage() {
		return txtMessage;
	}

	/**
	 * @param txtMessage Le nouveau txtMessage
	 */
	public void setTxtMessage(JEditorPane txtMessage) {
		this.txtMessage = txtMessage;
	}

	/**
	 * @return Le btnAccuseReception
	 */
	public JToggleButton getBtnAccuseReception() {
		return btnAccuseReception;
	}

	/**
	 * @param btnAccuseReception Le nouveau btnAccuseReception
	 */
	public void setBtnAccuseReception(JToggleButton btnAccuseReception) {
		this.btnAccuseReception = btnAccuseReception;
	}

	/**
	 * @return Le btnChiffre
	 */
	public JToggleButton getBtnChiffre() {
		return btnChiffre;
	}

	/**
	 * @param btnChiffre Le nouveau btnChiffre
	 */
	public void setBtnChiffre(JToggleButton btnChiffre) {
		this.btnChiffre = btnChiffre;
	}

	/**
	 * @return Le btnExpire
	 */
	public JToggleButton getBtnExpire() {
		return btnExpire;
	}

	/**
	 * @param btnExpire Le nouveau btnExpire
	 */
	public void setBtnExpire(JToggleButton btnExpire) {
		this.btnExpire = btnExpire;
	}

	/**
	 * @return Le listeMembres
	 */
	public JAffectationList getListeMembres() {
		return listeMembres;
	}

	/**
	 * @param listeMembres Le nouveau listeMembres
	 */
	public void setListeMembres(JAffectationList listeMembres) {
		this.listeMembres = listeMembres;
	}

	/**
	 * @return Le barreMenu
	 */
	public JMenuBar getBarreMenu() {
		return barreMenu;
	}

	/**
	 * @param barreMenu Le nouveau barreMenu
	 */
	public void setBarreMenu(JMenuBar barreMenu) {
		this.barreMenu = barreMenu;
	}

	/**
	 * @return Le menuFichier
	 */
	public JMenu getMenuFichier() {
		return menuFichier;
	}

	/**
	 * @param menuFichier Le nouveau menuFichier
	 */
	public void setMenuFichier(JMenu menuFichier) {
		this.menuFichier = menuFichier;
	}

	/**
	 * @return Le menuFermer
	 */
	public JMenuItem getMenuFermer() {
		return menuFermer;
	}

	/**
	 * @param menuFermer Le nouveau menuFermer
	 */
	public void setMenuFermer(JMenuItem menuFermer) {
		this.menuFermer = menuFermer;
	}

	/**
	 * @return Le discussion
	 */
	public IDiscussion getDiscussion() {
		return discussion;
	}

	/**
	 * @param discussion Le nouveau discussion
	 */
	public void setDiscussion(IDiscussion discussion) {
		this.discussion = discussion;
	}

	/**
	 * @return Le envoyerAction
	 */
	public EnvoyerMessageAction getEnvoyerAction() {
		return envoyerAction;
	}

	/**
	 * @param envoyerAction Le nouveau envoyerAction
	 */
	public void setEnvoyerAction(EnvoyerMessageAction envoyerAction) {
		this.envoyerAction = envoyerAction;
	}

	/**
	 * @return Le chckbxValiderAvecEntre
	 */
	public JCheckBox getChckbxValiderAvecEntre() {
		return chckbxValiderAvecEntre;
	}

	/**
	 * @param chckbxValiderAvecEntre Le nouveau chckbxValiderAvecEntre
	 */
	public void setChckbxValiderAvecEntre(JCheckBox chckbxValiderAvecEntre) {
		this.chckbxValiderAvecEntre = chckbxValiderAvecEntre;
	}

	/**
	 * @return Le panneauDroite
	 */
	public JPanel getPanneauDroite() {
		return panneauDroite;
	}

	/**
	 * @param panneauDroite Le nouveau panneauDroite
	 */
	public void setPanneauDroite(JPanel panneauDroite) {
		this.panneauDroite = panneauDroite;
	}

	/**
	 * @return Le panneauPrincipal
	 */
	public JSplitPane getPanneauPrincipal() {
		return panneauPrincipal;
	}

	/**
	 * @param panneauPrincipal Le nouveau panneauPrincipal
	 */
	public void setPanneauPrincipal(JSplitPane panneauPrincipal) {
		this.panneauPrincipal = panneauPrincipal;
	}

	/**
	 * @return Le panneauBoutonMembres
	 */
	public JPanel getPanneauBoutonMembres() {
		return panneauBoutonMembres;
	}

	/**
	 * @param panneauBoutonMembres Le nouveau panneauBoutonMembres
	 */
	public void setPanneauBoutonMembres(JPanel panneauBoutonMembres) {
		this.panneauBoutonMembres = panneauBoutonMembres;
	}
}
