package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.Validation;

public class SingUpValidation implements Validation {

	public SingUpValidation() {

	}

	@Override
	public boolean vadidate(HttpServletRequest request) {

		return true;
	}

}
