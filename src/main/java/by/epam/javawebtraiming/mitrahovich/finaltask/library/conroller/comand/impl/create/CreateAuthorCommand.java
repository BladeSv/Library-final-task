package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.create;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand.Do;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.AuthorDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.ValidationManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class CreateAuthorCommand extends AbstractCommand {

	public CreateAuthorCommand() {

	}

	@Override
	public ResultCommand execute(HttpServletRequest request, HttpServletResponse response) {

		if (request == null || response == null) {
			return null;
		}
		ResultCommand page = new ResultCommand();

		if (ValidationManager.getInstance().getAuthorValidation().vadidate(request)) {
			String name = request.getParameter(ConstConteiner.AUTHOR_NAME);
			String surname = request.getParameter(ConstConteiner.AUTHOR_SURNAME);
			AuthorDAO authorDAO = DaoManager.getInstance().getAuthorDAO();
			try {
				authorDAO.add(name, surname);
				page.setAction(Do.REDIRECT);
				page.setPage(request.getContextPath() + "/main?command=" + ConstConteiner.COMMAND_PAGE_TO_AUTHOR);

			} catch (DaoSQLExcetion e) {
				log.warn("Create author command" + e);
				page.setAction(Do.FORWARD);
				page.setPage(ManagerConfig.get("path.page.bad.request"));

			}
		} else {

			request.setAttribute(ConstConteiner.WRONG_DATE_AUTHOR, ConstConteiner.WRONG_DATE_AUTHOR);
			page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_TO_CREATE_AUTHOR).execute(request, response);
		}

		return page;
	}

}
