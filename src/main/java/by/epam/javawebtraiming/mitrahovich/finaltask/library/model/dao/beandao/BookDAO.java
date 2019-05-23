package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao;

import java.sql.Connection;
import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;

public interface BookDAO extends DAO {
	public List<Book> getAllFreeBook() throws DaoSQLExcetion;

	public void minusInstanceByDeleteUser(int idUser) throws DaoSQLExcetion;

	public void minusInstanceByDeleteUserTransaction(Connection connection, int idUser) throws DaoSQLExcetion;
}
