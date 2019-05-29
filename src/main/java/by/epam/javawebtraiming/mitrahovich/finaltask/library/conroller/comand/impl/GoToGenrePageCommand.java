package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.GenreDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Genre;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class GoToGenrePageCommand extends AbstractCommand {

	public GoToGenrePageCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String page = ManagerConfig.get("path.page.genre");

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();

		if (roleChecker.isUser(request) || roleChecker.isAdmin(request)) {

			GenreDAO genreDAO = DaoManager.getInstance().getGenreDAO();

			try {
				List<Genre> genreTable = genreDAO.getALL();
				log.trace("go to genre command");

				request.setAttribute(ConstConteiner.GENRE_LIST_TABLE, genreTable);
			} catch (NumberFormatException | DaoSQLExcetion e) {
				log.warn("try go to genre page" + e);
				page = ManagerConfig.get("path.page.bad.request");
			}

		}
		return page;
	}

}
