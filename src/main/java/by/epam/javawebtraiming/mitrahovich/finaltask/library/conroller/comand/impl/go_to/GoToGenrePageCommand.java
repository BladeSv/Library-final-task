package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand.Do;
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
	public ResultCommand execute(HttpServletRequest request, HttpServletResponse response) {
		if (request == null || response == null) {
			return null;
		}

		ResultCommand page = new ResultCommand();

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();

		if (roleChecker.isUser(request) || roleChecker.isAdmin(request)) {

			GenreDAO genreDAO = DaoManager.getInstance().getGenreDAO();

			try {
				List<Genre> genreTable = genreDAO.getALL();
				log.trace("go to genre command");

				request.setAttribute(ConstConteiner.GENRE_LIST_TABLE, genreTable);

				page.setAction(Do.FORWARD);
				page.setPage(ManagerConfig.get("path.page.genre"));
			} catch (NumberFormatException | DaoSQLExcetion e) {
				log.warn("try go to genre page" + e);
				page.setAction(Do.FORWARD);
				page.setPage(ManagerConfig.get("path.page.bad.request"));
			}

		}
		return page;
	}

}
