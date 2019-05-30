package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.create;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand.Do;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.GenreDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.ValidationManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class CreateGenreCommand extends AbstractCommand {

	public CreateGenreCommand() {

	}

	@Override
	public ResultCommand execute(HttpServletRequest request, HttpServletResponse response) {

		if (request == null || response == null) {
			return null;
		}

		ResultCommand page = new ResultCommand();

		if (ValidationManager.getInstance().getGenreValidation().vadidate(request)) {
			String title = request.getParameter(ConstConteiner.GENRE_TITLE);
			GenreDAO genreDAO = DaoManager.getInstance().getGenreDAO();
			try {
				genreDAO.add(title);

				page.setAction(Do.REDIRECT);
				page.setPage(request.getContextPath() + "/main?command=" + ConstConteiner.COMMAND_PAGE_TO_GENRE);

			} catch (DaoSQLExcetion e) {
				log.warn("Create genre command" + e);
				page.setAction(Do.FORWARD);
				page.setPage(ManagerConfig.get("path.page.bad.request"));

			}
		} else {

			request.setAttribute(ConstConteiner.WRONG_DATE_GENRE, ConstConteiner.WRONG_DATE_GENRE);
			page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_TO_CREATE_GENRE).execute(request, response);
		}

		return page;
	}

}
