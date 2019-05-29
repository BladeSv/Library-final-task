package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation;

import org.apache.log4j.Logger;

public abstract class AbstractValidation implements Validation {

	protected static Logger log;
	static {

		log = Logger.getLogger("Service");
	}

	public AbstractValidation() {

	}

}
