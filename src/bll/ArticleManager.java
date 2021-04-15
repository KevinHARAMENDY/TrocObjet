package bll;

import java.util.List;

import bo.ArticlesVendu;
import bo.Encheres;
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

	public List<ArticlesVendu> afficheToutEnCours() {
		return this.articleDAO.selectAllArticlesCours();
	}

	public List<ArticlesVendu> afficheMesVentes(int noUtilisateur) {
		return this.articleDAO.selectAllMesVentes(noUtilisateur);
	}

	public List<ArticlesVendu> afficheMesVentesNonDebut(int noUtilisateur) {
		return this.articleDAO.selectAllMesVentesNonDebut(noUtilisateur);
	}

	public List<ArticlesVendu> afficheMesVentesFinies(int noUtilisateur) {
		return this.articleDAO.selectAllMesVentesFinies(noUtilisateur);
	}

	public List<ArticlesVendu> afficheToutEnchCours(List<Encheres> lstEnch) {
		return this.articleDAO.selectAllMesEnchCours(lstEnch);
	}

	public List<ArticlesVendu> afficheToutRemporte(List<Encheres> lstEnch) {
		return this.articleDAO.selectAllMesEnchRemporte(lstEnch);
	}
}
