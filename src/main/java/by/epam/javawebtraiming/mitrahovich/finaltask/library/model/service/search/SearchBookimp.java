package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.BookDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class SearchBookimp implements SearchBook {
	private static Logger log;
	static {
		log = Logger.getLogger("Service");
	}

	public SearchBookimp() {

	}

	@Override
	public List<Book> search(HttpServletRequest request) throws DaoSQLExcetion {

		String searchRequest = request.getParameter(ConstConteiner.SEARCH);
		log.trace("Search request--" + searchRequest);
		BookDAO bookDAO = DaoManager.getInstance().getBookDAO();
		List<Book> findBook = bookDAO.getAllFreeBook();

		String[] slit = searchRequest.split(ConstConteiner.SEARCH_REQUEST_SPLIT_REGEX);
		log.trace("request split on pieces--" + slit.length);
		List<String> pieces = Arrays.asList(slit);
		Arrays.asList(slit).add(searchRequest);
		Arrays.sort(slit, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return o1.length() - o2.length();
			}
		});

		List<Book> searchBook = new ArrayList();
		for (int i = 0; i < slit.length; i++) {
			for (Book book : findBook) {
				String title = book.getTitle();

				if (checkMatch(title, slit[i])) {
					searchBook.add(book);
				}

			}

		}

		return findBook;
	}

	private boolean checkMatch(String title, String searchString) {
		title.contains(searchString);
		return true;
	}

}
