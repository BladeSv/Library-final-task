package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao;

import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Order;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.PlaceType;

public interface OrderDAO extends DAO {
	public int add(int userId, int bookId, PlaceType place) throws DaoSQLExcetion;

	public List<Order> getAllOrderUserById(int userId) throws DaoSQLExcetion;

}
