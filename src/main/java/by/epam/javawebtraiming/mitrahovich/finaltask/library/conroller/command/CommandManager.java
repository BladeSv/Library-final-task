package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.AdminOrderCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.CreateOrderCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.DeleteBookCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.DeleteOrderCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.DeleteUserCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.GoToOrderPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.LoginPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.LogoutCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.SearchCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.SearchUserCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.SingUpCommand;
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
		commandList.put(ConstConteiner.COMMAND_PAGE_DELETE_BOOK, new DeleteBookCommand());
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
