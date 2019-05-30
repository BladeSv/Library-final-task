package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand.Do;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.AuthorDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Author;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.validation.ValidationManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class GoToUpdateAuthorPageCommand extends AbstractCommand {

	public GoToUpdateAuthorPageCommand() {

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
			AuthorDAO authorDAO = DaoManager.getInstance().getAuthorDAO();
			try {
				Author author = authorDAO.getById(idGenre);
				request.setAttribute(ConstConteiner.AUTHOR_UPDATE, author);

			} catch (DaoSQLExcetion e) {
				log.warn("Go to update author page command" + e);
				page.setAction(Do.FORWARD);
				page.setPage(ManagerConfig.get("path.page.bad.request"));
			}
			page.setAction(Do.FORWARD);
			page.setPage(ManagerConfig.get("path.page.author.edit"));

		}
		return page;
	}

}
