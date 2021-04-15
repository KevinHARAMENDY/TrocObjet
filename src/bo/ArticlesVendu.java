package bo;

import java.io.Serializable;
import java.util.Date;

public class ArticlesVendu implements Serializable {
	private static final long serialVersionUID = 1L;
	private int noArticle;
	private String nom_article;
	private String description;
	private Date date_debut_encheres;
	private Date date_fin_encheres;
	private int prix_initial;
	private int prix_vente;
	private Utilisateurs utilisateur;
	private Categories categorie;
	
	public ArticlesVendu() {}
	
	/**
	 * Constructeur ArticleVendu avec noArticle
	 * @param noArticle
	 */
	public ArticlesVendu(int noArticle) {
		super();
		this.noArticle = noArticle;
	}
	
	

	/**
	 * Constructeur ArticlesVendu
	 * 
	 * @param noArticle
	 * @param nom_article
	 * @param description
	 * @param date_fin_encheres
	 * @param prix_initial
	 * @param prix_vente
	 * @param categorie
	 */
	public ArticlesVendu(int noArticle, String nom_article, String description, Date date_fin_encheres,
			int prix_initial, int prix_vente, Categories categorie) {
		super();
		this.noArticle = noArticle;
		this.nom_article = nom_article;
		this.description = description;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.categorie = categorie;
	}

	public ArticlesVendu(int noArticle, String nom_article, String description, Date date_debut_encheres,
			Date date_fin_encheres, int prix_initial, int prix_vente, Utilisateurs utilisateur,
			Categories categorie) {
		super();
		this.noArticle = noArticle;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNom_article() {
		return nom_article;
	}

	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_debut_encheres() {
		return date_debut_encheres;
	}

	public void setDate_debut_encheres(Date date_debut_encheres) {
		this.date_debut_encheres = date_debut_encheres;
	}
	
	public Date getDate_fin_encheres() {
		return date_fin_encheres;
	}

	public void setDate_fin_encheres(Date date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}

	public int getPrix_initial() {
		return prix_initial;
	}

	public void setPrix_initial(int prix_initial) {
		this.prix_initial = prix_initial;
	}

	public int getPrix_vente() {
		return prix_vente;
	}

	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}

	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateurs utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Categories getCategorie() {
		return categorie;
	}

	public void setCategorie(Categories categorie) {
		this.categorie = categorie;
	}

}
