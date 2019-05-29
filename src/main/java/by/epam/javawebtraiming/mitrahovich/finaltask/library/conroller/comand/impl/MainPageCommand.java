package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.BookDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Book;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class MainPageCommand extends AbstractCommand {

	public MainPageCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		log.trace("URL indexPageCommand-" + request.getContextPath());

		String page = ManagerConfig.get("path.page.main");

		try {
			BookDAO bookDAO = DaoManager.getInstance().getBookDAO();
			List<Book> books = bookDAO.getAllFreeBook();
			request.setAttribute(ConstConteiner.TABLE_BOOKS, books);

		} catch (DaoSQLExcetion e) {

			log.warn("try search" + e);
			page = ManagerConfig.get("path.page.bad.request");

		}

		return page;

	}

}
