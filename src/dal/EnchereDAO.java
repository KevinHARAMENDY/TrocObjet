package dal;

import java.sql.Array;
import java.sql.Date;

import bo.Categories;
import bo.Encheres;

public interface EnchereDAO {

	void insert(Encheres enchere);
	
	public Encheres getEncheres();
	
	public Encheres getEncheres(Categories categorie);
	
	public Encheres getEncheres(Categories categorie, Array recherche);
	
	public void insertEnchere(int noUtilisateur, int noArticle, Date dateEnchere, int prix);
	public void insertArticle(String nomArticle, String description, Date debut, Date fin, int prixInitial, int noUtilisateur, int noCategorie);

	public int getNoArticle(String nomArticle);
	
}
