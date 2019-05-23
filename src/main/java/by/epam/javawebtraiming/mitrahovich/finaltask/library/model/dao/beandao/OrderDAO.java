package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Order;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.PlaceType;

public interface OrderDAO extends DAO {
	public int add(int userId, int bookId, PlaceType place) throws DaoSQLExcetion;

	public List<Order> getAllOrderUserById(int userId) throws DaoSQLExcetion;

	public void uptateDateById(Date date, int id) throws DaoSQLExcetion;

	public void remote(int idOrder) throws DaoSQLExcetion;

	public void remoteByUserId(int id) throws DaoSQLExcetion;

	public void remoteByUserIdTransaction(Connection connection, int id) throws DaoSQLExcetion;

}
