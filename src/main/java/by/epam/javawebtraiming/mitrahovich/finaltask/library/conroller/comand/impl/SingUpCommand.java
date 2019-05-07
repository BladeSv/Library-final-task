package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.WrongLoginDateException;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.RoleType;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.User;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.Validation;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.ValidationManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class SingUpCommand extends AbstractCommand {

	public SingUpCommand() {

	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		if (ValidationManager.getInstance().getLoginValidation().vadidate(request)) {
			String login = request.getParameter(ConstConteiner.LOGIN);
			String pass = request.getParameter(ConstConteiner.PASSWORD);
			String name = request.getParameter(ConstConteiner.NAME);
			RoleType role = RoleType.USER;
			Validation validation = ValidationManager.getInstance().getSingUpValidation();
			try {
				if (validation.vadidate(request)) {
					User user = DaoManager.getInstance().getUserDAO().registration(login, pass, name, role);
					System.out.println(user);
					HttpSession session = request.getSession(true);
					session.setAttribute(ConstConteiner.ROLE, user.getRole().toString().toLowerCase());
					session.setAttribute(ConstConteiner.USER, user);
					page = ManagerConfig.get("path.page.main");

				} else {

					throw new WrongLoginDateException();
				}

			} catch (DaoSQLExcetion e) {
				log.warn("try singup" + e);
				page = ManagerConfig.get("path.page.bad.request");

			} catch (WrongLoginDateException e) {
				log.warn("try sing up" + e);
				request.setAttribute(ConstConteiner.WRONG_DATE_SINGUP, ConstConteiner.WRONG_DATE_SINGUP);
				page = ManagerConfig.get("path.page.singup");
			}

		}
		return CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_INDEX).execute(request);
	}

}
