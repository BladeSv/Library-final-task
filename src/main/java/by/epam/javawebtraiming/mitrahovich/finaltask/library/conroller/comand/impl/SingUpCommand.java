package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand.Do;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.WrongLoginDateException;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.RoleType;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.User;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.ValidationManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class SingUpCommand extends AbstractCommand {

	public SingUpCommand() {

	}

	@Override
	public ResultCommand execute(HttpServletRequest request, HttpServletResponse response) {
		if (request == null || response == null) {
			return null;
		}
		ResultCommand page = new ResultCommand();

		if (ValidationManager.getInstance().getSingUpValidation().vadidate(request)) {
			String login = request.getParameter(ConstConteiner.LOGIN);
			String pass = request.getParameter(ConstConteiner.PASSWORD);
			String name = request.getParameter(ConstConteiner.NAME);
			String surname = request.getParameter(ConstConteiner.SURNAME);
			RoleType role = RoleType.USER;

			try {

				User user = DaoManager.getInstance().getUserDAO().registration(login, pass, name, surname, role);
				log.trace("registration user-" + user);
				HttpSession session = request.getSession(true);
				session.setAttribute(ConstConteiner.ROLE, user.getRole().toString().toLowerCase());
				session.setAttribute(ConstConteiner.USER, user);

				page.setAction(Do.REDIRECT);
				page.setPage(ManagerConfig.get("path.page.main"));

				response.sendRedirect(request.getContextPath() + "/main?command=" + ConstConteiner.SEARCH);
			} catch (DaoSQLExcetion | IOException e) {
				log.warn("try singup" + e);
				page.setAction(Do.FORWARD);
				page.setPage(ManagerConfig.get("path.page.bad.request"));
			} catch (WrongLoginDateException e) {
				request.setAttribute(ConstConteiner.WRONG_DATE_SINGUP, ConstConteiner.WRONG_DATE_SINGUP);

				page.setAction(Do.FORWARD);
				page.setPage(ManagerConfig.get("path.page.singup"));
			}

		} else {
			request.setAttribute(ConstConteiner.WRONG_DATE_SINGUP, ConstConteiner.WRONG_DATE_SINGUP);
			page.setAction(Do.FORWARD);
			page.setPage(ManagerConfig.get("path.page.singup"));

		}
		return page;
	}

}
