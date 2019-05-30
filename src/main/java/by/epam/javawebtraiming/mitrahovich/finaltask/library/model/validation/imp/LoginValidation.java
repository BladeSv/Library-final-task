package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.AbstractValidation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class LoginValidation extends AbstractValidation {

	public LoginValidation() {

	}

	@Override
	public boolean vadidate(HttpServletRequest request) {
		if (request == null) {
			return false;
		}

		String login = request.getParameter(ConstConteiner.LOGIN);
		log.trace("login-login-" + login);
		String password = request.getParameter(ConstConteiner.PASSWORD);
		log.trace("login-password-" + login);
		if (login == null || password == null) {
			return false;
		}
		int loginMix = ConstConteiner.LOGIN_LENGTH_MIN;
		int loginMax = ConstConteiner.LOGIN_LENGTH_MAX;
		int PassMix = ConstConteiner.PASSWORD_LENGTH_MIN;
		int PassMax = ConstConteiner.PASSWORD_LENGTH_MAX;

		return login.length() >= loginMix && login.length() <= loginMax && password.length() >= PassMix && password.length() <= PassMax;
	}

}
