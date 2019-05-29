package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleChecker;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.check.RoleCheckerImpl;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.pagination.PaginationHandler;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.pagination.PaginationHandlerImpl;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search.SearchBook;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search.SearchBookimp;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search.SearchUser;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search.SearchUserImpl;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.table.TableHadler;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.table.TableHadlerImpl;

public class ServiceFactory {
	private static ServiceFactory factory = new ServiceFactory();
	private SearchBook searchBook = new SearchBookimp();
	private TableHadler tableHadler = new TableHadlerImpl();
	private SearchUser searchUser = new SearchUserImpl();
	private RoleChecker roleChecker = new RoleCheckerImpl();

	private PaginationHandler paginationHandler = new PaginationHandlerImpl();

	public ServiceFactory() {

	}

	public static ServiceFactory getInstance() {
		return factory;

	}

	public SearchBook getSearchBooK() {
		return searchBook;

	}

	public SearchUser getSearchUser() {
		return searchUser;
	}

	public RoleChecker getRoleChecker() {
		return roleChecker;
	}

	public PaginationHandler getPaginationHandler() {
		return paginationHandler;
	}

	public TableHadler getTableHadler() {
		return tableHadler;
	}

}
