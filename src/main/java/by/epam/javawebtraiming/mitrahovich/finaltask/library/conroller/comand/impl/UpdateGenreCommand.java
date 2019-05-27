package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.GenreDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Genre;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.ValidationManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class UpdateGenreCommand extends AbstractCommand {

	public UpdateGenreCommand() {

	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_TO_GENRE).execute(request);
		if (ValidationManager.getInstance().getGenreValidation().vadidate(request)) {
			String title = request.getParameter(ConstConteiner.GENRE_TITLE);
			int idGenre = Integer.parseInt(request.getParameter(ConstConteiner.ID));
			GenreDAO genreDAO = DaoManager.getInstance().getGenreDAO();
			try {
				genreDAO.update(new Genre(idGenre, title));

			} catch (DaoSQLExcetion e) {
				log.warn("Create genre command" + e);
				page = ManagerConfig.get("path.page.bad.request");
			}
		} else {
			request.setAttribute(ConstConteiner.WRONG_DATE_GENRE, ConstConteiner.WRONG_DATE_GENRE);
			page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_TO_UPDATE_GENRE)
					.execute(request);

		}

		return page;
	}

}
