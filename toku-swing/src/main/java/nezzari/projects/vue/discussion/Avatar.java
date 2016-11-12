package nezzari.projects.vue.discussion;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import nezzari.projects.Application;
import nezzari.projects.utilisateur.Utilisateur;
import nezzari.projects.utils.Constantes;

public class Avatar extends ImageIcon {
	public static final int TAILLE = 48;
	public static final int LONGUEUR_CADRE = 68;
	public static final int LARGEUR_CADRE = 63;
	
	private Utilisateur utilisateur;
	private BufferedImage image = null;
	
	public Avatar() {}
	
	public void setImage(String avatar_url) {
		BufferedImage cadre = null;
		try {
			image = avatar_url != null ? ImageIO.read(new URL(avatar_url)) : ImageIO.read(Application.class.getResource(Constantes.CHEMIN_NO_AVATAR));
			cadre = ImageIO.read(Application.class.getResource(Constantes.CHEMIN_CADRE_AVATAR));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage combined = new BufferedImage(LONGUEUR_CADRE, LARGEUR_CADRE, BufferedImage.TYPE_INT_ARGB);
		Graphics g = combined.createGraphics();
		g.drawImage(image, 11, 9, TAILLE, TAILLE, null);
		g.drawImage(cadre, 0, 0, LONGUEUR_CADRE, LARGEUR_CADRE, null);
		g.dispose();
		this.setImage(combined);
	}
	
	public void setImage(Utilisateur utilisateur) {
		setImage(utilisateur.getAvatar());
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
}
