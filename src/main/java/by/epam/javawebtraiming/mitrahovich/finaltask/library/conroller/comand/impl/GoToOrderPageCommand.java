package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class GoToOrderPageCommand extends AbstractCommand {

	public GoToOrderPageCommand() {

	}

	@Override
	public String execute(HttpServletRequest request) {

		String page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_INDEX).execute(request);
		HttpSession session = request.getSession(true);
		String role = (String) session.getAttribute(ConstConteiner.ROLE);
		if (role == ConstConteiner.ROLE_USER || role == ConstConteiner.ROLE_ANDMIN) {

			page = ManagerConfig.get("path.page.order");
		}
		return page;
	}

}
