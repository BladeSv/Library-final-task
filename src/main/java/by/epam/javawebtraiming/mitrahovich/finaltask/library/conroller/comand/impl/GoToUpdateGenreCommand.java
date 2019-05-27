package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.GenreDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Genre;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class GoToUpdateGenreCommand extends AbstractCommand {

	public GoToUpdateGenreCommand() {

	}

	@Override
	public String execute(HttpServletRequest request) {

		String page = null;

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();
		if (roleChecker.isAdmin(request)) {
			int idGenre = Integer.parseInt(request.getParameter(ConstConteiner.ID));
			GenreDAO genreDAO = DaoManager.getInstance().getGenreDAO();
			try {
				Genre genre = genreDAO.getById(idGenre);
				request.setAttribute(ConstConteiner.GENRE_UPDATE, genre);

			} catch (DaoSQLExcetion e) {
				log.warn("Go to update genre page command" + e);
				page = ManagerConfig.get("path.page.bad.request");
			}
			page = ManagerConfig.get("path.page.genre.edit");
		}

		return page;
	}

}
