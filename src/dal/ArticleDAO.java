package dal;

import java.util.Date;
import java.util.List;

import bo.ArticlesVendu;

public interface ArticleDAO {

	public List<ArticlesVendu> selectAllArticles();

	public List<ArticlesVendu> selectAllNomLike(String chaine);

	public List<ArticlesVendu> selectAllCateg(int id);

	public List<ArticlesVendu> selectAllNomCateg(String nom, int id);

	public void insertArticle(String nomArticle, String description, Date debut, Date fin, int prixInitial, int noUtilisateur, int noCategorie);

	public int getNoArticle(String nomArticle);
}
