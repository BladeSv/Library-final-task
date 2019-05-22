package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class RoleCheckerImpl implements RoleChecker {

	public RoleCheckerImpl() {

	}

	@Override
	public boolean isUser(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String role = (String) session.getAttribute(ConstConteiner.ROLE);

		return role.equals(ConstConteiner.ROLE_USER);
	}

	@Override
	public boolean isAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute(ConstConteiner.ROLE);

		return role.equals(ConstConteiner.ROLE_ANDMIN);
	}

}
