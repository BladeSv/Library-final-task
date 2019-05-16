package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search.SearchBook;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.table.TableHadler;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class SearchCommand extends AbstractCommand {

	public SearchCommand() {

	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = ManagerConfig.get("path.page.main");
		String searchRequest = request.getParameter(ConstConteiner.SEARCH);
		SearchBook searchBook = ServiceFactory.getInstance().getSearchBoo();
		try {
			List<Book> books = null;
			if (searchRequest != null && searchRequest != "") {

				books = searchBook.search(request);
				request.setAttribute(ConstConteiner.SEARCH_VALUE, searchRequest);

			} else {
				books = searchBook.searchAllFreeBook();
			}
			int numberPage = ServiceFactory.getInstance().getPageHandler().getNumberPage(request);
			TableHadler tableHadler = ServiceFactory.getInstance().getTableHadler();
			int numberMaxPage = tableHadler.getMaxPage(books);
			books = tableHadler.getBookPage(books, numberPage);

			request.setAttribute(ConstConteiner.PAGINATION_NUMBER_PAGE, numberPage);
			request.setAttribute(ConstConteiner.PAGINATION_NUMBER_MAX_PAGE, numberMaxPage);

			String paginationUrl = request.getRequestURI() + "?" + ConstConteiner.SEARCH + "=" + searchRequest + "&"
					+ ConstConteiner.COMMAND + "=" + ConstConteiner.COMMAND_PAGE_SEARCH + "&" + ConstConteiner.PAGE
					+ "=";
			System.err.println(paginationUrl + " " + request.getContextPath());

			request.setAttribute(ConstConteiner.PAGINATION_URL, paginationUrl);
			request.setAttribute(ConstConteiner.TABLE_BOOKS, books);
		} catch (DaoSQLExcetion e) {

			log.warn("try search" + e);
			page = ManagerConfig.get("path.page.bad.request");

		}

		return page;
	}

}
