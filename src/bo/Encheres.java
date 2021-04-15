package bo;

import java.io.Serializable;
import java.util.Date;

public class Encheres implements Serializable {
	private static final long serialVersionUID = 1L;
	private Utilisateurs utilisateur;
	private ArticlesVendu article;
	private Date date_enchere;
	private int montant_enchere;
	
	public Encheres() {}

	public Encheres(Utilisateurs utilisateur, ArticlesVendu article, Date date_enchere, int montant_enchere) {
		super();
		this.utilisateur = utilisateur;
		this.article = article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateurs utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ArticlesVendu getArticle() {
		return article;
	}

	public void setArticle(ArticlesVendu article) {
		this.article = article;
	}

	public Date getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(Date date_enchere) {
		this.date_enchere = date_enchere;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}

}
