package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command;

import org.apache.log4j.Logger;

public abstract class AbstractCommand implements Command {

	protected static Logger log;
	static {
		log = Logger.getLogger("AbstractCommand");

	}

	public AbstractCommand() {

	}

}
