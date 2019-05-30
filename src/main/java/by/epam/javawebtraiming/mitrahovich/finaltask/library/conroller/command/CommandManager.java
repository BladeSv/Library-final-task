package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.ChangeLangCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.LoginPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.LogoutCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.SingUpCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.create.CreateAuthorCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.create.CreateBookCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.create.CreateGenreCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.create.CreateOrderUserCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.delete.DeleteAuthorCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.delete.DeleteBookCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.delete.DeleteGenreComamand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.delete.DeleteNotConfirmOrderCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.delete.DeleteOrderUserCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.delete.DeleteUserCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to.GoToAuthorPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to.GoToBookPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to.GoToCreateAuthorPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to.GoToCreateBookCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to.GoToCreateGenrePageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to.GoToGenrePageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to.GoToOrderPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to.GoToUpdateAuthorPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to.GoToUpdateBookCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.go_to.GoToUpdateGenrePageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.search.SearchCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.search.SearchUserCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.update.AdminOrderCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.update.UpdateAuthorCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.update.UpdateBookCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.update.UpdateGenreCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class CommandManager {
	private static Logger log;
	static {
		log = Logger.getRootLogger();
	}

	private static CommandManager commandManager = new CommandManager();
	private final Map<String, Command> commandList;

	private CommandManager() {

		commandList = new HashMap<String, Command>();

		commandList.put(ConstConteiner.COMMAND_PAGE_LOGIN, new LoginPageCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_SINGUP, new SingUpCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_SEARCH, new SearchCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_TO_ORDER, new GoToOrderPageCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_CREATE_ORDER, new CreateOrderUserCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_DELETE_ORDER, new DeleteOrderUserCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_DELETE_ORDER_NOT_CONFIRM, new DeleteNotConfirmOrderCommand());

		commandList.put(ConstConteiner.COMMAND_PAGE_LOGOUT, new LogoutCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_SEARCH_USER, new SearchUserCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_ADMIN_ORDER, new AdminOrderCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_DELETE_USER, new DeleteUserCommand());

		commandList.put(ConstConteiner.COMMAND_PAGE_TO_GENRE, new GoToGenrePageCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_TO_CREATE_GENRE, new GoToCreateGenrePageCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_TO_UPDATE_GENRE, new GoToUpdateGenrePageCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_CREATE_GENRE, new CreateGenreCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_DELETE_GENRE, new DeleteGenreComamand());
		commandList.put(ConstConteiner.COMMAND_PAGE_UPDATE_GENRE, new UpdateGenreCommand());

		commandList.put(ConstConteiner.COMMAND_PAGE_TO_AUTHOR, new GoToAuthorPageCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_TO_CREATE_AUTHOR, new GoToCreateAuthorPageCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_TO_UPDATE_AUTHOR, new GoToUpdateAuthorPageCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_CREATE_AUTHOR, new CreateAuthorCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_DELETE_AUTHOR, new DeleteAuthorCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_UPDATE_AUTHOR, new UpdateAuthorCommand());

		commandList.put(ConstConteiner.COMMAND_PAGE_TO_BOOK, new GoToBookPageCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_TO_CREATE_BOOK, new GoToCreateBookCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_CREATE_BOOK, new CreateBookCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_TO_UPDATE_BOOK, new GoToUpdateBookCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_DELETE_BOOK, new DeleteBookCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_UPDATE_BOOK, new UpdateBookCommand());

		commandList.put(ConstConteiner.CHANGE_LANGUAGE, new ChangeLangCommand());
	}

	public static CommandManager getInstance() {

		return commandManager;
	}

	public Command getCommand(String commandName) {

		if (commandName == null || commandName.equals("")) {
			commandName = ConstConteiner.COMMAND_PAGE_SEARCH;
		}
		log.trace("Command manager return command-" + commandName);
		return commandList.get(commandName);
	}
}
