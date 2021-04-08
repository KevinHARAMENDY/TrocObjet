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

@WebServlet(
		urlPatterns= {
						"/CreationCompte",
						"/supprimerProfil"
		})
public class CreationCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	if(request.getServletPath().equals("/CreationCompte")) {
    		this.getServletContext().getRequestDispatcher("/WEB-INF/creationProfil.jsp").forward(request, response);
    	}
    	else if(request.getServletPath().equals("/supprimerProfil")) {
            // je récupère le pseudo dans la session en cours
    		HttpSession session = request.getSession();
            Utilisateurs utilisateurs = (Utilisateurs) session.getAttribute("User");
            String pseudo = utilisateurs.getPseudo();
            
            // je supprime le profil et invalide sa session
    		UserManager userMan = new UserManager();
    		
            if ( pseudo != null ) {
        		userMan.supprimerUser(pseudo);
        		session.invalidate();
        		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
            }else {
        		this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            }
    	}
    	
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
