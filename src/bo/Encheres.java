package bo;

import java.io.Serializable;
import java.util.Date;

public class Encheres implements Serializable {
	private static final long serialVersionUID = 1L;
	private Utilisateurs noUtilisateur;
	private ArticlesVendu noArticle;
	private Date date_enchere;
	private int montant_enchere;
	
	public Encheres() {}
	
	
	
	/**
	 *  Constructeur Encheres
	 * 
	 * @param noUtilisateur
	 * @param noArticle
	 * @param montant_enchere
	 */
	public Encheres(Utilisateurs noUtilisateur, ArticlesVendu noArticle, int montant_enchere) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.montant_enchere = montant_enchere;
	}

	/**
	 * Constructeur Encheres
	 * 
	 * @param noUtilisateur
	 * @param noArticle
	 * @param date_enchere
	 */
	public Encheres(Utilisateurs noUtilisateur, ArticlesVendu noArticle, Date date_enchere) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.date_enchere = date_enchere;
	}


	public Encheres(Utilisateurs noUtilisateur, ArticlesVendu noArticle, Date date_enchere, int montant_enchere) {
		super();
		this.noUtilisateur = noUtilisateur;
		this.noArticle = noArticle;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}

	public Utilisateurs getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Utilisateurs noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public ArticlesVendu getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(ArticlesVendu noArticle) {
		this.noArticle = noArticle;
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
