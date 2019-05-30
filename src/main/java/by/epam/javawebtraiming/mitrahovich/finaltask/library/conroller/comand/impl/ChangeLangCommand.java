package by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.comand.impl;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.AbstractCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.CommandManager;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.conroller.command.ResultCommand;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.util.conteiner.ConstConteiner;

public class ChangeLangCommand extends AbstractCommand {

	public ChangeLangCommand() {

	}

	@Override
	public ResultCommand execute(HttpServletRequest request, HttpServletResponse response) {

		if (request == null || response == null) {
			return null;
		}

		String userLocale = request.getParameter(ConstConteiner.LANG);
		if (userLocale != null) {

			if (userLocale.equals(ConstConteiner.RU_LOCALE)) {
				Config.set(request.getSession(), Config.FMT_LOCALE, new Locale(ConstConteiner.RU_LOCALE));
				request.getSession().setAttribute(ConstConteiner.LANG, ConstConteiner.RU_LOCALE);

			} else if (userLocale.equals(ConstConteiner.EN_LOCALE)) {
				Config.set(request.getSession(), Config.FMT_LOCALE, new Locale(ConstConteiner.EN_LOCALE));
				request.getSession().setAttribute(ConstConteiner.LANG, ConstConteiner.EN_LOCALE);
			}
		}
		return CommandManager.getInstance().getCommand(ConstConteiner.SEARCH).execute(request, response);
	}

}
