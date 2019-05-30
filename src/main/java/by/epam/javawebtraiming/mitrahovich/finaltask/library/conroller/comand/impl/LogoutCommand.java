package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class LogoutCommand extends AbstractCommand {

	public LogoutCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if (request == null || response == null) {
			return null;
		}

		HttpSession session = request.getSession();
		session.invalidate();
		session = request.getSession(true);
		session.setAttribute(ConstConteiner.ROLE, ConstConteiner.ROLE_GUEST);

		return CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_SEARCH).execute(request, response);
	}

}
