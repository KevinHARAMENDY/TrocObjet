package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bo.ArticlesVendu;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	
	private static final String INSERT_ARTICLE="INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_utilisateur,no_categorie) VALUES (?,?,?,?,?,?,?);";
	private static final String SELECT_NO_ARTICLE="SELECT no_article FROM ARTICLES_VENDUS WHERE nom_article = ?";
	private static final String SELECT_ALL="SELECT * FROM ARTICLES_VENDUS WHERE date_fin_encheres >= GETDATE();";
	private static final String SELECT_ALL_NOM="SELECT * FROM ARTICLES_VENDUS WHERE date_fin_encheres >= GETDATE() AND nom_article LIKE ?;";
	private static final String SELECT_ALL_CATEG="SELECT * FROM ARTICLES_VENDUS WHERE date_fin_encheres >= GETDATE() AND no_categorie=?;";

	@Override
	public List<ArticlesVendu> selectAllArticles() {
		List<ArticlesVendu> articles = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				articles.add(new ArticlesVendu(rs.getInt(1), rs.getString(2), rs.getString(3), new Date(rs.getDate(4).getTime()), new Date(rs.getDate(5).getTime()), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<ArticlesVendu> selectAllNomLike(String chaine) {
		List<ArticlesVendu> articles = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				if (rs.getString(2).toLowerCase().contains(chaine.toLowerCase())) {
					articles.add(new ArticlesVendu(rs.getInt(1), rs.getString(2), rs.getString(3), new Date(rs.getDate(4).getTime()), new Date(rs.getDate(5).getTime()), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<ArticlesVendu> selectAllCateg(int id) {
		List<ArticlesVendu> articles = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_CATEG);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				articles.add(new ArticlesVendu(rs.getInt(1), rs.getString(2), rs.getString(3), new Date(rs.getDate(4).getTime()), new Date(rs.getDate(5).getTime()), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<ArticlesVendu> selectAllNomCateg(String nom, int id) {
		List<ArticlesVendu> articles = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_CATEG);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				if (rs.getString(2).toLowerCase().contains(nom.toLowerCase())) {
					articles.add(new ArticlesVendu(rs.getInt(1), rs.getString(2), rs.getString(3), new Date(rs.getDate(4).getTime()), new Date(rs.getDate(5).getTime()), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public void insertArticle(String nomArticle, String description, Date debut, Date fin, int prixInitial, int noUtilisateur, int noCategorie) {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLE);
			pstmt.setString(1, nomArticle);
			pstmt.setString(2, description);
			pstmt.setDate(3, new java.sql.Date(debut.getTime()));
			pstmt.setDate(4, new java.sql.Date(fin.getTime()));
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
