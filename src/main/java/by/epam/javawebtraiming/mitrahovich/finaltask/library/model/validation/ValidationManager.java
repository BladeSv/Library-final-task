package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp.GenreValidation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp.LoginValidation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.imp.SingUpValidation;

public class ValidationManager {
	private static ValidationManager manager = new ValidationManager();
	private LoginValidation loginValidation = new LoginValidation();

	private SingUpValidation singUpValidation = new SingUpValidation();

	private GenreValidation genreValidation = new GenreValidation();

	private ValidationManager() {

	}

	public static ValidationManager getInstance() {
		return manager;
	}

	public LoginValidation getLoginValidation() {
		return loginValidation;
	}

	public SingUpValidation getSingUpValidation() {
		return singUpValidation;
	}

	public GenreValidation getGenreValidation() {
		return genreValidation;
	}

}
