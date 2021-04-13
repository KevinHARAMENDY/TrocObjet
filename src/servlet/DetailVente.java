package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ArticleManager;
import bo.ArticlesVendu;

@WebServlet("/DetailVente")
public class DetailVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noArticle = request.getParameter("id");
		ArticleManager am = new ArticleManager();
		ArticlesVendu article = am.getArticleByNo(Integer.parseInt(noArticle));
		System.out.println(article);
		request.setAttribute("Article", article);
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailVente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
