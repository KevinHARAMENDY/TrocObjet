package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bo.Utilisateurs;

public class UserDAOJdbcImpl implements UserDAO {
	
	private static final String SELECT_EMAIL_MDP="SELECT * FROM UTILISATEURS WHERE email=? OR pseudo=? AND mot_de_passe=?;";
	private static final String INSERT_USER="INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,0,0);";
	private static final String SELECT_PSEUDO="SELECT * FROM UTILISATEURS WHERE pseudo=?;";
	private static final String DELETE_USER = "delete from UTILISATEURS WHERE pseudo=?;";
	private static final String UPDATE_USER = "update UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? WHERE no_utilisateur = ?;";
	private static final String SELECT_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";

	@Override
	public Utilisateurs selectUserByEmailMdp(String email, String mdp) {
		Utilisateurs user = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_EMAIL_MDP);
			pstmt.setString(1, email);
			pstmt.setString(2, email);
			pstmt.setString(3, mdp);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				user = new Utilisateurs(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), 
						rs.getString(8), rs.getString(9), rs.getInt(11),rs.getBoolean(12));
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
	
	/**
	 * m??thode qui s??lectionne toutes les infos de l'utilisateur
	 *  @param pseudo
	 */
	@Override
	public Utilisateurs selectUserByPseudo(String pseudo) {
		Utilisateurs user = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_PSEUDO);
			pstmt.setString(1, pseudo);
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
	
	/**
	 * M??thode qui supprime le l'utilisateur suivant le pseudo
	 * @param pseudo
	 */
	@Override
	public void deleteUser(String pseudo) {
		try(Connection cnx = ConnectionProvider.getConnection())
		{		
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_USER);
			pstmt.setString(1, pseudo);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * M??thode qui met ?? jour l'utilisateur
	 * @param majUser
	 */
	@Override
	public void updateUser(Utilisateurs majUser) {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_USER);
			pstmt.setString(1, majUser.getPseudo());
			pstmt.setString(2, majUser.getNom());
			pstmt.setString(3, majUser.getPrenom());
			pstmt.setString(4, majUser.getEmail());
			pstmt.setString(5, majUser.getTel());
			pstmt.setString(6, majUser.getRue());
			pstmt.setString(7, majUser.getCode_postal());
			pstmt.setString(8, majUser.getVille());
			pstmt.setString(9, majUser.getMdp());
			pstmt.setInt(10, majUser.getNoUtilisateur());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateurs selectUserById(int id) {
		Utilisateurs user = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ID);
			pstmt.setInt(1, id);
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
