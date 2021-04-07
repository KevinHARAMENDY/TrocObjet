package dal;

public abstract class DAOFactory {
	private static UserDAO userDao;
	
	public static UserDAO getUserDAO()
	{
		if (userDao==null) {
			userDao = new UserDAOJdbcImpl();
		}
		return userDao;
	}
}
