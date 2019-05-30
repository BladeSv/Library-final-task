package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.AuthorDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Author;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class GoToAuthorPageCommand extends AbstractCommand {

	public GoToAuthorPageCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		if (request == null || response == null) {
			return null;
		}
		String page = null;

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();

		if (roleChecker.isUser(request) || roleChecker.isAdmin(request)) {

			AuthorDAO authorDAO = DaoManager.getInstance().getAuthorDAO();

			try {
				List<Author> authorTable = authorDAO.getALL();
				log.trace("go to author command");

				request.setAttribute(ConstConteiner.AUTHOR_LIST_TABLE, authorTable);
				page = ManagerConfig.get("path.page.author");
			} catch (NumberFormatException | DaoSQLExcetion e) {
				log.warn("try go to author page" + e);
				page = ManagerConfig.get("path.page.bad.request");
			}

		}
		return page;
	}

}
