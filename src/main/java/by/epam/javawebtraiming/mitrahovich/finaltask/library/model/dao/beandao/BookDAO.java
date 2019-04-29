package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao;

import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;

public interface BookDAO extends DAO {
	public List<Book> getAllFreeBook() throws DaoSQLExcetion;

}
