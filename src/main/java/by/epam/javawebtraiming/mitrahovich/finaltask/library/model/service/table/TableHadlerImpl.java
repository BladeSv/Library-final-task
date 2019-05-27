package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.table;

import java.util.List;

import org.apache.log4j.Logger;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class TableHadlerImpl implements TableHadler {
	private static Logger log;
	static {

		log = Logger.getLogger("Service.class");
	}

	private int maxBookOnPage;

	public TableHadlerImpl() {
		maxBookOnPage = Integer.parseInt(ManagerConfig.get("max.item.page"));
		log.trace("books on page=" + maxBookOnPage);
	}

	@Override
	public List<Book> getBookPage(List<Book> bookList, int numPage) {
		List<Book> pageBookList = null;
		if (bookList != null && numPage >= 1) {
			if (bookList.size() > maxBookOnPage) {
				if (numPage > getMaxPage(bookList)) {
					numPage = getMaxPage(bookList);
				}
				int maxIndex = maxBookOnPage * numPage < bookList.size() ? maxBookOnPage * numPage : bookList.size();

				pageBookList = bookList.subList(maxBookOnPage * (numPage - 1), maxIndex);

				System.out.println(pageBookList);

			} else {
				pageBookList = bookList;
			}

		}

		return pageBookList;
	}

	@Override
	public int getMaxPage(List<Book> bookList) {
		int maxPage = 1;

		if (bookList != null) {

			if (bookList.size() / maxBookOnPage >= 1) {
				maxPage = (bookList.size() % maxBookOnPage > 0) ? bookList.size() / maxBookOnPage + 1
						: bookList.size() / maxBookOnPage;
			}
		} else {
			maxPage = -1;
		}
		log.trace("Max page= " + maxPage);
		return maxPage;
	}

}
