package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

@WebServlet("/NewVente")
public class NewVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager cm = new CategorieManager();
		List<Categories> listCategorie = cm.selectCategorie();
		request.setAttribute("Categories", listCategorie);
		Utilisateurs user = (Utilisateurs) request.getSession().getAttribute("User");
		String pseudo = user.getPseudo(); 
		UserManager um = new UserManager();
		Utilisateurs utilisateur = um.selectByPseudo(pseudo);
		request.setAttribute("rue", utilisateur.getRue()); 
		request.setAttribute("cp", utilisateur.getCode_postal()); 
		request.setAttribute("ville", utilisateur.getVille());
		 
		this.getServletContext().getRequestDispatcher("/WEB-INF/newVente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		Object photo = request.getParameter("photo");
		String prix = request.getParameter("prix");
		String dateDebut = request.getParameter("debut");
		String dateFin = request.getParameter("fin");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dateD = null;
		java.util.Date dateF = null;
		try {
			dateD = sdf.parse(dateDebut);
			dateF = sdf.parse(dateFin);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
		java.sql.Date debut = new java.sql.Date(dateD.getTime());
		java.sql.Date fin = new java.sql.Date(dateF.getTime());
		
		Utilisateurs user = (Utilisateurs) request.getSession().getAttribute("User");
		ArticleManager am = new ArticleManager();
		am.insertArticle(article, description, debut, fin, Integer.parseInt(prix), user.getNoUtilisateur(), Integer.parseInt(categorie));
		
		ArticlesVendu art = am.getArticleByNom(article);
		request.setAttribute("art", art);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailVente.jsp").forward(request, response);
	}

}
