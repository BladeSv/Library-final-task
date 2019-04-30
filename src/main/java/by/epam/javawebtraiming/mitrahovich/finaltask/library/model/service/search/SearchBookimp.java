package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

		List<Book> findBook = searchAllFreeBook();

		String[] split = searchRequest.split(ConstConteiner.SEARCH_REQUEST_SPLIT_REGEX);
		log.trace("request split on pieces--" + split.length + " pieces--" + split.toString());
		List<String> pieces = new ArrayList<>(Arrays.asList(split));
		pieces.add(searchRequest);

		Collections.sort(pieces, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return o1.length() - o2.length();
			}
		});

		Set<Book> searchBook = new HashSet<>();

		for (String splits : pieces) {
			for (Book book : findBook) {
				String title = book.getTitle();

				if (checkMatch(title, splits)) {
					searchBook.add(book);

				}

			}

		}

		return new ArrayList<>(searchBook);
	}

	private boolean checkMatch(String title, String searchString) {
		log.trace("check contins--in--" + title + " piece--" + searchString);
		return title.toLowerCase().contains(searchString.toLowerCase());
	}

	@Override
	public List<Book> searchAllFreeBook() throws DaoSQLExcetion {
		BookDAO bookDAO = DaoManager.getInstance().getBookDAO();
		List<Book> findBook = bookDAO.getAllFreeBook();

		return findBook;
	}

}
