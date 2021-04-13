package bll;

import bo.Utilisateurs;
import dal.DAOFactory;
import dal.UserDAO;

public class UserManager {
	private UserDAO userDAO;
	
	public UserManager() {
		this.userDAO=DAOFactory.getUserDAO();
	}

	public Utilisateurs afficheParPseudoMdp(String pseudo, String mdp) {
		Utilisateurs user = this.userDAO.selectUserByPseudoMdp(pseudo,mdp);
		return user;
	}
	
	public void ajoutUser(Utilisateurs user) {
		this.userDAO.insertUser(user);
	}
	
	/**
	 * Méthode qui retourne l'utilisateur
	 * @param pseudo
	 * 
	 */
	public Utilisateurs selectByPseudo(String pseudo) {
		Utilisateurs user = this.userDAO.selectUserByPseudo(pseudo);
		return user;
	}
	
	public Utilisateurs afficheParId(int id) {
		return this.userDAO.selectUserById(id);
	}
	
	/**
	 * Méthode qui supprime l'utilisateur
	 * @param pseudo
	 */
	public void supprimerUser(String pseudo) {
		this.userDAO.deleteUser(pseudo);
	}
	
	/**
	 * Méthode pour mettre à jour l'utilisateur
	 * @param majUser
	 */
	public void updateUser(Utilisateurs majUser) {
		this.userDAO.updateUser(majUser);
	}
}
