package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Author;

public interface AuthorDAO extends DAO<Author> {
	void update(Author author) throws DaoSQLExcetion;

	void removeById(int id) throws DaoSQLExcetion;

	void add(String name, String surname) throws DaoSQLExcetion;
}
