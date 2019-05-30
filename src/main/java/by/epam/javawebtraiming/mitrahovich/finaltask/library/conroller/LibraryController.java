package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.Command;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand.Do;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.properties.ManagerConfig;

/**
 * Servlet implementation class LibraryConroller
 */
public class LibraryController extends HttpServlet {
	private static Logger log;

	static {
		log = Logger.getRootLogger();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LibraryController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.trace("start processRequest");
		String command = request.getParameter(ConstConteiner.COMMAND);
		log.trace("command--" + command);

		CommandManager commandManager = CommandManager.getInstance();

		Command requestCommand = commandManager.getCommand(command);

		ResultCommand page = requestCommand.execute(request, response);

		log.trace("choose command--" + requestCommand.getClass().getSimpleName() + " page-" + page);

		if (page != null || page.getPage() != null) {

			if (page.getAction() == Do.FORWARD) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page.getPage());
				dispatcher.forward(request, response);

			} else {

				response.sendRedirect(page.getPage());
			}

		} else {

			response.sendRedirect(request.getContextPath() + ManagerConfig.get("path.page.index"));
		}

	}

}
