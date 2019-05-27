package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.pagination;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Item;

public interface PaginationHandler {
	int getNumberPage(HttpServletRequest request);

	List<? extends Item> getItemPage(List<? extends Item> ItemList, int numPage);

	int getMaxPage(List<? extends Item> ItemList);

	String getPaginationUrl(HttpServletRequest request, String commandName);
}
