package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public ResultCommand execute(HttpServletRequest request, HttpServletResponse response);

}
