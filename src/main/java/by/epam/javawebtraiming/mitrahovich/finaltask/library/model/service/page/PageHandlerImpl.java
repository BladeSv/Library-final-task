package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.page;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class PageHandlerImpl implements PageHandler {

	public PageHandlerImpl() {

	}

	public int getNumberPage(HttpServletRequest request) {
		int numberPage = 1;
		Enumeration<String> enumAttr = request.getAttributeNames();

		while (enumAttr.hasMoreElements()) {

			if (enumAttr.nextElement().equals(ConstConteiner.PAGE)) {
				String numPage = request.getParameter(ConstConteiner.PAGE);
				numberPage = Integer.parseInt(numPage);

			}
		}

		return numberPage;

	}

}
