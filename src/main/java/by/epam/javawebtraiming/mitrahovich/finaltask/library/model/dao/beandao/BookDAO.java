package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao;

import java.sql.Connection;
import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;

public interface BookDAO extends DAO<Book> {

	void add(String title, String annotation, int idAuthor, int idGenre, int instance) throws DaoSQLExcetion;

	void update(int idBook, String title, String annotation, int idAuthor, int idGenre, int instance)
			throws DaoSQLExcetion;

	List<Book> getAllFreeBook() throws DaoSQLExcetion;

	int getInstanceById(int id) throws DaoSQLExcetion;

	void removeById(int id) throws DaoSQLExcetion;

	void minusInstanceByDeleteUser(int idUser) throws DaoSQLExcetion;

	void minusInstanceByDeleteUserTransaction(Connection connection, int idUser) throws DaoSQLExcetion;
}
