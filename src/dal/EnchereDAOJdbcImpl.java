package dal;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bo.Categories;
import bo.Encheres;

public class EnchereDAOJdbcImpl implements EnchereDAO {

	private static final String INSERT_ENCHERE="INSERT INTO ENCHERES (no_utilisateur,no_article,date_enchere,montant_enchere) VALUES (?,?,?,?);";
	private static final String INSERT_ARTICLE="INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_utilisateur,no_categorie) VALUES (?,?,?,?,?,?,?);";
	private static final String SELECT_NO_ARTICLE="SELECT no_article FROM ARTICLES_VENDUS WHERE nom_article = ?";
	
	@Override
	public void insert(Encheres enchere) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Encheres getEncheres() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Encheres getEncheres(Categories categorie) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Encheres getEncheres(Categories categorie, Array recherche) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insertEnchere(int noUtilisateur, int noArticle, Date dateEnchere, int prix) {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ENCHERE);
			pstmt.setInt(1, noUtilisateur);
			pstmt.setInt(2, noArticle);
			pstmt.setDate(3, dateEnchere);
			pstmt.setInt(4, prix);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void insertArticle(String nomArticle, String description, Date debut, Date fin, int prixInitial, int noUtilisateur, int noCategorie) {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE);
			pstmt.setString(1, nomArticle);
			pstmt.setString(2, description);
			pstmt.setDate(3, new Date(debut.getTime()));
			pstmt.setDate(4, new Date(fin.getTime()));
			pstmt.setInt(5, prixInitial);
			pstmt.setInt(6, noUtilisateur);
			pstmt.setInt(7, noCategorie);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getNoArticle(String nomArticle) {
		int noArticle = 0;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_NO_ARTICLE);
			pstmt.setString(1, nomArticle);
			ResultSet rs = pstmt.executeQuery();
			noArticle = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return noArticle;
	}
}
