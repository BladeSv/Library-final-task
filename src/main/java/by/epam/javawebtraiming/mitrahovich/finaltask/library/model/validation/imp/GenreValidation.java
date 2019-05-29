package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.Validation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class GenreValidation implements Validation {

	public GenreValidation() {

	}

	@Override
	public boolean vadidate(HttpServletRequest request) {
		if (request == null) {
			return false;
		}
		String genre = request.getParameter(ConstConteiner.GENRE_TITLE);
		Pattern p = Pattern.compile(ConstConteiner.RUSSIAN_WORD_REGEX);
		Matcher m = p.matcher(genre);

		return m.matches();
	}

}
