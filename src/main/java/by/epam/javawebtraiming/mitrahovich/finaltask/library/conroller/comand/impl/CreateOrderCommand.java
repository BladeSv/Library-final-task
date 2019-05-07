package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.OrderDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Order;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.PlaceType;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.User;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class CreateOrderCommand extends AbstractCommand {

	public CreateOrderCommand() {

	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String[] checkedBooks = request.getParameterValues(ConstConteiner.TABLE_BOOKS_CHECK);
		if (checkedBooks != null) {
			HttpSession session = request.getSession(true);

			OrderDAO orderDAO = DaoManager.getInstance().getOrderDAO();
			page = ManagerConfig.get("path.page.order");
			for (int i = 0; i < checkedBooks.length; i++) {

				User user = (User) (session.getAttribute(ConstConteiner.USER));
				int userId = user.getId();
				Integer idBook = Integer.parseInt(checkedBooks[i]);
				String bookPlace = request.getParameter(ConstConteiner.TABLE_BOOKS_PLACE_PREFIX + idBook);

				try {
					int idOrder = orderDAO.add(userId, idBook, PlaceType.valueOf(bookPlace));
					if (idOrder > 0) {
						Order order = (Order) orderDAO.getById(idOrder);
						user.getTakenOrder().add(order);

					}
				} catch (DaoSQLExcetion e) {
					log.warn("try singup" + e);
					page = ManagerConfig.get("path.page.bad.request");
				}
			}

		}

		return page;
	}

}
