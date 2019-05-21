package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search;

import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;

public interface SearchBook {
	public List<Book> search(String searchRequest) throws DaoSQLExcetion;

	public List<Book> searchAllFreeBook() throws DaoSQLExcetion;
}
