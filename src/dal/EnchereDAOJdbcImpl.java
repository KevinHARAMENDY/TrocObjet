package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bo.ArticlesVendu;
import bo.Categories;
import bo.Encheres;
import bo.Utilisateurs;

/**
 * @author Thomas
 * 
 * classe EnchereDAOJdbcImpl pour requête à la BDD
 *
 */
public class EnchereDAOJdbcImpl implements EnchereDAO {
	private static final String SELECT_ALL_ID_USER = "SELECT * FROM ENCHERES WHERE no_utilisateur=?;";
	private static final String SELECT_USER_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
	private static final String SELECT_ARTICLE_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=?";
	private static final String SELECT_CATEG_ID = "SELECT * FROM CATEGORIES WHERE no_categorie=?";
	private static final String SELECT_MAX_SOMME = "SELECT no_article, MAX(montant_enchere) AS MaxSomme FROM ENCHERES GROUP BY no_article;";
	private static final String SELECT_MAX_ENCHERE = "SELECT * FROM ENCHERES WHERE montant_enchere=? AND no_utilisateur=?;";
	private static final String SELECT_ENCHERE =
	
	"SELECT e.no_utilisateur as id_utilisateur, e.no_article as id_article, e.date_enchere as dateEnchere, e.montant_enchere as montantEnchere,	u.pseudo as pseudo_utilisateur, u.telephone as telephone_utilisateur,a.nom_article as article_nom, a.description as article_description, a.date_fin_encheres as article_dateFin, a.prix_initial as article_prixinit , a.prix_vente as article_prixVendu, a.no_categorie as article_noCategorie,	c.libelle as categorie_libelle	FROM((encheres e left join utilisateurs u on (e.no_utilisateur = u.no_utilisateur))	left join articles_vendus a on e.no_article = a.no_article)	left join categories c on a.no_categorie = c.no_categorie WHERE e.no_article = ?;";
	
	private static final String UPDATE_ENCHERE = "update encheres SET montant_enchere = ?, date_enchere = getdate() WHERE no_article = ?;";
	
	@Override
	public List<Encheres> selectAllId(int id) {
		List<Encheres> encheres = new ArrayList<>();
		Utilisateurs user = null;
		ArticlesVendu article = null;
		Categories categ = null;
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_ID_USER);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next() ) {
				PreparedStatement ps = cnx.prepareStatement(SELECT_USER_ID);
				ps.setInt(1, rs.getInt(1));
				ResultSet r = ps.executeQuery();
				while(r.next()) {
					user = new Utilisateurs(r.getInt(1), r.getString(2), r.getString(3),
							r.getString(4), r.getString(5), r.getString(6), r.getString(7), 
							r.getString(8), r.getString(9), r.getInt(11), r.getBoolean(12));
				}
				
				PreparedStatement pr = cnx.prepareStatement(SELECT_ARTICLE_ID);
				pr.setInt(1, rs.getInt(2));
				ResultSet re = pr.executeQuery();
				while(re.next()) {
					PreparedStatement pt = cnx.prepareStatement(SELECT_CATEG_ID);
					pt.setInt(1, re.getInt(9));
					ResultSet rt = pt.executeQuery();
					while(rt.next()) {
						categ = new Categories(rt.getInt(1), rt.getString(2));
					}
					
					article = new ArticlesVendu(re.getInt(1), re.getString(2), re.getString(3),
							new Date(re.getDate(4).getTime()), new Date(re.getDate(5).getTime()),
							re.getInt(6), re.getInt(7), user, categ);
				}
				
				encheres.add(new Encheres(user, article, new Date(rs.getDate(3).getTime()), rs.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encheres;
	}

	
	@Override
	public List<Encheres> selectAllPlusGrand(int id) {
		List<Integer> max = new ArrayList<>();
		List<Encheres> encheres = new ArrayList<>();
		
		Utilisateurs user = null;
		ArticlesVendu article = null;
		Categories categ = null;
		
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pm = cnx.prepareStatement(SELECT_MAX_SOMME);
			ResultSet rl = pm.executeQuery();
			while (rl.next()) {
				max.add(rl.getInt(2));
			}
			
			for (int i : max) {
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_MAX_ENCHERE);
				pstmt.setInt(1, i);
				pstmt.setInt(2, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next() ) {
					PreparedStatement ps = cnx.prepareStatement(SELECT_USER_ID);
					ps.setInt(1, rs.getInt(1));
					ResultSet r = ps.executeQuery();
					while(r.next()) {
						user = new Utilisateurs(r.getInt(1), r.getString(2), r.getString(3),
								r.getString(4), r.getString(5), r.getString(6), r.getString(7), 
								r.getString(8), r.getString(9), r.getInt(11), r.getBoolean(12));
					}
					
					PreparedStatement pr = cnx.prepareStatement(SELECT_ARTICLE_ID);
					pr.setInt(1, rs.getInt(2));
					ResultSet re = pr.executeQuery();
					while(re.next()) {
						PreparedStatement pt = cnx.prepareStatement(SELECT_CATEG_ID);
						pt.setInt(1, re.getInt(9));
						ResultSet rt = pt.executeQuery();
						while(rt.next()) {
							categ = new Categories(rt.getInt(1), rt.getString(2));
						}
						
						article = new ArticlesVendu(re.getInt(1), re.getString(2), re.getString(3),
								new Date(re.getDate(4).getTime()), new Date(re.getDate(5).getTime()),
								re.getInt(6), re.getInt(7), user, categ);
					}
					
					encheres.add(new Encheres(user, article, new Date(rs.getDate(3).getTime()), rs.getInt(4)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return encheres;
	}

	
	/**
	 * select une enchère suivant numéro d'article
	 * dans la DAL
	 * @return une enchere avec l'utilisateur et l'article
	 */
	@Override
	public Encheres selectEnchereByNoArticle(int noArticle) {
		Encheres enchere =null;
		Utilisateurs utilisateur=null;
		ArticlesVendu article=null;
		Categories categorie = null;
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ENCHERE);
			pstmt.setInt(1, noArticle);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				categorie = new Categories(rs.getInt("article_noCategorie"),
											rs.getString("categorie_libelle"));
				utilisateur = new Utilisateurs(rs.getInt("id_utilisateur"),
												rs.getString("pseudo_utilisateur"), 
												rs.getString("telephone_utilisateur"));
				article = new ArticlesVendu(rs.getInt("id_article"),rs.getString("article_nom"), 
											rs.getString("article_description"), 
											rs.getDate("article_dateFin"), rs.getInt("article_prixinit"), 
											rs.getInt("article_prixVendu"), categorie);
				
				enchere = new Encheres(utilisateur, article, rs.getDate("dateEnchere"));

			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return enchere;
	}
	
	/**
	 * Méthode qui met à jour le montant de l'enchere et la date
	 * suivant le numéro d'article
	 */
	@Override
	public void updateEnchere(Encheres enchere) {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_ENCHERE);
			pstmt.setInt(1, enchere.getMontant_enchere());
			//pstmt.setDate(2, java.sql.Date.valueOf(new Date()));
			pstmt.setInt(2, enchere.getArticle().getNoArticle());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}


