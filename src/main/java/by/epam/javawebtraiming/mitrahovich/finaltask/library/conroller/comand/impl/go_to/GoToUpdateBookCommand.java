package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand.Do;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.AuthorDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.BookDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.GenreDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Author;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Genre;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.ValidationManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class GoToUpdateBookCommand extends AbstractCommand {

	public GoToUpdateBookCommand() {

	}

	@Override
	public ResultCommand execute(HttpServletRequest request, HttpServletResponse response) {
		if (request == null || response == null) {
			return null;
		}
		ResultCommand page = new ResultCommand();

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();
		if (roleChecker.isAdmin(request) && ValidationManager.getInstance().getNumberIDValidate().vadidate(request)) {

			try {

				int idBook = Integer.parseInt(request.getParameter(ConstConteiner.ID));
				BookDAO bookDAO = DaoManager.getInstance().getBookDAO();
				Book changeBook = bookDAO.getById(idBook);
				int changeBookNumber = bookDAO.getInstanceById(idBook);

				request.setAttribute(ConstConteiner.BOOK_UPDATE, changeBook);
				request.setAttribute(ConstConteiner.BOOK_UPDATE_NUMBER, changeBookNumber);

				AuthorDAO authorDAO = DaoManager.getInstance().getAuthorDAO();
				List<Author> tableAuthor = authorDAO.getALL();
				request.setAttribute(ConstConteiner.AUTHOR_LIST_TABLE, tableAuthor);

				GenreDAO genreDAO = DaoManager.getInstance().getGenreDAO();
				List<Genre> tableGenre = genreDAO.getALL();
				request.setAttribute(ConstConteiner.GENRE_LIST_TABLE, tableGenre);

				page.setAction(Do.FORWARD);
				page.setPage(ManagerConfig.get("path.page.book.edit"));
			} catch (DaoSQLExcetion e) {

				log.warn("go to update page book command" + e);
				page.setAction(Do.FORWARD);
				page.setPage(ManagerConfig.get("path.page.bad.request"));
			}

		}

		return page;
	}

}
