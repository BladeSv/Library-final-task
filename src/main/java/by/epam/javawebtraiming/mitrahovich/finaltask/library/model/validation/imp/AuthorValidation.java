package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.AbstractValidation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class AuthorValidation extends AbstractValidation {

	public AuthorValidation() {

	}

	@Override
	public boolean vadidate(HttpServletRequest request) {
		if (request == null) {
			return false;
		}
		String name = request.getParameter(ConstConteiner.AUTHOR_NAME);
		String surname = request.getParameter(ConstConteiner.AUTHOR_SURNAME);

		if (name == null || surname == null) {
			return false;
		}
		Pattern p = Pattern.compile(ConstConteiner.RUSSIAN_WORD_REGEX);
		Matcher nameM = p.matcher(name);
		Matcher surnameM = p.matcher(surname);

		return nameM.matches() && surnameM.matches();
	}

}
