package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search.SearchBook;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search.SearchBookimp;

public class ServiceFactory {
	private static ServiceFactory factory = new ServiceFactory();
	private SearchBook searchBook = new SearchBookimp();

	public ServiceFactory() {

	}

	public static ServiceFactory getInstance() {
		return factory;

	}

	public SearchBook getSearchBoo() {
		return searchBook;

	}
}
