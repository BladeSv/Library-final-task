package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class IndexPageCommand extends AbstractCommand {

	public IndexPageCommand() {

	}

	@Override
	public String execute(HttpServletRequest request) {

		HttpSession session = request.getSession(true);
		String role = (String) session.getAttribute(ConstConteiner.ROLE);
		if (role.equals(ConstConteiner.ROLE_GUEST)) {

		}
		log.trace("URL indexPageCommand-" + request.getContextPath());

		return ManagerConfig.get("path.page.main");

	}

}
