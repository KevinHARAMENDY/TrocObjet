package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.UserManager;
import bo.Utilisateurs;

@WebServlet("/CreationCompte")
public class CreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/creationProfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("nom") != null || request.getParameter("pseudo") != null ||
		  request.getParameter("prenom") != null || request.getParameter("email") != null ||
		  request.getParameter("tel") != null || request.getParameter("rue") != null ||
		  request.getParameter("cp") != null || request.getParameter("ville") != null ||
		  request.getParameter("mdp") != null || request.getParameter("confirmation") != null &&
		  request.getParameter("mdp") == request.getParameter("confirmation")) {
			Utilisateurs user = new Utilisateurs(request.getParameter("pseudo"), request.getParameter("nom"),
				request.getParameter("prenom"), request.getParameter("email"), request.getParameter("tel"),
				request.getParameter("rue"), request.getParameter("cp"), request.getParameter("ville"),
				request.getParameter("mdp"));
				
			UserManager userMan = new UserManager();
			userMan.ajoutUser(user);
			this.getServletContext().getRequestDispatcher("/WEB-INF/pageCnx.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/creationProfil.jsp").forward(request, response);
		}
	}

}
