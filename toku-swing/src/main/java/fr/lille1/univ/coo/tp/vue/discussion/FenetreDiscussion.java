package fr.lille1.univ.coo.tp.vue.discussion;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.discussion.message.Message;
import fr.lille1.univ.coo.tp.vue.composants.fenetre.Fermable;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JAffectationList;
import fr.lille1.univ.coo.tp.vue.utilisateurs.JUtilisateurList;

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
	private JAffectationList listeMembres;
	private JMenuBar barreMenu;
	private JMenu menuFichier;
	private JMenuItem menuFermer;
	
	public FenetreDiscussion(Discussion discussion) {
		c = getContentPane();
		c.setLayout(new BorderLayout(0, 0));
		
		lblTypeDiscussion = new JLabel("Groupe: ");
		lblNomDiscussion = new JLabel("New label");
		txtMessage = new JTextArea();
		listeMessages = new JList<>();
		btnEnvoyer = new JButton("Envoyer");
		btnPrioritaire = new JToggleButton("Prioritaire");
		btnAccuseReception = new JToggleButton("Accusé");
		btnChiffre = new JToggleButton("Chiffré");
		btnExpire = new JToggleButton("Expire");
		listeMembres = new JAffectationList(discussion.getAffectations());
		barreMenu = new JMenuBar();
		menuFichier = new JMenu("Fichier");
		menuFermer = new JMenuItem("Fermer");
		
		JSplitPane panneauPrincipal = new JSplitPane();
		JPanel panneauGauche = new JPanel();
		JSplitPane splitGauche = new JSplitPane();
		JPanel panneauHaut = new JPanel();
		JPanel panneauTitre = new JPanel();
		JPanel panneauMessages = new JPanel();
		JScrollPane scrollMessages = new JScrollPane();
		JPanel panneauBas = new JPanel();
		JPanel panneauBas2 = new JPanel();
		JPanel panneauEnvoi = new JPanel();
		JCheckBox chckbxValiderAvecEntre = new JCheckBox("Valider avec entrée");
		JToolBar barreOutils = new JToolBar();
		JScrollPane scrollMessage = new JScrollPane();
		JPanel panneauDroite = new JPanel();
		JPanel panneauDroite2 = new JPanel();
		JScrollPane scrollMembres = new JScrollPane();
		JPanel panneauMembres = new JPanel();
		JPanel panneauBoutonMembres = new JPanel();
		JButton btnAjouterMembre = new JButton("+");
		JButton btnSupprimerMembre = new JButton("-");

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
	
	
}
