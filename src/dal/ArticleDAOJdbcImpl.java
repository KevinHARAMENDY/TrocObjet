package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bo.ArticlesVendu;
import bo.Categories;
import bo.Utilisateurs;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	private static final String INSERT_ARTICLE="INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_utilisateur,no_categorie) VALUES (?,?,?,?,?,?,?);";
	private static final String SELECT_NO_ARTICLE="SELECT no_article FROM ARTICLES_VENDUS WHERE nom_article = ?";
	private static final String SELECT_ALL="SELECT * FROM ARTICLES_VENDUS WHERE date_fin_encheres >= GETDATE();";
	private static final String SELECT_ALL_NOM="SELECT * FROM ARTICLES_VENDUS WHERE date_fin_encheres >= GETDATE() AND nom_article LIKE ?;";
	private static final String SELECT_ALL_CATEG="SELECT * FROM ARTICLES_VENDUS WHERE date_fin_encheres >= GETDATE() AND no_categorie=?;";
	private static final String SELECT_BY_NOM_ARTICLE="SELECT a.nom_article, a.description, a.date_fin_encheres, a.prix_vente, c.libelle, u.pseudo FROM ARTICLES_VENDUS a INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur WHERE nom_article = ?;";
	private static final String SELECT_BY_NO_ARTICLE="SELECT a.nom_article, a.description, a.date_fin_encheres, a.prix_vente, c.libelle, u.pseudo FROM ARTICLES_VENDUS a INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur WHERE no_article = ?;";
	private static final String SELECT_CATEG_ID = "SELECT * FROM CATEGORIES WHERE no_categorie=?;";
	private static final String SELECT_USER_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";

	@Override
	public List<ArticlesVendu> selectAllArticles() {
		List<ArticlesVendu> articles = new ArrayList<>();
		Utilisateurs user = null;
		Categories categ = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				PreparedStatement ps = cnx.prepareStatement(SELECT_USER_ID);
				ps.setInt(1, rs.getInt(8));
				ResultSet r = ps.executeQuery();
				while(r.next()) {
					user = new Utilisateurs(r.getInt(1), r.getString(2), r.getString(3),
							r.getString(4), r.getString(5), r.getString(6), r.getString(7), 
							r.getString(8), r.getString(9), r.getInt(11), r.getBoolean(12));
				}

				PreparedStatement p = cnx.prepareStatement(SELECT_CATEG_ID);
				p.setInt(1, rs.getInt(9));
				ResultSet re = p.executeQuery();
				while(re.next()) {
					categ = new Categories(re.getInt(1), re.getString(2));
				}

				articles.add(new ArticlesVendu(rs.getInt(1), rs.getString(2), rs.getString(3), new Date(rs.getDate(4).getTime()), new Date(rs.getDate(5).getTime()), rs.getInt(6), rs.getInt(7), user, categ));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public List<ArticlesVendu> selectAllNomLike(String chaine) {
		List<ArticlesVendu> articles = new ArrayList<>();
		Utilisateurs user = null;
		Categories categ = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				PreparedStatement ps = cnx.prepareStatement(SELECT_USER_ID);
				ps.setInt(1, rs.getInt(8));
				ResultSet r = ps.executeQuery();
				while(r.next()) {
					user = new Utilisateurs(r.getInt(1), r.getString(2), r.getString(3),
							r.getString(4), r.getString(5), r.getString(6), r.getString(7), 
							r.getString(8), r.getString(9), r.getInt(11), r.getBoolean(12));
				}

				PreparedStatement p = cnx.prepareStatement(SELECT_CATEG_ID);
				p.setInt(1, rs.getInt(9));
				ResultSet re = p.executeQuery();
				while(re.next()) {
					categ = new Categories(re.getInt(1), re.getString(2));
				}

				if (rs.getString(2).toLowerCase().contains(chaine.toLowerCase())) {
					articles.add(new ArticlesVendu(rs.getInt(1), rs.getString(2), rs.getString(3), new Date(rs.getDate(4).getTime()), new Date(rs.getDate(5).getTime()), rs.getInt(6), rs.getInt(7), user, categ));
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
		Utilisateurs user = null;
		Categories categ = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_CATEG);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				PreparedStatement ps = cnx.prepareStatement(SELECT_USER_ID);
				ps.setInt(1, rs.getInt(8));
				ResultSet r = ps.executeQuery();
				while(r.next()) {
					user = new Utilisateurs(r.getInt(1), r.getString(2), r.getString(3),
							r.getString(4), r.getString(5), r.getString(6), r.getString(7), 
							r.getString(8), r.getString(9), r.getInt(11), r.getBoolean(12));
				}

				PreparedStatement p = cnx.prepareStatement(SELECT_CATEG_ID);
				p.setInt(1, rs.getInt(9));
				ResultSet re = p.executeQuery();
				while(re.next()) {
					categ = new Categories(re.getInt(1), re.getString(2));
				}

				articles.add(new ArticlesVendu(rs.getInt(1), rs.getString(2), rs.getString(3), new Date(rs.getDate(4).getTime()), new Date(rs.getDate(5).getTime()), rs.getInt(6), rs.getInt(7), user, categ));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return articles;
	}


	@Override
	public List<ArticlesVendu> selectAllNomCateg(String nom, int id) {
		List<ArticlesVendu> articles = new ArrayList<>();
		Utilisateurs user = null;
		Categories categ = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_CATEG);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				PreparedStatement ps = cnx.prepareStatement(SELECT_USER_ID);
				ps.setInt(1, rs.getInt(8));
				ResultSet r = ps.executeQuery();
				while(r.next()) {
					user = new Utilisateurs(r.getInt(1), r.getString(2), r.getString(3),
							r.getString(4), r.getString(5), r.getString(6), r.getString(7), 
							r.getString(8), r.getString(9), r.getInt(11), r.getBoolean(12));
				}

				PreparedStatement p = cnx.prepareStatement(SELECT_CATEG_ID);
				p.setInt(1, rs.getInt(9));
				ResultSet re = p.executeQuery();
				while(re.next()) {
					categ = new Categories(re.getInt(1), re.getString(2));
				}

				if (rs.getString(2).toLowerCase().contains(nom.toLowerCase())) {
					articles.add(new ArticlesVendu(rs.getInt(1), rs.getString(2), rs.getString(3), new Date(rs.getDate(4).getTime()), new Date(rs.getDate(5).getTime()), rs.getInt(6), rs.getInt(7), user, categ));
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

	@Override
	public ArticlesVendu getArticleByNo(int noArticle) {
		ArticlesVendu article = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_NO_ARTICLE);
			pstmt.setInt(1, noArticle);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				article = new ArticlesVendu();
				article.setNom_article(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDate_fin_encheres(rs.getDate("date_fin_encheres"));
				article.setPrix_vente(rs.getInt("prix_vente"));
				article.setUtilisateur(new Utilisateurs(rs.getString("pseudo")));
				article.setCategorie(new Categories(rs.getString("libelle")));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public ArticlesVendu getArticleByNom(String nomArticle) {
		ArticlesVendu article = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_NOM_ARTICLE);
			pstmt.setString(1, nomArticle);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				article = new ArticlesVendu();
				article.setNom_article(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDate_fin_encheres(rs.getDate("date_fin_encheres"));
				article.setPrix_vente(rs.getInt("prix_vente"));
				article.setUtilisateur(new Utilisateurs(rs.getString("pseudo")));
				article.setCategorie(new Categories(rs.getString("libelle")));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return article;
	}

}
