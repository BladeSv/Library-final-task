package by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.beandao;

import java.util.List;

import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.dao.exception.DaoSQLExcetion;
import by.epam.javawebtraiming.mitrahovich.finaltask.library.model.entity.bean.Item;

public interface DAO<T extends Item> {
	T getById(int id) throws DaoSQLExcetion;

	List<T> getALL() throws DaoSQLExcetion;
}
