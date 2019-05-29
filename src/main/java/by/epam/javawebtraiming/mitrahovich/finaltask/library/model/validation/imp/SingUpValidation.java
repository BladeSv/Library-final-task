package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.AbstractValidation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class SingUpValidation extends AbstractValidation {

	public SingUpValidation() {

	}

	@Override
	public boolean vadidate(HttpServletRequest request) {
		if (request == null) {
			return false;
		}
		String login = request.getParameter(ConstConteiner.LOGIN);
		String password = request.getParameter(ConstConteiner.PASSWORD);
		int loginMix = ConstConteiner.LOGIN_LENGTH_MIN;
		int loginMax = ConstConteiner.LOGIN_LENGTH_MAX;
		int PassMix = ConstConteiner.PASSWORD_LENGTH_MIN;
		int PassMax = ConstConteiner.LOGIN_LENGTH_MAX;

		Pattern p = Pattern.compile(ConstConteiner.SINGUP_LOGIN_REGEX);
		Matcher m = p.matcher(login);
		return login.length() >= loginMix && login.length() <= loginMax && m.matches() && password.length() >= PassMix
				&& password.length() <= PassMax;
	}

}
