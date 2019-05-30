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
		log.trace("number validation service-get id-" + idS);
		if (idS != null) {
			Pattern p = Pattern.compile(ConstConteiner.NUMBER_REGEX);
			Matcher m = p.matcher(idS);
			check = m.matches();
			log.trace("number validation service-result-" + check);
		}

		return check;
	}

}
