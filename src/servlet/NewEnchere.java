package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.CategorieManager;
import bll.EnchereManager;
import bo.Categories;

@WebServlet("/NewEnchere")
public class NewEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategorieManager cm = new CategorieManager();
		List<Categories> listCategorie = cm.selectCategorie();
		request.setAttribute("Categories", listCategorie);
		this.getServletContext().getRequestDispatcher("/WEB-INF/newVente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String article = request.getParameter("article");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		Object photo = request.getParameter("photo");
		String prix = request.getParameter("prix");
		String dateDebut = request.getParameter("début");
		String dateFin = request.getParameter("fin");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		
		int noCategorie = 0;
		Date debut = null;
		Date fin = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			debut = Date.valueOf(sdf.format(dateDebut));
			fin = Date.valueOf(sdf.format(dateFin));
		
		CategorieManager cm = new CategorieManager();
		List<Categories> categorieList = cm.selectCategorie();
		for(Categories a : categorieList) {
			if(a.getLibelle().equals(categorie)) {
				noCategorie = a.getNoCategorie();
			}
		}
		EnchereManager em = new EnchereManager();
		em.insertArticle(article, description, debut, fin, Integer.parseInt(prix), Integer.parseInt(request.getSession().getId()), noCategorie);
		int noArticle = em.getNoArticle(article);
		em.insertEnchere(Integer.parseInt(request.getSession().getId()), noArticle, debut, Integer.parseInt(prix));
		
	}

}
