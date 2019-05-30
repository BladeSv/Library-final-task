package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.update;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand.Do;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.OrderDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Observable;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.ServiceFactory;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class AdminOrderCommand extends AbstractCommand {

	public AdminOrderCommand() {

	}

	@Override
	public ResultCommand execute(HttpServletRequest request, HttpServletResponse response) {

		if (request == null || response == null) {
			return null;
		}

		ResultCommand page = new ResultCommand();

		RoleChecker roleChecker = ServiceFactory.getInstance().getRoleChecker();

		if (roleChecker.isAdmin(request)) {
			Observable observer = (Observable) request.getServletContext().getAttribute(ConstConteiner.LIBRARY_OBSERVER);

			OrderDAO orderDAO = DaoManager.getInstance().getOrderDAO();
			String[] returnBook = request.getParameterValues(ConstConteiner.ORDER_ADMIN_RETURN_CHECK);
			if (returnBook != null) {
				for (int i = 0; i < returnBook.length; i++) {
					int idOrder = Integer.parseInt(returnBook[i]);
					log.trace("AdminOrderCommand- return book order -id order- " + idOrder);
					try {
						orderDAO.remote(idOrder);
						observer.NotifyRemoveOrder(idOrder);
					} catch (DaoSQLExcetion e) {
						log.warn("AdminOrderCommand return order " + e);
						page.setAction(Do.FORWARD);
						page.setPage(ManagerConfig.get("path.page.bad.request"));
					}
				}

			}

			String[] notConfirmOrders = request.getParameterValues(ConstConteiner.ORDER_ADMIN_NOT_CONFIRM_CHECK);
			if (notConfirmOrders != null) {
				for (int i = 0; i < notConfirmOrders.length; i++) {
					String NotConfirmOrderTask = request.getParameter(ConstConteiner.ORDER_ADMIN_NOT_CONFIRM_CHECK + "-" + notConfirmOrders[i]);
					if (NotConfirmOrderTask != null) {
						if (NotConfirmOrderTask.equals(ConstConteiner.ORDER_ADMIN_DELETE_CHECK)) {
							int idOrder = Integer.parseInt(notConfirmOrders[i]);
							try {
								log.trace("AdminOrderCommand- delete book order -id order- " + idOrder);
								orderDAO.remote(idOrder);
								observer.NotifyRemoveOrder(idOrder);
							} catch (DaoSQLExcetion e) {
								log.warn("AdminOrderCommand return order " + e);
								page.setAction(Do.FORWARD);
								page.setPage(ManagerConfig.get("path.page.bad.request"));
							}
						} else if (NotConfirmOrderTask.equals(ConstConteiner.ORDER_ADMIN_CONFIRM_CHECK)) {
							int idOrder = Integer.parseInt(notConfirmOrders[i]);
							try {
								Date takenDate = new Date();
								orderDAO.uptateDateById(takenDate, idOrder);
								observer.NotifyConfirmOrder(idOrder, takenDate);
							} catch (DaoSQLExcetion e) {
								log.warn("AdminOrderCommand confirm order " + e);
								page.setAction(Do.FORWARD);
								page.setPage(ManagerConfig.get("path.page.bad.request"));
							}

						}
					}
				}

			}

		}
		if (page.getPage() == null) {

			page.setAction(Do.REDIRECT);
			page.setPage(request.getContextPath() + "/main?command=" + ConstConteiner.COMMAND_PAGE_TO_ORDER + "&" + ConstConteiner.ID + "=" + request.getParameter(ConstConteiner.ID));

		}
		return page;
	}

}
