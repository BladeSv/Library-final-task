package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check;

import javax.servlet.http.HttpServletRequest;

public interface RoleChecker {
	boolean isUser(HttpServletRequest request);

	boolean isAdmin(HttpServletRequest request);

}
