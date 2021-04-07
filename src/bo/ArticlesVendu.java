package bo;

import java.io.Serializable;
import java.util.Date;

public class ArticlesVendu implements Serializable {
	private static final long serialVersionUID = 1L;
	private int noArticle;
	private String nom_article;
	private String description;
	private Date date_debut_encheres;
	private int prix_initial;
	private int prix_vente;
	private Utilisateurs noUtilisateur;
	private Categories noCategorie;
	
	public ArticlesVendu() {}

	public ArticlesVendu(int noArticle, String nom_article, String description, Date date_debut_encheres,
			int prix_initial, int prix_vente, Utilisateurs noUtilisateur, Categories noCategorie) {
		super();
		this.noArticle = noArticle;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
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

	public Utilisateurs getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Utilisateurs noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public Categories getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Categories noCategorie) {
		this.noCategorie = noCategorie;
	}

}
