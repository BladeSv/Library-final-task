package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.page;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class PageHandlerImpl implements PageHandler {

	public PageHandlerImpl() {

	}

	public int getNumberPage(HttpServletRequest request) {
		int numberPage = 1;
		System.out.println("Method- getNumberPage--start");
		String numPage = request.getParameter(ConstConteiner.PAGE);

		if (numPage != null && numPage != "") {
			System.out.println("Method- getNumberPage=" + numPage);
			numberPage = Integer.parseInt(numPage);

		}

		return numberPage;

	}

}
