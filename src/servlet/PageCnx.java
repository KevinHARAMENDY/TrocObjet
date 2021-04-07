package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.UserManager;
import bo.Utilisateurs;

@WebServlet("/PageConnexion")
public class PageCnx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/pageCnx.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("identifiant");
		String mdp = request.getParameter("mdp");
		
		UserManager userMan = new UserManager();
		Utilisateurs user = userMan.afficheParPseudoMdp(pseudo, mdp);
		
		if (user == null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/pageCnx.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("User", user);
			this.getServletContext().getRequestDispatcher("/").forward(request, response);
		}
	}

}
