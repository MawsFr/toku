package fr.lille1.univ.coo.tp.vue.notification;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import fr.lille1.univ.coo.tp.Application;
import fr.lille1.univ.coo.tp.controlleurs.amitie.AccepterAmiAction;
import fr.lille1.univ.coo.tp.discussion.AffectationDiscussion;
import fr.lille1.univ.coo.tp.discussion.Discussion;
import fr.lille1.univ.coo.tp.domain.DomainException;
import fr.lille1.univ.coo.tp.filtre.EstEnAttente;
import fr.lille1.univ.coo.tp.filtre.EstRefusee;
import fr.lille1.univ.coo.tp.filtre.EstValide;
import fr.lille1.univ.coo.tp.filtre.Filtre;
import fr.lille1.univ.coo.tp.filtre.NONFiltre;
import fr.lille1.univ.coo.tp.filtre.OUFiltre;
import fr.lille1.univ.coo.tp.service.Service;
import fr.lille1.univ.coo.tp.service.ServiceException;
import fr.lille1.univ.coo.tp.utilisateur.Amitie;
import fr.lille1.univ.coo.tp.vue.listes.IObservableListModel;

public class PopupNotification extends JFrame {
	private static final long serialVersionUID = 1L;

	private static final String MESSAGE_DEMANDE_AMI_VIDE = "Vous n'avez aucune demande d'ami";
	private static final String MESSAGE_GROUPE_VIDE = "Vous n'avez aucun nouveau message";
	private static final String ONGLET_DEMANDE_AMI = "Demande d'amis";
	private static final String ONGLET_DISCUSSION = "Actualités discussions";

	private JTabbedPane onglets;
	private JPanel ongletDemandeAmi;
	private JPanel ongletDiscussion;

	//	private JAmisList notifAmi;
	//	private JAffectationList notifDiscussion;

	private Filtre filtreAmi;
	private Filtre filtreDiscussion;

	private IObservableListModel<Amitie> amitieModel;
	private IObservableListModel<AffectationDiscussion> discussionModel;


	public PopupNotification() {
		onglets = new JTabbedPane();
		ongletDemandeAmi = new JPanel();
		ongletDiscussion = new JPanel();

		ongletDemandeAmi.setLayout(new BorderLayout());
		ongletDiscussion.setLayout(new BorderLayout());

		List<Filtre> criteresAmis = new ArrayList<>();
		filtreAmi = new OUFiltre(criteresAmis);

		EstEnAttente enAttente = new EstEnAttente();
		EstValide estValideAmi = new EstValide();
		EstRefusee estRefuseeAmi = new EstRefusee();

		criteresAmis.add(enAttente);
		criteresAmis.add(estValideAmi);
		criteresAmis.add(estRefuseeAmi);

		// Discussion
		filtreDiscussion = new EstEnAttente();
		
		onglets.addTab(ONGLET_DEMANDE_AMI, ongletDemandeAmi);
		onglets.addTab(ONGLET_DISCUSSION, ongletDiscussion);

		setContentPane(onglets);

		setSize(400, 400);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void rafraichirAmitie() throws DomainException {
		ongletDemandeAmi.removeAll();
		amitieModel = new IObservableListModel<>(Application.getInstance().getSession().getUtilisateur().getAmitie());
		amitieModel.filtrer(filtreAmi);
		JPanel notifsAmi = new JPanel();
		notifsAmi.setLayout(new BoxLayout(notifsAmi, BoxLayout.Y_AXIS));
		for(int i = 0; i < amitieModel.size(); ++i) {
			notifsAmi.add(new AmitieNotificationPanel(amitieModel.get(i)));
		}
		ongletDemandeAmi.add(new JScrollPane(notifsAmi), BorderLayout.CENTER);
		
	}
	
	public void rafraichirAffectation() throws DomainException {
		ongletDiscussion.removeAll();
		discussionModel = new IObservableListModel<>(Application.getInstance().getSession().getUtilisateur().getAffectations());
		discussionModel.filtrer(filtreDiscussion);
		JPanel notifsDiscussion = new JPanel();
		notifsDiscussion.setLayout(new BoxLayout(notifsDiscussion, BoxLayout.Y_AXIS));
		for(int i = 0; i < discussionModel.size(); ++i) {
			notifsDiscussion.add(new AffectationNotificationPanel(discussionModel.get(i)));
		}
		ongletDiscussion.add(new JScrollPane(notifsDiscussion), BorderLayout.CENTER);
		
	}
	

	/**
	 * @return Le onglets
	 */
	public JTabbedPane getOnglets() {
		return onglets;
	}

	/**
	 * @param onglets Le nouveau onglets
	 */
	public void setOnglets(JTabbedPane onglets) {
		this.onglets = onglets;
	}

	/**
	 * @return Le ongletDemandeAmi
	 */
	public JPanel getOngletDemandeAmi() {
		return ongletDemandeAmi;
	}

	/**
	 * @param ongletDemandeAmi Le nouveau ongletDemandeAmi
	 */
	public void setOngletDemandeAmi(JPanel ongletDemandeAmi) {
		this.ongletDemandeAmi = ongletDemandeAmi;
	}

	/**
	 * @return Le ongletDiscussion
	 */
	public JPanel getOngletDiscussion() {
		return ongletDiscussion;
	}

	/**
	 * @param ongletDiscussion Le nouveau ongletDiscussion
	 */
	public void setOngletDiscussion(JPanel ongletDiscussion) {
		this.ongletDiscussion = ongletDiscussion;
	}

	//	/**
	//	 * @return Le notifAmi
	//	 */
	//	public JAmisList getNotifAmi() {
	//		return notifAmi;
	//	}
	//
	//	/**
	//	 * @param notifAmi Le nouveau notifAmi
	//	 */
	//	public void setNotifAmi(JAmisList notifAmi) {
	//		this.notifAmi = notifAmi;
	//	}
	//
	//	/**
	//	 * @return Le notifDiscussion
	//	 */
	//	public JAffectationList getNotifDiscussion() {
	//		return notifDiscussion;
	//	}
	//
	//	/**
	//	 * @param notifDiscussion Le nouveau notifDiscussion
	//	 */
	//	public void setNotifDiscussion(JAffectationList notifDiscussion) {
	//		this.notifDiscussion = notifDiscussion;
	//	}

	/**
	 * @return Le filtreAmi
	 */
	public Filtre getFiltreAmi() {
		return filtreAmi;
	}

	/**
	 * @param filtreAmi Le nouveau filtreAmi
	 */
	public void setFiltreAmi(Filtre filtreAmi) {
		this.filtreAmi = filtreAmi;
	}

	/**
	 * @return Le filtreDiscussion
	 */
	public Filtre getFiltreDiscussion() {
		return filtreDiscussion;
	}

	/**
	 * @param filtreDiscussion Le nouveau filtreDiscussion
	 */
	public void setFiltreDiscussion(Filtre filtreDiscussion) {
		this.filtreDiscussion = filtreDiscussion;
	}



}
