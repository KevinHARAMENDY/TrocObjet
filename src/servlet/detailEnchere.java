package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.EnchereManager;
import bo.ArticlesVendu;
import bo.Encheres;
import bo.Utilisateurs;

/**
 * Servlet implementation class detailEnchere
 */
@WebServlet("/detailEnchere")
public class detailEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// je récupère le numéro de l'article passé dans la requête
		int noArticle = 0;
		
		if(request.getParameter("idArticle")!=null)
		{ 
			  noArticle = Integer.parseInt(request.getParameter("idArticle"));
		}
		 
// enlever et mettre le lien pour récupérer le numéro en requete ci-dessus
		//noArticle =13;
		
		// je crée une instance enchere et récupère en BDD
		EnchereManager enchereMan = new EnchereManager();
		Encheres enchere = enchereMan.selectEnchereByNoArticle(noArticle);
		
		// je passe enchere dans la requête pour la jsp
		if(enchere != null) {
			request.setAttribute("enchere", enchere);
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailsEnchere.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO voir les cas : je récupère l'id noUtilisateurs si connecté
		HttpSession session = request.getSession();
		Utilisateurs userSession = (Utilisateurs) session.getAttribute("User");
		Utilisateurs noUtilisateurs = new Utilisateurs(userSession.getNoUtilisateur());
				
		// je récupère le champ du formulaire
		String maProposition = request.getParameter("maProposition");
		
// TODO: vérifier si proposition est sup au montant enchere
		
		// je récupère le numéro de l'article passé dans la requête
		int noArticle = 0;
		if(request.getParameter("idArticle")!="")
		{
			noArticle = Integer.parseInt(request.getParameter("idArticle"));
		}
		ArticlesVendu article = new ArticlesVendu(noArticle);
		
		// j'hydrate newEncheres
		Encheres newEncheres = new Encheres();
		newEncheres.setNoArticle(article);
		newEncheres.setMontant_enchere(Integer.parseInt(maProposition));
		newEncheres.setNoUtilisateur(noUtilisateurs);

		// je mets à jour l'enchere
		EnchereManager enchereMan = new EnchereManager();
		enchereMan.updateEnchere(newEncheres);
// faire vérification si c'est le même enchérisseur

		// je redirige vers l'accueil
		this.getServletContext().getRequestDispatcher("/WEB-INF/monProfil.jsp").forward(request, response);
	}

}
