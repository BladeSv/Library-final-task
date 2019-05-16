package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.table;

import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;

public interface TableHadler {
	List<Book> getBookPage(List<Book> bookList, int numPage);

	int getMaxPage(List<Book> bookList);

}
