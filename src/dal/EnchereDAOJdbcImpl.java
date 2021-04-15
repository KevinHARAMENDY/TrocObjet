package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
	
	private static final String SELECT_ENCHERE =
	
	"SELECT e.no_utilisateur as id_utilisateur, e.no_article as id_article, e.date_enchere as dateEnchere, e.montant_enchere as montantEnchere,	u.pseudo as pseudo_utilisateur, u.telephone as telephone_utilisateur,a.nom_article as article_nom, a.description as article_description, a.date_fin_encheres as article_dateFin, a.prix_initial as article_prixinit , a.prix_vente as article_prixVendu, a.no_categorie as article_noCategorie,	c.libelle as categorie_libelle	FROM((encheres e left join utilisateurs u on (e.no_utilisateur = u.no_utilisateur))	left join articles_vendus a on e.no_article = a.no_article)	left join categories c on a.no_categorie = c.no_categorie WHERE e.no_article = ?;";
	
	private static final String UPDATE_ENCHERE = "update encheres SET montant_enchere = ?, date_enchere = getdate() WHERE no_article = ?;";

	
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
			pstmt.setInt(2, enchere.getNoArticle().getNoArticle());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
