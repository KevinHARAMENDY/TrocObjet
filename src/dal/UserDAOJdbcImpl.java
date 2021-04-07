package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bo.Utilisateurs;

public class UserDAOJdbcImpl implements UserDAO {
	
	private static final String SELECT_PSEUDO_MDP="SELECT * FROM UTILISATEURS WHERE pseudo=? AND mot_de_passe=?;";

	@Override
	public Utilisateurs selectUserByPseudoMdp(String pseudo, String mdp) {
		Utilisateurs user = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_PSEUDO_MDP);
			pstmt.setString(1, pseudo);
			pstmt.setString(2, mdp);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				user = new Utilisateurs(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), 
						rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), 
						rs.getBoolean(12));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
