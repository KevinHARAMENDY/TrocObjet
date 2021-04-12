package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bll.UserManager;
import bo.Utilisateurs;

/**
 * Servlet implementation class afficherProfil
 */
@WebServlet("/afficherProfil")
public class afficherProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// récupérer le pseudo (identifiant) par jsp lors du clic sur le pseudo
		String pseudo = request.getParameter("identifiant");
		
		UserManager userMan = new UserManager();
		Utilisateurs user = userMan.selectByPseudo(pseudo);
		
		if (user != null) {
			request.setAttribute("user", user);
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/afficherProfil.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
