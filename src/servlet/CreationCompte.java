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
		if ((request.getParameter("nom") != "" || request.getParameter("pseudo") != "" ||
		  request.getParameter("prenom") != "" || request.getParameter("email") != "" ||
		  request.getParameter("tel") != "" || request.getParameter("rue") != "" ||
		  request.getParameter("cp") != "" || request.getParameter("ville") != "" ||
		  request.getParameter("mdp") != "" || request.getParameter("confirmation") != "") &&
		  (request.getParameter("mdp").equals(request.getParameter("confirmation")))) {
			Utilisateurs user = new Utilisateurs(request.getParameter("pseudo"), request.getParameter("nom"),
				request.getParameter("prenom"), request.getParameter("email"), request.getParameter("tel"),
				request.getParameter("rue"), request.getParameter("cp"), request.getParameter("ville"),
				request.getParameter("mdp"));
				
			UserManager userMan = new UserManager();
			userMan.ajoutUser(user);
			this.getServletContext().getRequestDispatcher("/WEB-INF/pageCnx.jsp").forward(request, response);
		} else {
			if (request.getParameter("mdp") != request.getParameter("confirmation")) {
				request.setAttribute("erreur", "Le mot de passe est différent de celui de la confirmation");
			} else {
				request.setAttribute("erreur", "Veuillez remplir tous les champs");
			}
			request.setAttribute("pseudo", request.getParameter("pseudo"));
			request.setAttribute("nom", request.getParameter("nom"));
			request.setAttribute("prenom", request.getParameter("prenom"));
			request.setAttribute("email", request.getParameter("email"));
			request.setAttribute("tel", request.getParameter("tel"));
			request.setAttribute("rue", request.getParameter("rue"));
			request.setAttribute("cp", request.getParameter("cp"));
			request.setAttribute("ville", request.getParameter("ville"));
			request.setAttribute("mdp", request.getParameter("mdp"));
			request.setAttribute("confirmation", request.getParameter("confirmation"));
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/creationProfil.jsp").forward(request, response);
		}
	}

}
