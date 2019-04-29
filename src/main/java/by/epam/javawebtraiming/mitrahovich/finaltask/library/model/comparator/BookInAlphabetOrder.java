package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.comparator;

import java.util.Comparator;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;

public class BookInAlphabetOrder implements Comparator<Book> {

	public BookInAlphabetOrder() {

	}

	@Override
	public int compare(Book o1, Book o2) {

		return o1.getTitle().compareToIgnoreCase(o2.getTitle());
	}

}
