package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.Validation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class BookValidation implements Validation {

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

		Pattern pNum = Pattern.compile(ConstConteiner.NUMBER_REGEX);
		Matcher SbookNumberM = pNum.matcher(SbookNumber);
		Matcher SidAuthorM = pNum.matcher(SidAuthor);
		Matcher SidGenreM = pNum.matcher(SidGenre);

		if (SbookNumberM.matches() && SidAuthorM.matches() && SidGenreM.matches()) {

			String bookTitle = request.getParameter(ConstConteiner.BOOK_TITLE);
			String bookAnnotation = request.getParameter(ConstConteiner.BOOK_ANNOTATION);
			Pattern p = Pattern.compile(ConstConteiner.RUSSIAN_WORD_REGEX);
			Matcher bookTitleM = p.matcher(bookTitle);
			Matcher bookAnnotationM = p.matcher(bookAnnotation);
			int bookNumber = Integer.parseInt(SbookNumber);
			int idAuthor = Integer.parseInt(SidAuthor);
			int idGenre = Integer.parseInt(SidGenre);

			return bookTitleM.matches() && bookAnnotationM.matches() && bookNumber > 0 && idAuthor > 0 && idGenre > 0;
		}

		return false;
	}

}
