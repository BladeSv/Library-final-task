package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.AuthorDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class DeleteAuthorCommand extends AbstractCommand {

	public DeleteAuthorCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		if (request == null || response == null) {
			return null;
		}
		String page = null;

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();
		if (roleChecker.isAdmin(request)) {

			String idAuthorString = request.getParameter(ConstConteiner.ID);
			if (idAuthorString != null && idAuthorString != "") {

				int idAuthor = Integer.parseInt(idAuthorString);

				AuthorDAO authorDAO = DaoManager.getInstance().getAuthorDAO();
				try {
					authorDAO.removeById(idAuthor);
				} catch (DaoSQLExcetion e) {
					log.warn("Delete author Command" + e);
					page = ManagerConfig.get("path.page.bad.request");
				}
			}
			page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_TO_AUTHOR).execute(request,
					response);
		}

		return page;
	}

}
