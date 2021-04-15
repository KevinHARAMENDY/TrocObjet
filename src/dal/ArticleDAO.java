package dal;

import java.util.List;

import bo.ArticlesVendu;
import bo.Encheres;

public interface ArticleDAO {

	public List<ArticlesVendu> selectAllArticles();

	public List<ArticlesVendu> selectAllNomLike(String chaine);

	public List<ArticlesVendu> selectAllCateg(int id);

	public List<ArticlesVendu> selectAllNomCateg(String nom, int id);

	public List<ArticlesVendu> selectAllArticlesCours();

	public List<ArticlesVendu> selectAllMesVentes(int noUtilisateur);

	public List<ArticlesVendu> selectAllMesVentesNonDebut(int noUtilisateur);

	public List<ArticlesVendu> selectAllMesVentesFinies(int noUtilisateur);

	public List<ArticlesVendu> selectAllMesEnchCours(List<Encheres> lstEnch);

	public List<ArticlesVendu> selectAllMesEnchRemporte(List<Encheres> lstEnch);

}
