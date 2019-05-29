package by.epam.javawebtraiming.mitrahovich.finaltask.library.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Pagination extends SimpleTagSupport {

	private int numberPage;
	private int maxPage;

	private String paginationUrl;

	public Pagination() {

	}

	public void setNumberPage(int numberPage) {
		this.numberPage = numberPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public void setPaginationUrl(String paginationUrl) {
		this.paginationUrl = paginationUrl;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		if (maxPage > 1) {

			out.print("<div class=\"paginator\">");
			out.print("<div>");
			if (numberPage > 3) {
				out.print(createPageLink(1, false));
				out.print("<span>&hellip;</span>");
				out.print(createPageLink(numberPage - 1, false));
				out.print(createPageLink(numberPage, true));
			} else if (numberPage == 3) {
				out.print(createPageLink(1, false));
				out.print(createPageLink(numberPage - 1, false));
				out.print(createPageLink(numberPage, true));
			} else if (numberPage == 2) {
				out.print(createPageLink(1, false));
				out.print(createPageLink(numberPage, true));
			} else {
				out.print(createPageLink(numberPage, true));
			}

			if (numberPage + 2 < maxPage) {
				out.print(createPageLink(numberPage + 1, false));
				out.print("<span>&hellip;</span>");
				out.print(createPageLink(maxPage, false));
			} else if (numberPage + 1 < maxPage) {
				out.print(createPageLink(numberPage + 1, false));

				out.print(createPageLink(maxPage, false));
			} else if (numberPage < maxPage) {

				out.print(createPageLink(maxPage, false));
			}
			out.print(" </div>");
			out.print(" </div>");

		} else {
			out.print("</br>");
		}
	}

	private String createPageLink(int page, boolean active) {

		StringBuilder form = new StringBuilder();

		form.append("<a href=\"").append(paginationUrl).append(page);

		if (!active) {
			form.append("\">");
		} else {
			form.append("\" class=\"active\">");
		}
		form.append(page).append("</a>");
		return form.toString();
	}

}
