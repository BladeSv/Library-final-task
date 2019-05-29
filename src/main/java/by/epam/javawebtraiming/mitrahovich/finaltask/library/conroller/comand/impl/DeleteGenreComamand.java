package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.GenreDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class DeleteGenreComamand extends AbstractCommand {

	public DeleteGenreComamand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = null;

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();
		if (roleChecker.isAdmin(request)) {
			int idGenre = Integer.parseInt(request.getParameter(ConstConteiner.ID));

			GenreDAO genreDAO = DaoManager.getInstance().getGenreDAO();
			try {
				genreDAO.removeById(idGenre);
			} catch (DaoSQLExcetion e) {
				log.warn("Delete genre Command" + e);
				page = ManagerConfig.get("path.page.bad.request");
			}
			page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_TO_GENRE).execute(request,
					response);
		}

		return page;
	}

}
