package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bo.ArticlesVendu;
import bo.Categories;
import bo.Encheres;
import bo.Utilisateurs;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	
	private static final String SELECT_ALL="SELECT * FROM ARTICLES_VENDUS";
	private static final String SELECT_ALL_CATEG="SELECT * FROM ARTICLES_VENDUS WHERE no_categorie=?;";
	private static final String SELECT_ALL_NUMUSER="SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur=? AND date_debut_encheres < GETDATE() AND date_fin_encheres > GETDATE();";
	private static final String SELECT_ALL_ARTICLE_ID_COURS = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=? AND date_fin_encheres > GETDATE() AND date_debut_encheres < GETDATE();";
	private static final String SELECT_ALL_ARTICLE_ID_REMPORTE="SELECT * FROM ARTICLES_VENDUS WHERE no_article=? AND date_fin_encheres < GETDATE();";
	private static final String SELECT_USER_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
	private static final String SELECT_CATEG_ID = "SELECT * FROM CATEGORIES WHERE no_categorie=?;";
	private static final String SELECT_ARTICLES_COURS = "SELECT * FROM ARTICLES_VENDUS WHERE date_fin_encheres > GETDATE();";
	private static final String SELECT_VENTES_NON_DEBUT = "SELECT * FROM ARTICLES_VENDUS WHERE date_debut_encheres > GETDATE()";
	private static final String SELECT_VENTES_FINIES = "SELECT * FROM ARTICLES_VENDUS WHERE date_fin_encheres < GETDATE();";
	
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
	public List<ArticlesVendu> selectAllArticlesCours() {
		List<ArticlesVendu> articles = new ArrayList<>();
		Utilisateurs user = null;
		Categories categ = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ARTICLES_COURS);
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
	public List<ArticlesVendu> selectAllMesVentes(int noUtilisateur) {
		List<ArticlesVendu> articles = new ArrayList<>();
		Utilisateurs user = null;
		Categories categ = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_NUMUSER);
			pstmt.setInt(1, noUtilisateur);
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
	public List<ArticlesVendu> selectAllMesVentesNonDebut(int noUtilisateur) {
		List<ArticlesVendu> articles = new ArrayList<>();
		Utilisateurs user = null;
		Categories categ = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_VENTES_NON_DEBUT);
			pstmt.setInt(1, noUtilisateur);
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
	public List<ArticlesVendu> selectAllMesVentesFinies(int noUtilisateur) {
		List<ArticlesVendu> articles = new ArrayList<>();
		Utilisateurs user = null;
		Categories categ = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_VENTES_FINIES);
			pstmt.setInt(1, noUtilisateur);
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
	public List<ArticlesVendu> selectAllMesEnchCours(List<Encheres> lstEnch) {
		List<ArticlesVendu> articles = new ArrayList<>();
		Utilisateurs user = null;
		Categories categ = null;
		
		for (Encheres ench : lstEnch) {
			try (Connection cnx = ConnectionProvider.getConnection()) {
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_ARTICLE_ID_COURS);
				pstmt.setInt(1, ench.getArticle().getNoArticle());
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return articles;
	}

	@Override
	public List<ArticlesVendu> selectAllMesEnchRemporte(List<Encheres> lstEnch) {
		List<ArticlesVendu> articles = new ArrayList<>();
		Utilisateurs user = null;
		Categories categ = null;
		
		for (Encheres ench : lstEnch) {
			try (Connection cnx = ConnectionProvider.getConnection()) {
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_ARTICLE_ID_REMPORTE);
				pstmt.setInt(1, ench.getArticle().getNoArticle());
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return articles;
	}

}
