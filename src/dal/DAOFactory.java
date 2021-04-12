package dal;

public abstract class DAOFactory {
	private static UserDAO userDao;
	private static EnchereDAO enchereDao;
	private static ArticleDAO articleDao;
	private static CategorieDAO categorieDao;
	
	public static UserDAO getUserDAO()
	{
		if (userDao==null) {
			userDao = new UserDAOJdbcImpl();
		}
		return userDao;
	}
	
	public static EnchereDAO getEnchereDAO() 
	{
		if (enchereDao==null) {
			enchereDao = new EnchereDAOJdbcImpl();
		}
		return enchereDao;
	}
	
	public static ArticleDAO getArticleDAO()
	{
		if (articleDao==null) {
			articleDao = new ArticleDAOJdbcImpl();
		}
		return articleDao;
	}
	
	public static CategorieDAO getCategorieDAO()
	{
		if (categorieDao==null) {
			categorieDao = new CategorieDAOJdbcImpl();
		}
		return categorieDao;
	}
}
