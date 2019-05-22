package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.DaoManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao.OrderDAO;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.User;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class DeleteOrderCommand extends AbstractCommand {

	public DeleteOrderCommand() {

	}

	@Override
	public String execute(HttpServletRequest request) {
		String page = ManagerConfig.get("path.page.order");
		String[] checkedOrder = request.getParameterValues(ConstConteiner.ORDER_DELETE_CHECK);
		if (checkedOrder != null) {
			HttpSession session = request.getSession(true);
			OrderDAO orderDAO = DaoManager.getInstance().getOrderDAO();
			User user = (User) (session.getAttribute(ConstConteiner.USER));
			log.trace("delete order command -user- " + user);
			for (int i = 0; i < checkedOrder.length; i++) {

				Integer idOrder = Integer.parseInt(checkedOrder[i]);
				log.trace("delete order command -id order-delete- " + idOrder);
				try {
					orderDAO.remote(idOrder);
				} catch (DaoSQLExcetion e) {
					log.warn("delete order command" + e);
					page = ManagerConfig.get("path.page.bad.request");
				}

				user.getTakenOrder().removeIf((o) -> o.getId() == idOrder);

			}
			request.setAttribute(ConstConteiner.ORDER_USER, user);
		}
		return page;
	}

}
