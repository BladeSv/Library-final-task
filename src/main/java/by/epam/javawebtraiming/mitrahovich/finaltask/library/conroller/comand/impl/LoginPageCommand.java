package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.WrongLoginDateException;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Observable;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Observer;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.User;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.Validation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.ValidationManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class LoginPageCommand extends AbstractCommand {

	public LoginPageCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if (request == null || response == null) {
			return null;
		}
		String page = null;

		try {
			Validation validation = ValidationManager.getInstance().getLoginValidation();
			if (validation.vadidate(request)) {
				String login = (String) request.getParameter(ConstConteiner.LOGIN);
				String password = (String) request.getParameter(ConstConteiner.PASSWORD);

				log.trace("try login- login-" + login + ", password-" + password);
				DaoManager daoManager = DaoManager.getInstance();
				User user = daoManager.getUserDAO().login(login, password);
				log.trace("user-" + user);

				HttpSession session = request.getSession();
				session.setAttribute(ConstConteiner.ROLE, user.getRole().toString().toLowerCase());
				session.setAttribute(ConstConteiner.USER, user);
				Observable observer = (Observable) request.getServletContext().getAttribute(ConstConteiner.LIBRARY_OBSERVER);
				Observer obs = (Observer) user;
				observer.addObserver(obs);
				switch (user.getRole()) {
				case USER:

					page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_SEARCH).execute(request, response);
					break;
				case ADMIN:
					page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_SEARCH_USER).execute(request, response);
				}

			} else {
				request.setAttribute(ConstConteiner.WRONG_DATE_LOGIN, ConstConteiner.WRONG_DATE_LOGIN);
				page = ManagerConfig.get("path.page.login");

			}

		} catch (DaoSQLExcetion e) {
			log.warn("try login" + e);
			page = ManagerConfig.get("path.page.bad.request");

		} catch (WrongLoginDateException e) {
			log.warn("try login" + e);
			request.setAttribute(ConstConteiner.WRONG_DATE_LOGIN, ConstConteiner.WRONG_DATE_LOGIN);
			page = ManagerConfig.get("path.page.login");
		}

		return page;
	}

}
