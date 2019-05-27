package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Genre;

public interface GenreDAO extends DAO<Genre> {
	void update(Genre genre) throws DaoSQLExcetion;

	void removeById(int id) throws DaoSQLExcetion;

	void add(String title) throws DaoSQLExcetion;
}
