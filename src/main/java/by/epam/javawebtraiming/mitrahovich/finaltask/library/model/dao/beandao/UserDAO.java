package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.WrongLoginDateException;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.RoleType;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.User;

public interface UserDAO extends DAO<User> {
	User registration(String login, String pass, String name, String surname, RoleType role)
			throws DaoSQLExcetion, WrongLoginDateException;

	User login(String login, String pass) throws WrongLoginDateException, DaoSQLExcetion;

	void deteteUser(int id) throws DaoSQLExcetion;
}
