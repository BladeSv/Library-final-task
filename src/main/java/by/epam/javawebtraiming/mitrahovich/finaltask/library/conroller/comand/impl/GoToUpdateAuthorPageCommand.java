package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.AuthorDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Author;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class GoToUpdateAuthorPageCommand extends AbstractCommand {

	public GoToUpdateAuthorPageCommand() {

	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();
		if (roleChecker.isAdmin(request)) {
			int idGenre = Integer.parseInt(request.getParameter(ConstConteiner.ID));
			AuthorDAO authorDAO = DaoManager.getInstance().getAuthorDAO();
			try {
				Author author = authorDAO.getById(idGenre);
				request.setAttribute(ConstConteiner.AUTHOR_UPDATE, author);

			} catch (DaoSQLExcetion e) {
				log.warn("Go to update author page command" + e);
				page = ManagerConfig.get("path.page.bad.request");
			}
			page = ManagerConfig.get("path.page.author.edit");
		}
		return page;
	}

}
