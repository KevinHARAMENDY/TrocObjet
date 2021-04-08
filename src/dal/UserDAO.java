package dal;

import bo.Utilisateurs;

public interface UserDAO {
	
	public Utilisateurs selectUserByPseudoMdp(String pseudo, String mdp);
	public void insertUser(Utilisateurs user);
	public Utilisateurs selectUserByPseudo(String pseudo);


}
