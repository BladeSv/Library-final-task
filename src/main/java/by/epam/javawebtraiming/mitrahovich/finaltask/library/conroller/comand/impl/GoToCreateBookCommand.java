package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.AuthorDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.GenreDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Author;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Genre;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class GoToCreateBookCommand extends AbstractCommand {

	public GoToCreateBookCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String page = ManagerConfig.get("path.page.book.edit");

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();
		if (roleChecker.isAdmin(request)) {

			try {
				AuthorDAO authorDAO = DaoManager.getInstance().getAuthorDAO();
				List<Author> tableAuthor = authorDAO.getALL();
				request.setAttribute(ConstConteiner.AUTHOR_LIST_TABLE, tableAuthor);

				GenreDAO genreDAO = DaoManager.getInstance().getGenreDAO();
				List<Genre> tableGenre = genreDAO.getALL();
				request.setAttribute(ConstConteiner.GENRE_LIST_TABLE, tableGenre);
			} catch (DaoSQLExcetion e) {

				log.warn("try search" + e);
				page = ManagerConfig.get("path.page.bad.request");
			}

		}

		return page;
	}

}
