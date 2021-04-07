package dal;

import bo.Utilisateurs;

public interface UserDAO {
	
	public Utilisateurs selectUserByPseudoMdp(String pseudo, String mdp);

}
