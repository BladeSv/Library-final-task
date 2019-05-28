package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.AdminOrderCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.ChangeLangCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.CreateAuthorCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.CreateBookCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.CreateGenreCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.CreateOrderCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.DeleteAuthorCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.DeleteBookCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.DeleteGenreComamand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.DeleteOrderCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.DeleteUserCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.GoToAuthorPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.GoToBookPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.GoToCreateAuthorPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.GoToCreateBookCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.GoToCreateGenrePageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.GoToGenrePageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.GoToOrderPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.GoToUpdateAuthorPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.GoToUpdateBookCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.GoToUpdateGenrePageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.LoginPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.LogoutCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.SearchCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.SearchUserCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.SingUpCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.UpdateAuthorCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.UpdateBookCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.UpdateGenreCommand;
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
		commandList.put(ConstConteiner.COMMAND_PAGE_TO_ORDER, new GoToOrderPageCommand());

		commandList.put(ConstConteiner.COMMAND_PAGE_LOGIN, new LoginPageCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_SINGUP, new SingUpCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_SEARCH, new SearchCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_CREATE_ORDER, new CreateOrderCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_DELETE_ORDER, new DeleteOrderCommand());
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
