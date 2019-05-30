package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp.AuthorValidation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp.BookValidation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp.GenreValidation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp.LoginValidation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp.NumberIDValidate;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp.SingUpValidation;

public class ValidationManager {
	private static ValidationManager manager = new ValidationManager();
	private Validation loginValidation = new LoginValidation();

	private Validation singUpValidation = new SingUpValidation();

	private Validation genreValidation = new GenreValidation();
	private Validation authorValidation = new AuthorValidation();
	private Validation bookValidation = new BookValidation();
	private Validation numberIDValidate = new NumberIDValidate();

	private ValidationManager() {

	}

	public static ValidationManager getInstance() {
		return manager;
	}

	public Validation getLoginValidation() {
		return loginValidation;
	}

	public Validation getSingUpValidation() {
		return singUpValidation;
	}

	public Validation getGenreValidation() {
		return genreValidation;
	}

	public Validation getAuthorValidation() {
		return authorValidation;
	}

	public Validation getBookValidation() {
		return bookValidation;
	}

	public Validation getNumberIDValidate() {
		return numberIDValidate;
	}

}
