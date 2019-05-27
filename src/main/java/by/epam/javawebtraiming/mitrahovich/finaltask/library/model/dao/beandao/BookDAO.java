package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao;

import java.sql.Connection;
import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;

public interface BookDAO extends DAO {
	List<Book> getAllFreeBook() throws DaoSQLExcetion;

	void removeById(int id) throws DaoSQLExcetion;

	void minusInstanceByDeleteUser(int idUser) throws DaoSQLExcetion;

	void minusInstanceByDeleteUserTransaction(Connection connection, int idUser) throws DaoSQLExcetion;
}
