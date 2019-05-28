package by.epam.javawebtraiming.mitrahovich.finaltask.library.web.listener;

import java.util.Locale;

import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.jsp.jstl.core.Config;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

/**
 * Application Lifecycle Listener implementation class RoleListener
 *
 */
public class SessionInitListener implements HttpSessionListener, ServletRequestListener {

	/**
	 * Default constructor.
	 */
	public SessionInitListener() {

	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		if (se == null) {
			return;
		}
		if (se != null) {
			HttpSession httpSession = se.getSession();
			httpSession.setAttribute(ConstConteiner.ROLE, ConstConteiner.ROLE_GUEST);

			Locale locale = new Locale(ConstConteiner.DEFAULT_LOCALE);
			Config.set(httpSession, Config.FMT_LOCALE, locale);
			httpSession.setAttribute(ConstConteiner.LANG, ConstConteiner.DEFAULT_LOCALE);

		}
	}

}
