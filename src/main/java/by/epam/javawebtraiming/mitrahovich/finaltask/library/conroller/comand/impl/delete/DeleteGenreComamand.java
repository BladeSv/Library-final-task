package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.delete;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand.Do;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.GenreDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.ValidationManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class DeleteGenreComamand extends AbstractCommand {

	public DeleteGenreComamand() {

	}

	@Override
	public ResultCommand execute(HttpServletRequest request, HttpServletResponse response) {
		if (request == null || response == null) {
			return null;
		}
		ResultCommand page = new ResultCommand();

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();
		if (roleChecker.isAdmin(request) && ValidationManager.getInstance().getNumberIDValidate().vadidate(request)) {
			int idGenre = Integer.parseInt(request.getParameter(ConstConteiner.ID));

			GenreDAO genreDAO = DaoManager.getInstance().getGenreDAO();
			try {
				genreDAO.removeById(idGenre);
			} catch (DaoSQLExcetion e) {
				log.warn("Delete genre Command" + e);
				page.setAction(Do.FORWARD);
				page.setPage(ManagerConfig.get("path.page.bad.request"));
			}
			page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_TO_GENRE).execute(request, response);
		}

		return page;
	}

}
