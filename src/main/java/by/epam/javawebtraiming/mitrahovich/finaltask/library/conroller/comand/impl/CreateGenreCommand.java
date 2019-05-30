package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
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
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		if (request == null || response == null) {
			return null;
		}
		String page = null;

		if (ValidationManager.getInstance().getGenreValidation().vadidate(request)) {
			String title = request.getParameter(ConstConteiner.GENRE_TITLE);
			GenreDAO genreDAO = DaoManager.getInstance().getGenreDAO();
			try {
				genreDAO.add(title);
				response.sendRedirect(
						request.getContextPath() + "/main?command=" + ConstConteiner.COMMAND_PAGE_TO_GENRE);
			} catch (DaoSQLExcetion | IOException e) {
				log.warn("Create genre command" + e);
				page = ManagerConfig.get("path.page.bad.request");
			}
		} else {

			request.setAttribute(ConstConteiner.WRONG_DATE_GENRE, ConstConteiner.WRONG_DATE_GENRE);
			page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_TO_CREATE_GENRE).execute(request,
					response);
		}

		return page;
	}

}
