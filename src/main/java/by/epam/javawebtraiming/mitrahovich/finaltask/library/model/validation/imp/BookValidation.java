package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.Validation;

public class BookValidation implements Validation {

	public BookValidation() {

	}

	@Override
	public boolean vadidate(HttpServletRequest request) {

		return true;
	}

}
