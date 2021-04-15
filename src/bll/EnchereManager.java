package bll;

import java.util.List;

import bo.Encheres;
import dal.DAOFactory;
import dal.EnchereDAO;

public class EnchereManager {
	private EnchereDAO enchereDAO;
	
	public EnchereManager() {
		this.enchereDAO=DAOFactory.getEnchereDAO();
	}
	
	public List<Encheres> afficheToutId(int id) {
		return this.enchereDAO.selectAllId(id);
	}

	public List<Encheres> afficheToutPlusGrand(int id) {
		return this.enchereDAO.selectAllPlusGrand(id);
	}
}
