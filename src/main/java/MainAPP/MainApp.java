package MainAPP;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.Command;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;

public class MainApp {

	public MainApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		try {
//			ConnectionPool.getInstanse().creatConnectionPool();
//		} catch (ConnectionPoolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		UserDAO userDao = DaoManager.getInstance().getUserDAO();
//
//		try {
//			System.out.println(userDao.getALL());
//			System.out.println(userDao.registration("cool", "cool", "Cool", RoleType.ADMIN));
//			// System.out.println(userDao.login("cool", "cool"));
//
//		} catch (DaoSQLExcetion | WrongLoginDateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		String commandName = null;
		CommandManager commandManager = CommandManager.getInstance();
		Command command = commandManager.getCommand(commandName);
		System.out.println(command);
	}

}
