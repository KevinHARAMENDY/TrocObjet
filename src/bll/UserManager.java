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
}
