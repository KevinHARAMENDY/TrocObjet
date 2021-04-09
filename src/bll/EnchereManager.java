package bll;

import java.sql.Array;
import java.sql.Date;

import bo.Categories;
import bo.Encheres;
import dal.DAOFactory;
import dal.EnchereDAO;

public class EnchereManager {
private EnchereDAO enchereDAO;
	
	public EnchereManager() {
		this.enchereDAO=DAOFactory.getEnchereDAO();
	}

	public void insert(Encheres enchere) {
	}
	
	public Encheres getEncheres() {
		return null;
	}
	
	public Encheres getEncheres(Categories categorie) {
		return null;
	}
	
	public Encheres getEncheres(Categories categorie, Array recherche) {
		return null;
	}
	
	public void insertEnchere(int noUtilisateur, int noArticle, Date dateEnchere, int prix) {
		this.enchereDAO.insertEnchere(noUtilisateur, noArticle, dateEnchere, prix);
	}
	public void insertArticle(String nomArticle, String description, Date debut, Date fin, int prixInitial, int noUtilisateur, int noCategorie) {
		this.enchereDAO.insertArticle(nomArticle, description, debut, fin, prixInitial, noUtilisateur, noCategorie);
	}

	public int getNoArticle(String nomArticle) {
		return this.enchereDAO.getNoArticle(nomArticle);
	}
}
