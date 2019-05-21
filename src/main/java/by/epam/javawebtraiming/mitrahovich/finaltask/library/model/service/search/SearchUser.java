package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.service.search;

import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.User;

public interface SearchUser {
	List<User> searchUser(String searchRequest) throws DaoSQLExcetion;

}
