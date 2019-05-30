package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.BookDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.pagination.PaginationHandler;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search.SearchBook;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class SearchCommand extends AbstractCommand {

	public SearchCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if (request == null || response == null) {
			return null;
		}

		String page = null;
		String searchRequest = request.getParameter(ConstConteiner.SEARCH);
		SearchBook searchBook = ServiceFactory.getInstance().getSearchBooK();
		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();

		try {
			List<Book> books = null;
			if (searchRequest != null && searchRequest != "") {
				if (roleChecker.isAdmin(request)) {

					books = searchBook.searchAdmin(searchRequest);

				} else {

					books = searchBook.searchUser(searchRequest);
				}

				request.setAttribute(ConstConteiner.SEARCH_VALUE, searchRequest);
			} else {
				BookDAO bookDAO = DaoManager.getInstance().getBookDAO();
				if (roleChecker.isAdmin(request)) {

					books = bookDAO.getALL();
				} else {
					books = bookDAO.getAllFreeBook();

				}
			}

			PaginationHandler paginationHandler = ServiceFactory.getInstance().getPaginationHandler();
			int numberPage = paginationHandler.getNumberPage(request);
			int numberMaxPage = paginationHandler.getMaxPage(books);
			List<Book> pageBooks = (List<Book>) paginationHandler.getItemPage(books, numberPage);
			String paginationUrl = paginationHandler.getPaginationUrl(request, ConstConteiner.COMMAND_PAGE_SEARCH);

			pageBooks = ServiceFactory.getInstance().getTableHadler().getBookAnnotationProcessing(pageBooks);

			request.setAttribute(ConstConteiner.PAGINATION_NUMBER_PAGE, numberPage);
			request.setAttribute(ConstConteiner.PAGINATION_NUMBER_MAX_PAGE, numberMaxPage);
			request.setAttribute(ConstConteiner.PAGINATION_URL, paginationUrl);
			request.setAttribute(ConstConteiner.TABLE_BOOKS, pageBooks);
			page = ManagerConfig.get("path.page.main");
		} catch (DaoSQLExcetion e) {

			log.warn("try search" + e);
			page = ManagerConfig.get("path.page.bad.request");

		}

		return page;
	}

}
