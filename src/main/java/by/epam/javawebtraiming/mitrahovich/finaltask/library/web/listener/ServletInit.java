package by.epam.javawebtraiming.mitrahovich.finaltask.library.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.connecton.ConnectionPool;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.connecton.exception.ConnectionPoolException;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.LibraryObserver;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

/**
 * Application Lifecycle Listener implementation class ServletInit
 *
 */
public class ServletInit implements ServletContextListener {
	private static Logger log;

	static {

		log = Logger.getLogger("ConnectionPool");
	}

	/**
	 * Default constructor.
	 */
	public ServletInit() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ConnectionPool.getInstanse().creatConnectionPool();
		} catch (ConnectionPoolException e) {
			log.error("Servlet init-creat connection poll", e);

		}

		sce.getServletContext().setAttribute(ConstConteiner.LIBRARY_OBSERVER, new LibraryObserver());

	}

}
