package bll;

import java.sql.Date;
import java.util.List;

import bo.ArticlesVendu;
import dal.ArticleDAO;
import dal.DAOFactory;

public class ArticleManager {
	private ArticleDAO articleDAO;
	
	public ArticleManager() {
		this.articleDAO=DAOFactory.getArticleDAO();
	}

	public List<ArticlesVendu> afficheTout() {
		return this.articleDAO.selectAllArticles();
	}
	
	public List<ArticlesVendu> afficheLikeNom(String chaine) {
		return this.articleDAO.selectAllNomLike(chaine);
	}
	
	public List<ArticlesVendu> afficheCateg(int id) {
		return this.articleDAO.selectAllCateg(id);
	}

	public List<ArticlesVendu> afficheCategNom(String nom, int id) {
		return this.articleDAO.selectAllNomCateg(nom, id);
	}
	
	public void insertArticle(String nomArticle, String description, Date debut, Date fin, int prixInitial, int noUtilisateur, int noCategorie) {
		this.articleDAO.insertArticle(nomArticle, description, debut, fin, prixInitial, noUtilisateur, noCategorie);
	}

	public int getNoArticle(String nomArticle) {
		return this.articleDAO.getNoArticle(nomArticle);
	}
}
