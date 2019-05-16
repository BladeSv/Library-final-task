package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.table;

import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class TableHadlerImpl implements TableHadler {

	private int maxBookOnPage;

	public TableHadlerImpl() {
		maxBookOnPage = Integer.parseInt(ManagerConfig.get("max.book.page"));
	}

	@Override
	public List<Book> getBookPage(List<Book> bookList, int numPage) {
		List<Book> pageBookList = null;
		if (bookList != null && numPage >= 1) {
			if (bookList.size() > maxBookOnPage) {
				if (numPage > getMaxPage(bookList)) {
					numPage = getMaxPage(bookList);
				}
				int maxIndex = maxBookOnPage * numPage < bookList.size() ? maxBookOnPage * numPage - 1
						: bookList.size() - 1;
				pageBookList = bookList.subList(maxBookOnPage * (numPage - 1), maxIndex);

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

			if (bookList.size() / maxBookOnPage > 1) {
				maxPage = (maxPage % maxBookOnPage > 0) ? maxPage / maxBookOnPage + 1 : maxPage / maxBookOnPage;
			}
		} else {
			maxPage = -1;
		}
		return maxPage;
	}

}
