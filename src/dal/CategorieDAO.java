package dal;

import java.util.List;

import bo.Categories;

public interface CategorieDAO {

	public Categories selectByNom(String nom);

	public List<Categories> selectAll();

}
