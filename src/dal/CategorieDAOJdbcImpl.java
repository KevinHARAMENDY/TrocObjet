package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bo.Categories;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	private static final String SELECT="SELECT * FROM CATEGORIES";
	private static final String SELECT_ALL="SELECT * FROM CATEGORIES;";
	private static final String SELECT_ALL_NOM="SELECT * FROM CATEGORIES WHERE libelle=?;";

	@Override
	public List<Categories> selectAll() {
		List<Categories> categs = new ArrayList<>();
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				categs.add(new Categories(rs.getInt(1), rs.getString(2)));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return categs;
	}
	
	@Override
	public Categories selectByNom(String nom) {
		Categories categ = null;
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_NOM);
			pstmt.setString(1, nom);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				categ = new Categories(rs.getInt(1), rs.getString(2));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return categ;
	}
	
	@Override
	public List<Categories> getCategorie() {
		List<Categories> result = new ArrayList<Categories>();

		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				result.add(new Categories(rs.getInt(1), rs.getString(2)));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
