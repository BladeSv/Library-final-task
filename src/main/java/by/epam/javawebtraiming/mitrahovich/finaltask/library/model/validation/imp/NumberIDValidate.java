package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.AbstractValidation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class NumberIDValidate extends AbstractValidation {

	public NumberIDValidate() {

	}

	@Override
	public boolean vadidate(HttpServletRequest request) {
		if (request == null) {
			return false;
		}
		boolean check = false;

		String idS = request.getParameter(ConstConteiner.ID);
		if (idS != null) {
			Pattern p = Pattern.compile(ConstConteiner.RUSSIAN_WORD_REGEX);
			Matcher m = p.matcher(genre);

		}

		return check;
	}

}