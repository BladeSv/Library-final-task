package by.epam.javawebtraiming.mitrahovich.finaltask.library.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Observable;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Observer;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

/**
 * Application Lifecycle Listener implementation class SessionRemoveListener
 *
 */
@WebListener
public class SessionRemoveListener implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public SessionRemoveListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession httpSession = se.getSession();
		String role = (String) httpSession.getAttribute(ConstConteiner.ROLE);
		if (role == ConstConteiner.ROLE_USER || role == ConstConteiner.ROLE_ANDMIN) {
			Observable observer = (Observable) httpSession.getServletContext()
					.getAttribute(ConstConteiner.LIBRARY_OBSERVER);

			Observer obs = (Observer) httpSession.getAttribute(ConstConteiner.USER);

			observer.removeObserver(obs);

		}

	}

}
