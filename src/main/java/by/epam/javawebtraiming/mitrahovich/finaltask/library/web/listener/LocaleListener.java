package by.epam.javawebtraiming.mitrahovich.finaltask.library.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class LocaleListener
 *
 */
@WebListener
public class LocaleListener implements ServletRequestListener {

	/**
	 * Default constructor.
	 */
	public LocaleListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	public void requestInitialized(ServletRequestEvent sre) {
//		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
//
//		if (request.getSession(true).getAttribute(ConstConteiner.LOCALE) != null) {
//
//		} else {
//			Locale userLocale = request.getLocale();
//			if (userLocale.getLanguage().equals(ConstConteiner.RU_LOCALE)) {
//				Config.set(request.getSession(), Config.FMT_LOCALE, ConstConteiner.RU_LOCALE);
//				request.getSession().setAttribute(ConstConteiner.LOCALE, ConstConteiner.RU_LOCALE);
//			} else {
//				Config.set(request.getSession(), Config.FMT_LOCALE, ConstConteiner.DEFAULT_LOCALE);
//				request.getSession().setAttribute(ConstConteiner.LOCALE, ConstConteiner.DEFAULT_LOCALE);
//			}
//		}
	}

}
