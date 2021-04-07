package bll;

import javax.servlet.http.HttpServletRequest;

import bo.Utilisateurs;

public class UserManager {
	private UserDAO userDAO;

	public UserManager() {
		this.userDAO = DAOFactory.getUserDAO();
	}

	public Utilisateurs selectionnerUtilisateur(String pseudo) {
		return userDAO.selectByEmail(pseudo);
	}

	public Utilisateurs connecterUtilisateur(HttpServletRequest request) {
		// Récupération des champs du formulaire
		String pseudo = getValeurChamp(request, "pseudo");
		String motDePasse = getValeurChamp(request, "motDePasse");
		
		Utilisateurs utilisateur = new Utilisateurs();
		
		selectionnerUtilisateur(pseudo);
		
		if(motDePasse == utilisateur.getMdp()) {
			return utilisateur;
		} else {
			return null;
		}
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide ou sinon son
	 * contenu
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			throw new Exception("Merci de saisir un pseudo et un mot de passe.");
			// return null
		} else {
			return valeur;
		}
	}

}
