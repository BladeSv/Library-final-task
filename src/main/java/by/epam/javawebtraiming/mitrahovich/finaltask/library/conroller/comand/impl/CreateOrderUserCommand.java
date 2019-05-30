package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.OrderDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Order;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.PlaceType;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.User;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class CreateOrderUserCommand extends AbstractCommand {

	public CreateOrderUserCommand() {

	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		if (request == null || response == null) {
			return null;
		}
		String page = null;
		String[] checkedBooks = request.getParameterValues(ConstConteiner.TABLE_BOOKS_CHECK);

		if (checkedBooks != null) {
			HttpSession session = request.getSession(true);

			OrderDAO orderDAO = DaoManager.getInstance().getOrderDAO();

			for (int i = 0; i < checkedBooks.length; i++) {

				User user = (User) (session.getAttribute(ConstConteiner.USER));
				log.trace("create order command -user- " + user);
				int userId = user.getId();
				Integer idBook = Integer.parseInt(checkedBooks[i]);
				String bookPlace = request.getParameter(ConstConteiner.TABLE_BOOKS_PLACE_PREFIX + idBook);

				try {
					int idOrder = orderDAO.add(userId, idBook, PlaceType.valueOf(bookPlace.toUpperCase()));
					log.trace("create order command -id-order- " + idOrder);
					if (idOrder > 0) {

						Order order = (Order) orderDAO.getById(idOrder);
						user.getTakenOrder().add(order);
						response.sendRedirect(
								request.getContextPath() + "/main?command=" + ConstConteiner.COMMAND_PAGE_TO_ORDER);
					}
				} catch (DaoSQLExcetion | IOException e) {
					log.warn("create order command" + e);
					page = ManagerConfig.get("path.page.bad.request");
				}
			}

		} else {
			page = CommandManager.getInstance().getCommand(ConstConteiner.COMMAND_PAGE_TO_ORDER).execute(request,
					response);
		}

		return page;
	}

}
