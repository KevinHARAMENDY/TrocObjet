package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bo.Utilisateurs;

public class UserDAOJdbcImpl implements UserDAO {
	
	private static final String SELECT_PSEUDO_MDP="SELECT * FROM UTILISATEURS WHERE pseudo=? AND mot_de_passe=?;";
	private static final String INSERT_USER="INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,0,0);";

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

	@Override
	public void insertUser(Utilisateurs user) {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_USER);
			pstmt.setString(1, user.getPseudo());
			pstmt.setString(2, user.getNom());
			pstmt.setString(3, user.getPrenom());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getTel());
			pstmt.setString(6, user.getRue());
			pstmt.setString(7, user.getCode_postal());
			pstmt.setString(8, user.getVille());
			pstmt.setString(9, user.getMdp());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
