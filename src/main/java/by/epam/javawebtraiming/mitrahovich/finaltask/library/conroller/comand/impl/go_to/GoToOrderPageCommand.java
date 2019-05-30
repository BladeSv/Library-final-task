package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.UserDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.User;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.ValidationManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class GoToOrderPageCommand extends AbstractCommand {

	public GoToOrderPageCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if (request == null || response == null) {
			return null;
		}

		String page = ManagerConfig.get("path.page.order");

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();

		if (roleChecker.isUser(request)) {
			page = ManagerConfig.get("path.page.order");

		} else if (roleChecker.isAdmin(request) && ValidationManager.getInstance().getNumberIDValidate().vadidate(request)) {

			UserDAO userDAO = DaoManager.getInstance().getUserDAO();

			try {
				User user = (User) userDAO.getById(Integer.parseInt(request.getParameter(ConstConteiner.ID)));
				log.trace("go to order command--user--" + user);
				request.setAttribute(ConstConteiner.ORDER_USER, user);
				page = ManagerConfig.get("path.page.order");
			} catch (NumberFormatException | DaoSQLExcetion e) {
				log.warn("try go to order page" + e);
				page = ManagerConfig.get("path.page.bad.request");
			}
		}
		return page;
	}
}
