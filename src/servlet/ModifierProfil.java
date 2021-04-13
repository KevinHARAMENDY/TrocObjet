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

/**
 * Servlet implementation class ModifierProfil
 */
@WebServlet("/modifierProfil")
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierProfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateurs userEnBDD = new Utilisateurs();
		UserManager userMan = new UserManager();

		// je récupère l'utilisateur en cours
		HttpSession session = request.getSession();
		Utilisateurs userSession = (Utilisateurs) session.getAttribute("User");

		// je récupère le mdp utilisateur en BDD pour comparer avec le champs
		userEnBDD = userMan.selectByPseudo(userSession.getPseudo());
		String mdpEnBDD = userEnBDD.getMdp();
		int idUtilisateurs = userEnBDD.getNoUtilisateur();
		Boolean isAdmin = userEnBDD.isAdmin();

		System.out.println(mdpEnBDD);

		// je récupère les champs du formulaire
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String passwordActuel = request.getParameter("passwordActuel");
		String newPassword = request.getParameter("newPassword");
		String confirmationPassword = request.getParameter("confirmationPassword");

		// je modifie l'utilisateur
		Utilisateurs user = new Utilisateurs();
		user.setPseudo(pseudo);
		user.setNom(nom);
		user.setPrenom(prenom);
		user.setEmail(email);
		user.setTel(telephone);
		user.setRue(rue);
		user.setVille(ville);
		user.setCode_postal(cp);
		user.setAdmin(isAdmin);
		user.setNoUtilisateur(idUtilisateurs);
		user.setMdp(passwordActuel);

		// vérification changement mot de passe
		if ((newPassword != "" || confirmationPassword != "") && newPassword.equals(confirmationPassword)) {
			user.setMdp(newPassword);
		} else if ((newPassword != "" || confirmationPassword != "")) {
			request.setAttribute("erreur", "Nouveau mot de passe incorrect");
			// je garde dans l'input les données rentrées
			request.setAttribute("User", user);
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierProfil.jsp").forward(request, response);
			return;
		}

		// vérification mot de passe actuel
		if (passwordActuel.equals(mdpEnBDD)) {
			// je modifie en base et redirige vers les pages
			UserManager userManUpdate = new UserManager();
			userManUpdate.updateUser(user);

			// maj session sans mdp
			user.setMdp("");
			session.setAttribute("User", user);
			// message succès
			request.setAttribute("succes", "Profil modifié");
			// redirection si ok
			this.getServletContext().getRequestDispatcher("/WEB-INF/monProfil.jsp").forward(request, response);
			return;
		} else {
			request.setAttribute("erreur", "Le mot de passe est incorrect");
			// je garde dans l'input les données rentrées
			request.setAttribute("User", user);
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierProfil.jsp").forward(request, response);
			return;
		}
	}
}
