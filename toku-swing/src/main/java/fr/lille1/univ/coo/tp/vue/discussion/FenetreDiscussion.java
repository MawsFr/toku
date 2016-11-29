package fr.lille1.univ.coo.tp.vue.discussion;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;

import fr.lille1.univ.coo.tp.discussion.message.Message;
import fr.lille1.univ.coo.tp.utilisateur.IObservableList;
import fr.lille1.univ.coo.tp.utilisateur.Utilisateur;
import fr.lille1.univ.coo.tp.vue.composants.fenetre.Fermable;
import fr.lille1.univ.coo.tp.vue.gestion.utilisateurs.JListUtilisateur;
import fr.lille1.univ.coo.tp.vue.gestion.utilisateurs.UtilisateurListModel;

import javax.swing.border.TitledBorder;
import javax.swing.plaf.ListUI;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;

public class FenetreDiscussion extends JFrame implements Fermable {

	private static final long serialVersionUID = 1L;
	
	private Container c;
	private JLabel lblTypeDiscussion;
	private JLabel lblNomDiscussion;
	private JList<Message> listeMessages;
	private JButton btnEnvoyer;
	private JToggleButton btnPrioritaire;
	private JTextArea txtMessage;
	private JToggleButton btnAccuseReception;
	private JToggleButton btnChiffre;
	private JToggleButton btnExpire;
	private JListUtilisateur listeMembres;
	private JMenuBar barreMenu;
	private JMenu menuFichier;
	private JMenuItem menuFermer;
	
	public FenetreDiscussion(IObservableList<Utilisateur> membres) {
		c = getContentPane();
		c.setLayout(new BorderLayout(0, 0));
		
		JSplitPane panneauPrincipal = new JSplitPane();
		panneauPrincipal.setResizeWeight(1.0);
		panneauPrincipal.setOneTouchExpandable(true);
		c.add(panneauPrincipal);
		
		JPanel panneauGauche = new JPanel();
		panneauGauche.setMinimumSize(new Dimension(400, 10));
		panneauPrincipal.setLeftComponent(panneauGauche);
		panneauGauche.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitGauche = new JSplitPane();
		splitGauche.setResizeWeight(0.6);
		splitGauche.setOneTouchExpandable(true);
		splitGauche.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panneauGauche.add(splitGauche);
		
		JPanel panneauHaut = new JPanel();
		panneauHaut.setMinimumSize(new Dimension(200, 100));
		splitGauche.setLeftComponent(panneauHaut);
		panneauHaut.setLayout(new BorderLayout(0, 0));
		
		JPanel panneauTitre = new JPanel();
		panneauTitre.setBorder(new TitledBorder(null, "Nom de la discussion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panneauHaut.add(panneauTitre, BorderLayout.NORTH);
		panneauTitre.setLayout(new BoxLayout(panneauTitre, BoxLayout.X_AXIS));
		
		lblTypeDiscussion = new JLabel("Groupe: ");
		panneauTitre.add(lblTypeDiscussion);
		
		lblNomDiscussion = new JLabel("New label");
		panneauTitre.add(lblNomDiscussion);
		
		JPanel panneauMessages = new JPanel();
		panneauMessages.setBorder(new TitledBorder(null, "Messages", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panneauHaut.add(panneauMessages, BorderLayout.CENTER);
		panneauMessages.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollMessages = new JScrollPane();
		panneauMessages.add(scrollMessages);
		
		listeMessages = new JList<>();
		listeMessages.setMinimumSize(new Dimension(0, 100));
		scrollMessages.setViewportView(listeMessages);
		
		JPanel panneauBas = new JPanel();
		splitGauche.setRightComponent(panneauBas);
		panneauBas.setLayout(new BorderLayout(0, 0));
		
		JPanel panneauBas2 = new JPanel();
		panneauBas2.setBorder(new TitledBorder(null, "Envoyer un message", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panneauBas.add(panneauBas2, BorderLayout.CENTER);
		panneauBas2.setLayout(new BorderLayout(0, 0));
		
		txtMessage = new JTextArea();
		
		JPanel panneauEnvoi = new JPanel();
		FlowLayout fl_panneauEnvoi = (FlowLayout) panneauEnvoi.getLayout();
		fl_panneauEnvoi.setAlignment(FlowLayout.TRAILING);
		panneauBas2.add(panneauEnvoi, BorderLayout.SOUTH);
		
		JCheckBox chckbxValiderAvecEntre = new JCheckBox("Valider avec entrée");
		panneauEnvoi.add(chckbxValiderAvecEntre);
		
		btnEnvoyer = new JButton("Envoyer");
		panneauEnvoi.add(btnEnvoyer);
		
		JToolBar barreOutils = new JToolBar();
		barreOutils.setRollover(true);
		barreOutils.setFloatable(false);
		panneauBas2.add(barreOutils, BorderLayout.NORTH);
		
		btnPrioritaire = new JToggleButton("Prioritaire");
		barreOutils.add(btnPrioritaire);
		
		btnAccuseReception = new JToggleButton("Accusé");
		barreOutils.add(btnAccuseReception);
		
		btnChiffre = new JToggleButton("Chiffré");
		barreOutils.add(btnChiffre);
		
		btnExpire = new JToggleButton("Expire");
		barreOutils.add(btnExpire);
		
		JScrollPane scrollMessage = new JScrollPane();
		scrollMessage.setViewportView(txtMessage);
		panneauBas2.add(scrollMessage, BorderLayout.CENTER);
		
		JPanel panneauDroite = new JPanel();
		panneauPrincipal.setRightComponent(panneauDroite);
		panneauDroite.setLayout(new BorderLayout(0, 0));
		
		JPanel panneauDroite2 = new JPanel();
		panneauDroite.add(panneauDroite2, BorderLayout.CENTER);
		panneauDroite2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollMembres = new JScrollPane();
		
		
		
		listeMembres = new JListUtilisateur(membres);
		listeMembres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollMembres.setViewportView(listeMembres);
		
		JPanel panneauMembres = new JPanel();
		panneauMembres.setBorder(new TitledBorder(null, "Liste des membres", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panneauMembres.setLayout(new BorderLayout(0, 0));
		panneauMembres.add(scrollMembres, BorderLayout.CENTER);
		
		panneauDroite2.add(panneauMembres, BorderLayout.CENTER);
		
		JPanel panneauBoutonMembres = new JPanel();
		panneauBoutonMembres.setBorder(new TitledBorder(null, "Modération", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panneauDroite2.add(panneauBoutonMembres, BorderLayout.SOUTH);
		panneauBoutonMembres.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		JButton btnAjouterMembre = new JButton("+");
		btnAjouterMembre.setPreferredSize(new Dimension(29, 29));
		panneauBoutonMembres.add(btnAjouterMembre);
		
		JButton btnSupprimerMembre = new JButton("-");
		btnSupprimerMembre.setPreferredSize(new Dimension(29, 29));
		panneauBoutonMembres.add(btnSupprimerMembre);
		
		barreMenu = new JMenuBar();
		setJMenuBar(barreMenu);
		
		menuFichier = new JMenu("Fichier");
		barreMenu.add(menuFichier);
		
		menuFermer = new JMenuItem("Fermer");
		menuFichier.add(menuFermer);
		
		setSize(800, 600);
		setPreferredSize(getSize());
		setMinimumSize(new Dimension(500, 400));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
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
	public JList<Message> getListeMessages() {
		return listeMessages;
	}

	/**
	 * @param listeMessages Le nouveau listeMessages
	 */
	public void setListeMessages(JList<Message> listeMessages) {
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
	public JTextArea getTxtMessage() {
		return txtMessage;
	}

	/**
	 * @param txtMessage Le nouveau txtMessage
	 */
	public void setTxtMessage(JTextArea txtMessage) {
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
	public JListUtilisateur getListeMembres() {
		return listeMembres;
	}

	/**
	 * @param listeMembres Le nouveau listeMembres
	 */
	public void setListeMembres(JListUtilisateur listeMembres) {
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
	
	
}