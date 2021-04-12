package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleManager;
import bll.CategorieManager;
import bll.UserManager;
import bo.ArticlesVendu;
import bo.Categories;
import bo.Utilisateurs;

@WebServlet("/")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ArticleManager artMan = new ArticleManager();
    	UserManager userMan = new UserManager();
    	CategorieManager categMan = new CategorieManager();
    	
    	List<ArticlesVendu> lstArticles = artMan.afficheTout();
    	List<Categories> lstCateg = categMan.afficheTout();
    	List<String> lstAffichage = new ArrayList<>();
    	
    	for(ArticlesVendu art : lstArticles) {
    		Utilisateurs user = userMan.afficheParId(art.getNoUtilisateur());
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    		lstAffichage.add(art.getNom_article() + " @ " + art.getPrix_vente() +
    				" @ " + sdf.format(art.getDate_fin_encheres()) + " @ " + user.getPseudo()
    				+ " @ " + art.getNoArticle());
    	}
    	request.setAttribute("Articles", lstAffichage);
    	request.setAttribute("Categories", lstCateg);
    	
    	this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleManager artMan = new ArticleManager();
    	UserManager userMan = new UserManager();
    	CategorieManager categMan = new CategorieManager();
    	
    	List<String> lstAffichage = new ArrayList<>();
    	List<ArticlesVendu> lstArticles = new ArrayList<>();
    	List<Categories> lstCateg = categMan.afficheTout();
		
		if (request.getParameter("categorie").equals("") && request.getParameter("filtre").equals("")) {
			//si les deux champs sont vides
			lstArticles = artMan.afficheTout();
		} else if (request.getParameter("categorie") != "" && request.getParameter("filtre").equals("")) {
			//si seule la catégorie est renseignée
			//TODO erreur 500 si aucun article avec catégorie
			lstArticles = artMan.afficheCateg(categMan.afficheParNom(request.getParameter("categorie")).getNoCategorie());
		} else if (request.getParameter("filtre") != "" && request.getParameter("categorie").equals("")) {
			//si seul le filtre est renseigné
			lstArticles = artMan.afficheLikeNom(request.getParameter("filtre"));
		} else if (request.getParameter("categorie") != "" && request.getParameter("filtre") != "") {
			//TODO si les deux champs sont renseignés
			lstArticles = artMan.afficheCategNom(request.getParameter("filtre"),categMan.afficheParNom(request.getParameter("categorie")).getNoCategorie());
		}
		
		for(ArticlesVendu art : lstArticles) {
    		Utilisateurs user = userMan.afficheParId(art.getNoUtilisateur());
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    		lstAffichage.add(art.getNom_article() + " @ " + art.getPrix_vente() +
    				" @ " + sdf.format(art.getDate_fin_encheres()) + " @ " + user.getPseudo()
    				+ " @ " + art.getNoArticle());
    	}
		
		request.setAttribute("Articles", lstAffichage);
		request.setAttribute("Categories", lstCateg);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

}
