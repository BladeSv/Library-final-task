package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.BookDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.ValidationManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class GoToBookPageCommand extends AbstractCommand {

	public GoToBookPageCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if (request == null || response == null) {
			return null;
		}
		String page = null;
		if (ValidationManager.getInstance().getNumberIDValidate().vadidate(request)) {
			BookDAO bookDAO = DaoManager.getInstance().getBookDAO();

			try {

				int id = Integer.parseInt(request.getParameter(ConstConteiner.ID));

				Book book = bookDAO.getById(id);
				log.trace("go to genre command");

				request.setAttribute(ConstConteiner.BOOK_VIEW, book);
				page = ManagerConfig.get("path.page.book");
			} catch (NumberFormatException | DaoSQLExcetion e) {
				log.warn("try go to book page" + e);
				page = ManagerConfig.get("path.page.bad.request");
			}
		}
		return page;
	}

}
