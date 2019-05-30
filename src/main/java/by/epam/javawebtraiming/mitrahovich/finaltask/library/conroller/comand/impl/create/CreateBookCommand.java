package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.create;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand.Do;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.BookDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.ValidationManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class CreateBookCommand extends AbstractCommand {

	public CreateBookCommand() {

	}

	@Override
	public ResultCommand execute(HttpServletRequest request, HttpServletResponse response) {

		if (request == null || response == null) {
			return null;
		}
		ResultCommand page = new ResultCommand();

		if (ValidationManager.getInstance().getBookValidation().vadidate(request)) {

			String bookTitle = request.getParameter(ConstConteiner.BOOK_TITLE);
			int idAuthor = Integer.parseInt(request.getParameter(ConstConteiner.BOOK_AUTHOR));
			int idGenre = Integer.parseInt(request.getParameter(ConstConteiner.BOOK_GENRE));
			int bookNumber = Integer.parseInt(request.getParameter(ConstConteiner.BOOK_NUMBER));
			String bookAnnotation = request.getParameter(ConstConteiner.BOOK_ANNOTATION);

			BookDAO bookDAO = DaoManager.getInstance().getBookDAO();
			try {
				bookDAO.add(bookTitle, bookAnnotation, idAuthor, idGenre, bookNumber);
				page.setAction(Do.REDIRECT);
				page.setPage(request.getContextPath() + "/main?command=" + ConstConteiner.SEARCH);

			} catch (DaoSQLExcetion e) {
				log.warn("Create book command" + e);
				page.setAction(Do.FORWARD);
				page.setPage(ManagerConfig.get("path.page.bad.request"));

			}
		} else {

			request.setAttribute(ConstConteiner.WRONG_DATE_BOOK, ConstConteiner.WRONG_DATE_BOOK);
			page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_TO_CREATE_BOOK).execute(request, response);
		}

		return page;
	}

}
