package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search.SearchBook;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class MainPageCommand extends AbstractCommand {

	public MainPageCommand() {

	}

	@Override
	public String execute(HttpServletRequest request) {

		log.trace("URL indexPageCommand-" + request.getContextPath());

		String page = ManagerConfig.get("path.page.main");
		String searchRequest = request.getParameter(ConstConteiner.SEARCH);

		SearchBook searchBook = ServiceFactory.getInstance().getSearchBoo();

		try {
			List<Book> books = searchBook.searchAllFreeBook();
			request.setAttribute(ConstConteiner.TABLE_BOOKS, books);

		} catch (DaoSQLExcetion e) {

			log.warn("try search" + e);
			page = ManagerConfig.get("path.page.bad.request");

		}

		return page;

	}

}
