package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.exception;

public class LibraryException extends Exception {

	public LibraryException() {

	}

	/**
	 * @param message
	 * @param cause
	 */
	public LibraryException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param message
	 */
	public LibraryException(String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public LibraryException(Throwable cause) {
		super(cause);

	}

}
