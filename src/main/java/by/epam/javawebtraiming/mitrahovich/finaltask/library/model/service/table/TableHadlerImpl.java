package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.table;

import java.util.List;

import org.apache.log4j.Logger;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class TableHadlerImpl implements TableHadler {
	private static Logger log;
	static {

		log = Logger.getLogger("Service.class");
	}

	public TableHadlerImpl() {

	}

	@Override
	public List<Book> getBookAnnotationProcessing(List<Book> bookListe) {

		if (bookListe == null) {
			return null;
		}

		for (Book book : bookListe) {

			if (book.getAnnotation() != null && book.getAnnotation().length() > ConstConteiner.PASSWORD_LENGTH_MAX) {
				int lastIndex = book.getAnnotation().lastIndexOf(" ", ConstConteiner.PASSWORD_LENGTH_MAX);
				String newannotation = book.getAnnotation().substring(0, lastIndex) + "...";
				book.setAnnotation(newannotation);
				log.trace("getBookAnnotationProcessing - new annotation book-" + newannotation);
			}
		}

		return bookListe;
	}

}
