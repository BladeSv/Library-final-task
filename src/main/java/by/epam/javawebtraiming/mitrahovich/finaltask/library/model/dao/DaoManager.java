package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.BookDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.OrderDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.UserDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl.BookDAOImpl;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl.OrderDAOImpl;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.impl.UserDAOImpl;

public class DaoManager {
	private static DaoManager daoFactory = new DaoManager();

	private UserDAO userDAO = new UserDAOImpl();
	private BookDAO bookDAO = new BookDAOImpl();
	private OrderDAO orderDAO = new OrderDAOImpl();

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
}
