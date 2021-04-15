package bll;

import bo.Encheres;
import dal.DAOFactory;
import dal.EnchereDAO;

public class EnchereManager {
	private EnchereDAO enchereDAO;
	
	public EnchereManager() {
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}
		
	/**
	 * Méthode qui retourne une enchere suivant un numéro d'article
	 * 
	 * couche BLL
	 * @param noArticle
	 */
	public Encheres selectEnchereByNoArticle (int noArticle) {
		Encheres enchere = this.enchereDAO.selectEnchereByNoArticle(noArticle);
		return enchere;
	}
	
	/**
	 * Méthode qui met à jour le montant d'une enchere et la date
	 * 
	 * @param enchere
	 */
	public void updateEnchere(Encheres enchere) {
		this.enchereDAO.updateEnchere(enchere);
	}
	

}
