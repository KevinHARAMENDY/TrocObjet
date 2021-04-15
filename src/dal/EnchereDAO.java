package dal;

import bo.Encheres;

/**
 * classe EnchereDAO
 * @author Thomas
 *
 */
public interface EnchereDAO {

	/**
	 * Méthode qui retourne une enchere
	 * 
	 * @param noArticle
	 * @return
	 */
	public Encheres selectEnchereByNoArticle(int noArticle);

	/**
	 * Méthode qui met à jour le montant d'une enchere et la date
	 * 
	 * @param enchere
	 */
	public void updateEnchere(Encheres enchere);

}
