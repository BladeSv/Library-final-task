package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.User;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.pagination.PaginationHandler;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search.SearchUser;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class SearchUserCommand extends AbstractCommand {

	public SearchUserCommand() {

	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = ManagerConfig.get("path.page.admin");

		String searchRequest = request.getParameter(ConstConteiner.SEARCH);
		SearchUser searchUser = ServiceFactory.getInstance().getSearchUser();

		List<User> users = null;
		try {
			if (searchRequest != null && searchRequest != "") {

				users = searchUser.searchUser(searchRequest);

				request.setAttribute(ConstConteiner.SEARCH_VALUE, searchRequest);

			} else {

				users = searchUser.searchAllUser();

			}
			PaginationHandler paginationHandler = ServiceFactory.getInstance().getPaginationHandler();
			int numberPage = paginationHandler.getNumberPage(request);
			int numberMaxPage = paginationHandler.getMaxPage(users);
			List<User> pageUsers = (List<User>) paginationHandler.getItemPage(users, numberPage);
			String paginationUrl = paginationHandler.getPaginationUrl(request, ConstConteiner.COMMAND_PAGE_SEARCH_USER);

			request.setAttribute(ConstConteiner.PAGINATION_NUMBER_PAGE, numberPage);
			request.setAttribute(ConstConteiner.PAGINATION_NUMBER_MAX_PAGE, numberMaxPage);
			request.setAttribute(ConstConteiner.PAGINATION_URL, paginationUrl);

			request.setAttribute(ConstConteiner.TABLE_USERS, pageUsers);
		} catch (DaoSQLExcetion e) {
			log.warn("try search users" + e);
			page = ManagerConfig.get("path.page.bad.request");
		}
		return page;
	}

}
