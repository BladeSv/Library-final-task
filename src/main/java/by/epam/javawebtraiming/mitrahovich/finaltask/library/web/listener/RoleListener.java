package by.epam.javawebtraiming.mitrahovich.finaltask.library.web.listener;

import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

/**
 * Application Lifecycle Listener implementation class RoleListener
 *
 */
public class RoleListener implements HttpSessionListener, ServletRequestListener {

	/**
	 * Default constructor.
	 */
	public RoleListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession httpSession = se.getSession();
		httpSession.setAttribute(ConstConteiner.ROLE, ConstConteiner.ROLE_GUEST);
	}

}
