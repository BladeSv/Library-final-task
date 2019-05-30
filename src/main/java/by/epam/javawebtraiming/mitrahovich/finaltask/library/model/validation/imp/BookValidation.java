package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.AbstractValidation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class BookValidation extends AbstractValidation {

	public BookValidation() {

	}

	@Override
	public boolean vadidate(HttpServletRequest request) {
		if (request == null) {
			return false;
		}

		String SbookNumber = request.getParameter(ConstConteiner.BOOK_NUMBER);
		String SidAuthor = request.getParameter(ConstConteiner.BOOK_AUTHOR);
		String SidGenre = request.getParameter(ConstConteiner.BOOK_GENRE);

		log.trace("validation book service-from request-SbookNumber-" + SbookNumber);
		log.trace("validation book service-from request-SidAuthor-" + SidAuthor);
		log.trace("validation book service-from request-SidGenre-" + SidGenre);

		Pattern pNum = Pattern.compile(ConstConteiner.NUMBER_REGEX);

		if (SbookNumber == null || SidAuthor == null || SidGenre == null || pNum == null) {
			return false;
		}

		Matcher SbookNumberM = pNum.matcher(SbookNumber);
		Matcher SidAuthorM = pNum.matcher(SidAuthor);
		Matcher SidGenreM = pNum.matcher(SidGenre);

		if (SbookNumberM.matches() && SidAuthorM.matches() && SidGenreM.matches()) {

			String bookTitle = request.getParameter(ConstConteiner.BOOK_TITLE);
			log.trace("validation book service-from request-bookTitle-" + bookTitle);
			String bookAnnotation = request.getParameter(ConstConteiner.BOOK_ANNOTATION);
			log.trace("validation book service-from request-bookAnnotation-" + bookAnnotation);
			Pattern p = Pattern.compile(ConstConteiner.RUSSIAN_WORD_REGEX);
			Matcher bookTitleM = p.matcher(bookTitle);

			int bookNumber = Integer.parseInt(SbookNumber);
			int idAuthor = Integer.parseInt(SidAuthor);
			int idGenre = Integer.parseInt(SidGenre);

			return bookTitleM.matches() && bookAnnotation.length() >= 1 && bookNumber > 0 && idAuthor > 0 && idGenre > 0;
		}

		return false;
	}

}
