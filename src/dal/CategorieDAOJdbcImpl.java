package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bo.Categories;

public class CategorieDAOJdbcImpl implements CategorieDAO {
	private static final String SELECT="SELECT * FROM CATEGORIES";

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
