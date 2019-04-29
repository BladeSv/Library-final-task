package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.IndexPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.LoginPageCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl.SearchCommand;
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
		commandList = new HashMap<>();

		commandList.put(ConstConteiner.COMMAND_PAGE_INDEX, new IndexPageCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_LOGIN, new LoginPageCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_SINGUP, new SingUpCommand());
		commandList.put(ConstConteiner.COMMAND_PAGE_SEARCH, new SearchCommand());
//		Properties properties = new Properties();
//
//		try {
//			InputStream inputStream = this.getClass().getClassLoader()
//					.getResourceAsStream(ManagerConfig.get("path.command.list"));
//			properties.load(inputStream);
//
//			Enumeration<?> commandNames = properties.propertyNames();
//			String currentCommandClassName;
//			String currentCommandName;
//
//			while (commandNames.hasMoreElements()) {
//
//				currentCommandName = (String) commandNames.nextElement();
//				currentCommandClassName = properties.getProperty(currentCommandName);
//				properties.put(currentCommandName, (Command) Class.forName(currentCommandClassName).newInstance());
//
//			}

//			for (String key : properties.stringPropertyNames()) {
//				Command value = (Command) Class.forName(properties.getProperty(key)).newInstance();
//				log.trace("put-command: " + key + " class- " + value.getClass().getSimpleName());
//				commandList.put(key, value);
//			}
//			currentCommandName = (String) commandNames.nextElement();
//			currentCommandClassName = property.getProperty(currentCommandName);
//			navigator.put(currentCommandName, (Command) Class.forName(currentCommandClassName).newInstance());

//		} catch (FileNotFoundException e) {
//
//			e.printStackTrace();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public static CommandManager getInstance() {

		return commandManager;
	}

	public Command getCommand(String commandName) {
		if (commandName == null || commandName.equals("")) {
			commandName = ConstConteiner.COMMAND_PAGE_INDEX;
		}
		return commandList.get(commandName);
	}
}
