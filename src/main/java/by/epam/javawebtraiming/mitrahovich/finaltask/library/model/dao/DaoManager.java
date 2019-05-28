package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.AuthorDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.BookDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.GenreDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.OrderDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.UserDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl.AuthorDAOImpl;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl.BookDAOImpl;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl.GenreDAOImpl;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl.OrderDAOImpl;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl.UserDAOImpl;

public class DaoManager {
	private static DaoManager daoFactory = new DaoManager();

	private UserDAO userDAO = new UserDAOImpl();
	private BookDAO bookDAO = new BookDAOImpl();
	private OrderDAO orderDAO = new OrderDAOImpl();
	private GenreDAO genreDAO = new GenreDAOImpl();
	private AuthorDAO authorDAO = new AuthorDAOImpl();

	private DaoManager() {

	}

	public static DaoManager getInstance() {
		return daoFactory;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public OrderDAO getOrderDAO() {
		return orderDAO;
	}

	public GenreDAO getGenreDAO() {
		return genreDAO;
	}

	public AuthorDAO getAuthorDAO() {
		return authorDAO;
	}

}
