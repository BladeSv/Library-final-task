package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class GoToCreateGenrePageCommand extends AbstractCommand {

	public GoToCreateGenrePageCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = null;

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();
		if (roleChecker.isAdmin(request)) {

			page = ManagerConfig.get("path.page.genre.edit");
		}

		return page;
	}

}
