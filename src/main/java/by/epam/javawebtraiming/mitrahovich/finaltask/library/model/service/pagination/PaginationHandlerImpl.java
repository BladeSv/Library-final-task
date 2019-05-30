package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.pagination;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Item;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

public class PaginationHandlerImpl implements PaginationHandler {
	private int maxBookOnPage;

	private static Logger log;
	static {

		log = Logger.getLogger("Service.class");
	}

	public PaginationHandlerImpl() {
		maxBookOnPage = Integer.parseInt(ManagerConfig.get("max.item.page"));
		log.trace("books on page=" + maxBookOnPage);
	}

	@Override
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

	@Override
	public List<? extends Item> getItemPage(List<? extends Item> ItemList, int numPage) {
		List<? extends Item> pageBookList = null;
		if (ItemList != null && numPage >= 1) {
			if (ItemList.size() > maxBookOnPage) {
				if (numPage > getMaxPage(ItemList)) {
					numPage = getMaxPage(ItemList);
				}
				int maxIndex = maxBookOnPage * numPage < ItemList.size() ? maxBookOnPage * numPage : ItemList.size();

				pageBookList = ItemList.subList(maxBookOnPage * (numPage - 1), maxIndex);

				System.out.println(pageBookList);

			} else {
				pageBookList = ItemList;
			}

		}

		return pageBookList;
	}

	@Override
	public int getMaxPage(List<? extends Item> ItemList) {
		int maxPage = 1;

		if (ItemList != null) {

			if (ItemList.size() / maxBookOnPage >= 1) {
				maxPage = (ItemList.size() % maxBookOnPage > 0) ? ItemList.size() / maxBookOnPage + 1 : ItemList.size() / maxBookOnPage;
			}
		} else {
			maxPage = -1;
		}
		log.trace("Max page= " + maxPage);
		return maxPage;
	}

	@Override
	public String getPaginationUrl(HttpServletRequest request, String commandName) {

		String searchRequest = request.getParameter(ConstConteiner.SEARCH);
		searchRequest = searchRequest != null ? searchRequest : "";
		String paginationUrl = request.getRequestURI() + "?" + ConstConteiner.SEARCH + "=" + searchRequest + "&" + ConstConteiner.COMMAND + "=" + commandName + "&" + ConstConteiner.PAGE + "=";

		return paginationUrl;
	}

}
