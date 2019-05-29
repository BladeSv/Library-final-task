package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.Validation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class LoginValidation implements Validation {

	public LoginValidation() {

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

		return login.length() > loginMix && login.length() < loginMax && password.length() > PassMix
				&& password.length() < PassMax;
	}

}
