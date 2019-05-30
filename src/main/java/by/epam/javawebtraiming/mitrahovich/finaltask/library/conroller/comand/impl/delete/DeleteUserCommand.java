package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.UserDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.ValidationManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class DeleteUserCommand extends AbstractCommand {

	public DeleteUserCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if (request == null || response == null) {
			return null;
		}

		String page = null;

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();
		if (roleChecker.isAdmin(request) && ValidationManager.getInstance().getNumberIDValidate().vadidate(request)) {
			int idUser = Integer.parseInt(request.getParameter(ConstConteiner.ID));

			UserDAO userDAO = DaoManager.getInstance().getUserDAO();
			try {
				userDAO.deteteUser(idUser);
			} catch (DaoSQLExcetion e) {
				log.warn("Delete User Command" + e);
				page = ManagerConfig.get("path.page.bad.request");
			}
			page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_SEARCH_USER).execute(request, response);
		}

		return page;
	}

}
