package bll;

import java.util.List;

import bo.Categories;
import dal.CategorieDAO;
import dal.DAOFactory;

public class CategorieManager {

private CategorieDAO categorieDAO;
	
	public CategorieManager() {
		this.categorieDAO=DAOFactory.getCategorieDAO();
	}
	
	public List<Categories> selectCategorie() {
		return this.categorieDAO.getCategorie();
	}
}
