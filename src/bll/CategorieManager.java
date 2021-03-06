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
	
	public List<Categories> afficheTout() {
		return this.categorieDAO.selectAll();
	}

	public Categories afficheParNom(String nom) {
		return this.categorieDAO.selectByNom(nom);
	}

}
