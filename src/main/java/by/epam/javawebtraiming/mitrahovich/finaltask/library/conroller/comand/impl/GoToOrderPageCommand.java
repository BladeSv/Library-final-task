package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.UserDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.User;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class GoToOrderPageCommand extends AbstractCommand {

	public GoToOrderPageCommand() {

	}

	@Override
	public String execute(HttpServletRequest request) {

		String page = ManagerConfig.get("path.page.order");
		HttpSession session = request.getSession(true);
		String role = (String) session.getAttribute(ConstConteiner.ROLE);
		System.out.println("ROLE-" + role);
		if (role.equals(ConstConteiner.ROLE_USER) || role.equals(ConstConteiner.ROLE_ANDMIN)) {

			String id = request.getParameter(ConstConteiner.ID);

			if (id != null && id != "") {
				UserDAO userDAO = DaoManager.getInstance().getUserDAO();

				try {
					User user = (User) userDAO.getById(Integer.parseInt(id));
					log.trace("go to order command--user--" + user);
					request.setAttribute(ConstConteiner.ORDER_USER, user);
				} catch (NumberFormatException | DaoSQLExcetion e) {
					log.warn("try go to order page" + e);
					page = ManagerConfig.get("path.page.bad.request");
				}
			}

		}
		return page;
	}

}
