package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
	public String execute(HttpServletRequest request);

}
