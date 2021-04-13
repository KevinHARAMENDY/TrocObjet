package dal;

import bo.Utilisateurs;

public interface UserDAO {
	
	public Utilisateurs selectUserByPseudoMdp(String pseudo, String mdp);
	public void insertUser(Utilisateurs user);
	public Utilisateurs selectUserByPseudo(String pseudo);
	public void deleteUser(String pseudo);
	public void updateUser(Utilisateurs majUser);
	public Utilisateurs selectUserById(int id);


}
