package dal;

import java.util.List;

import bo.Encheres;

public interface EnchereDAO {

	public List<Encheres> selectAllId(int id);

	public List<Encheres> selectAllPlusGrand(int id);

}
