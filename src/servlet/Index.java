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
import javax.servlet.http.HttpSession;

import bll.ArticleManager;
import bll.CategorieManager;
import bll.EnchereManager;
import bll.UserManager;
import bo.ArticlesVendu;
import bo.Categories;
import bo.Encheres;
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
    		Utilisateurs user = userMan.afficheParId(art.getUtilisateur().getNoUtilisateur());
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
    	EnchereManager enchMan = new EnchereManager();
    	
    	List<String> lstAffichage = new ArrayList<>();
    	List<ArticlesVendu> lstArticles = new ArrayList<>();
    	List<Categories> lstCateg = categMan.afficheTout();
    	List<Encheres> lstEnch = new ArrayList<>();
    	
    	//on récupère l'utilisateur passé en session si celui-ci s'est connecté préalablement
    	HttpSession session = request.getSession();
		Utilisateurs enSession = (Utilisateurs) session.getAttribute("User");
    	
    	if (request.getParameter("categorie") == null && request.getParameter("filtre") == null) {
    		//si on accède à l'index par une autre page
    		lstArticles = artMan.afficheTout();
    	} else if (request.getParameter("achats") != null && request.getParameter("achats").equals("on")) {
    		if (request.getParameter("ach").equals("e_ouvertes")) {
    			//bouton enchères ouvertes
    			lstArticles = artMan.afficheToutEnCours();
    		} else if (request.getParameter("ach").equals("e_cours")) {
    			//bouton mes enchères en cours
    			lstEnch = enchMan.afficheToutId(enSession.getNoUtilisateur());
    			lstArticles = artMan.afficheToutEnchCours(lstEnch);
    		} else if (request.getParameter("ach").equals("e_remporte")) {
    			//bouton mes enchères remportées
    			lstEnch = enchMan.afficheToutPlusGrand(enSession.getNoUtilisateur());
    			lstArticles = artMan.afficheToutRemporte(lstEnch);
    		}
    	} else if (request.getParameter("ventes") != null && request.getParameter("ventes").equals("on")) {
    		if (request.getParameter("ven").equals("v_cours")) {
    			//bouton ventes en cours
    			lstArticles = artMan.afficheMesVentes(enSession.getNoUtilisateur());
    		} else if (request.getParameter("ven").equals("v_n_debute")) {
    			//bouton ventes non débutées
    			lstArticles = artMan.afficheMesVentesNonDebut(enSession.getNoUtilisateur());
    		} else if (request.getParameter("ven").equals("v_termine")) {
    			//bouton ventes terminées
    			lstArticles = artMan.afficheMesVentesFinies(enSession.getNoUtilisateur());
    		}
    	} else {
    		if (request.getParameter("categorie").equals("") && request.getParameter("filtre").equals("")) {
    			//si les deux champs sont vides
    			lstArticles = artMan.afficheTout();
    		} else if (request.getParameter("categorie") != "" && request.getParameter("filtre").equals("")) {
    			//si seule la catégorie est renseignée
    			lstArticles = artMan.afficheCateg(categMan.afficheParNom(request.getParameter("categorie")).getNoCategorie());
    		} else if (request.getParameter("filtre") != "" && request.getParameter("categorie").equals("")) {
    			//si seul le filtre est renseigné
    			lstArticles = artMan.afficheLikeNom(request.getParameter("filtre"));
    		} else if (request.getParameter("categorie") != "" && request.getParameter("filtre") != "") {
    			//si les deux champs sont renseignés
    			lstArticles = artMan.afficheCategNom(request.getParameter("filtre"),categMan.afficheParNom(request.getParameter("categorie")).getNoCategorie());
    		}
    	}
    	
    	/*if (request.getParameter("achats").equals("on")) {
    	 	else if (request.getParameter("ach").equals("e_remporte")) {
    			//bouton mes enchères remportées
    		}
    	}*/
		
		for(ArticlesVendu art : lstArticles) {
    		Utilisateurs user = userMan.afficheParId(art.getUtilisateur().getNoUtilisateur());
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